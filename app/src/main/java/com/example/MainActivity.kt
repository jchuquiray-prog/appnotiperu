package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ui.MainTab
import com.example.ui.MainViewModel
import com.example.ui.components.ArticleDetailView
import com.example.ui.components.BottomNavBarComponent
import com.example.ui.components.DrawerModalContent
import com.example.ui.components.FloatingAudioButton
import com.example.ui.components.TopAppBarComponent
import com.example.ui.components.VoicePlayerBar
import com.example.ui.screens.AudioTabScreen
import com.example.ui.screens.FeedTabScreen
import com.example.ui.screens.SavedTabScreen
import com.example.ui.theme.PeruPoliticoTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            PeruPoliticoTheme {
                MainAppScreen(viewModel = viewModel)
            }
        }
    }
}

@Composable
fun MainAppScreen(viewModel: MainViewModel) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val currentTab by viewModel.currentTab.collectAsState()
    val selectedCategory by viewModel.selectedCategory.collectAsState()
    val searchQuery by viewModel.searchQuery.collectAsState()
    val isSearchVisible by viewModel.isSearchVisible.collectAsState()

    val filteredArticles by viewModel.filteredArticles.collectAsState()
    val savedArticles by viewModel.savedArticles.collectAsState()
    val selectedArticleDetail by viewModel.selectedArticleDetail.collectAsState()

    val audioState by viewModel.audioState.collectAsState()

    // If an article detail is selected, show ArticleDetailView
    val selectedDetail = selectedArticleDetail
    if (selectedDetail != null) {
        ArticleDetailView(
            article = selectedDetail,
            onBackClick = { viewModel.closeArticleDetail() },
            onBookmarkToggle = { viewModel.toggleBookmark(it) },
            onListenClick = { viewModel.speakArticle(it) }
        )
        return
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerModalContent(
                selectedCategory = selectedCategory,
                onCategorySelected = { viewModel.selectCategory(it) },
                onTabSelected = { viewModel.selectTab(it) },
                onCloseDrawer = {
                    scope.launch { drawerState.close() }
                }
            )
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBarComponent(
                    isSearchVisible = isSearchVisible,
                    searchQuery = searchQuery,
                    onSearchQueryChange = { viewModel.setSearchQuery(it) },
                    onToggleSearch = { viewModel.toggleSearch() },
                    onOpenDrawer = {
                        scope.launch { drawerState.open() }
                    }
                )
            },
            bottomBar = {
                BottomNavBarComponent(
                    currentTab = currentTab,
                    onTabSelected = { viewModel.selectTab(it) }
                )
            },
            floatingActionButton = {
                if (currentTab == MainTab.FEED && audioState.currentArticleId == null) {
                    FloatingAudioButton(
                        onClick = {
                            if (filteredArticles.isNotEmpty()) {
                                viewModel.speakArticle(filteredArticles.first())
                            }
                        },
                        modifier = Modifier.padding(bottom = 12.dp)
                    )
                }
            }
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                AnimatedContent(
                    targetState = currentTab,
                    transitionSpec = { fadeIn() togetherWith fadeOut() },
                    label = "TabSwitch"
                ) { targetTab ->
                    when (targetTab) {
                        MainTab.FEED -> {
                            FeedTabScreen(
                                articles = filteredArticles,
                                selectedCategory = selectedCategory,
                                onCategorySelected = { viewModel.selectCategory(it) },
                                onArticleClick = { viewModel.openArticleDetail(it) },
                                onBookmarkToggle = { viewModel.toggleBookmark(it) },
                                onListenClick = { viewModel.speakArticle(it) },
                                onLoadMoreClick = { viewModel.loadMoreNews() }
                            )
                        }

                        MainTab.ESCUCHAR -> {
                            AudioTabScreen(
                                articles = filteredArticles,
                                audioState = audioState,
                                onListenClick = { viewModel.speakArticle(it) },
                                onPause = { viewModel.pauseAudio() },
                                onResume = { viewModel.resumeAudio() },
                                onSpeedChange = { viewModel.setSpeechRate(it) },
                                onArticleClick = { viewModel.openArticleDetail(it) }
                            )
                        }

                        MainTab.GUARDADOS -> {
                            SavedTabScreen(
                                savedArticles = savedArticles,
                                onArticleClick = { viewModel.openArticleDetail(it) },
                                onBookmarkToggle = { viewModel.toggleBookmark(it) },
                                onListenClick = { viewModel.speakArticle(it) }
                            )
                        }
                    }
                }

                // Persistent Sliding Voice Player Bar
                VoicePlayerBar(
                    audioState = audioState,
                    onPause = { viewModel.pauseAudio() },
                    onResume = { viewModel.resumeAudio() },
                    onClose = { viewModel.stopAudio() },
                    modifier = Modifier.align(Alignment.BottomCenter)
                )
            }
        }
    }
}
