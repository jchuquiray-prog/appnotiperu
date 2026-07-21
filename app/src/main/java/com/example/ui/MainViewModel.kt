package com.example.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.audio.AudioNarrator
import com.example.audio.AudioState
import com.example.data.AppDatabase
import com.example.data.NewsArticle
import com.example.data.NewsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

enum class MainTab {
    FEED, ESCUCHAR, GUARDADOS
}

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: NewsRepository
    private val audioNarrator = AudioNarrator(application)

    val audioState: StateFlow<AudioState> = audioNarrator.audioState

    private val _selectedCategory = MutableStateFlow("Todas")
    val selectedCategory: StateFlow<String> = _selectedCategory

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    private val _currentTab = MutableStateFlow(MainTab.FEED)
    val currentTab: StateFlow<MainTab> = _currentTab

    private val _selectedArticleDetail = MutableStateFlow<NewsArticle?>(null)
    val selectedArticleDetail: StateFlow<NewsArticle?> = _selectedArticleDetail

    private val _isSearchVisible = MutableStateFlow(false)
    val isSearchVisible: StateFlow<Boolean> = _isSearchVisible

    private val _isDrawerOpen = MutableStateFlow(false)
    val isDrawerOpen: StateFlow<Boolean> = _isDrawerOpen

    val allArticles: StateFlow<List<NewsArticle>>
    val filteredArticles: StateFlow<List<NewsArticle>>
    val savedArticles: StateFlow<List<NewsArticle>>

    init {
        val newsDao = AppDatabase.getDatabase(application).newsDao()
        repository = NewsRepository(newsDao)

        viewModelScope.launch {
            repository.seedDatabaseIfEmpty()
        }

        allArticles = repository.allArticles.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )

        savedArticles = repository.savedArticles.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )

        filteredArticles = combine(allArticles, selectedCategory, searchQuery) { articles, category, query ->
            articles.filter { article ->
                val matchesCategory = if (category == "Todas") true else article.category.contains(category, ignoreCase = true)
                val matchesQuery = if (query.isBlank()) true else {
                    article.title.contains(query, ignoreCase = true) ||
                            article.source.contains(query, ignoreCase = true) ||
                            article.summary.contains(query, ignoreCase = true)
                }
                matchesCategory && matchesQuery
            }
        }.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )
    }

    fun selectCategory(category: String) {
        _selectedCategory.value = category
    }

    fun setSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun selectTab(tab: MainTab) {
        _currentTab.value = tab
    }

    fun openArticleDetail(article: NewsArticle) {
        _selectedArticleDetail.value = article
    }

    fun closeArticleDetail() {
        _selectedArticleDetail.value = null
    }

    fun toggleBookmark(articleId: String) {
        viewModelScope.launch {
            repository.toggleBookmark(articleId)
            // Update selected article detail if open
            if (_selectedArticleDetail.value?.id == articleId) {
                val updated = repository.getArticleById(articleId)
                _selectedArticleDetail.value = updated
            }
        }
    }

    fun speakArticle(article: NewsArticle) {
        audioNarrator.speak(article.id, article.title, article.summary)
    }

    fun pauseAudio() {
        audioNarrator.pause()
    }

    fun resumeAudio() {
        audioNarrator.resume()
    }

    fun stopAudio() {
        audioNarrator.stopAndClose()
    }

    fun setSpeechRate(rate: Float) {
        audioNarrator.setSpeed(rate)
    }

    fun toggleSearch() {
        _isSearchVisible.value = !_isSearchVisible.value
        if (!_isSearchVisible.value) {
            _searchQuery.value = ""
        }
    }

    fun toggleDrawer(open: Boolean) {
        _isDrawerOpen.value = open
    }

    fun loadMoreNews() {
        viewModelScope.launch {
            val count = allArticles.value.size + 1
            val extraArticle = NewsArticle(
                id = "news_more_$count",
                title = "ONPE capacita a miembros de mesa para las elecciones distritales en 12 regiones",
                source = "El Comercio",
                timeAgo = "Hace instantes",
                category = "Electoral",
                imageUrl = "https://lh3.googleusercontent.com/aida-public/AB6AXuAqyQThgI28MfnOR26zzkCzZYVgVANSYrwyFk64OHuTZ2Lbq4duHMORlHWbdgmGsPYaG7vGbemyso7qiitzaWiB343u6zISAJT-Hii9liPYsQ6nKq71TmqpOb0W6S2U_DYow9kKByCrgGkeyyvhtKa_h0v3UE12rH5STSGceEJxrHK6Js_czPXNsMlWJFks9Daml5v6SY0T5lw_mUWmTh-niN-fL-J6GtJUVzdZa20irAGK8nbg0qjQBLsYgj7ppiBOl2ftH4Ansovh",
                summary = "La Oficina Nacional de Procesos Electorales inició talleres presenciales y virtuales orientados a fiscalizadores y miembros de mesa designados.",
                content = "La ONPE inició de forma simultánea los talleres de capacitación para miembros de mesa en las sedes regionales habilitadas a nivel nacional.",
                isViral = true,
                isSaved = false
            )
            repository.insertMoreArticles(listOf(extraArticle))
        }
    }

    override fun onCleared() {
        super.onCleared()
        audioNarrator.shutdown()
    }
}
