package com.example.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first

class NewsRepository(private val newsDao: NewsDao) {

    val allArticles: Flow<List<NewsArticle>> = newsDao.getAllArticles()
    val savedArticles: Flow<List<NewsArticle>> = newsDao.getSavedArticles()

    suspend fun seedDatabaseIfEmpty() {
        if (newsDao.getCount() == 0) {
            newsDao.insertArticles(SampleNewsData.initialArticles)
        }
    }

    suspend fun toggleBookmark(articleId: String) {
        val article = newsDao.getArticleById(articleId) ?: return
        newsDao.updateSavedStatus(articleId, !article.isSaved)
    }

    suspend fun getArticleById(articleId: String): NewsArticle? {
        return newsDao.getArticleById(articleId)
    }

    suspend fun insertMoreArticles(articles: List<NewsArticle>) {
        newsDao.insertArticles(articles)
    }
}
