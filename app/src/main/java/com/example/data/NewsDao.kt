package com.example.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {
    @Query("SELECT * FROM news_articles ORDER BY timestamp DESC")
    fun getAllArticles(): Flow<List<NewsArticle>>

    @Query("SELECT * FROM news_articles WHERE isSaved = 1 ORDER BY timestamp DESC")
    fun getSavedArticles(): Flow<List<NewsArticle>>

    @Query("SELECT * FROM news_articles WHERE id = :id LIMIT 1")
    suspend fun getArticleById(id: String): NewsArticle?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticles(articles: List<NewsArticle>)

    @Query("UPDATE news_articles SET isSaved = :isSaved WHERE id = :id")
    suspend fun updateSavedStatus(id: String, isSaved: Boolean)

    @Query("SELECT COUNT(*) FROM news_articles")
    suspend fun getCount(): Int
}
