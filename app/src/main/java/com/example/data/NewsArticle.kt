package com.example.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news_articles")
data class NewsArticle(
    @PrimaryKey val id: String,
    val title: String,
    val source: String,
    val timeAgo: String,
    val category: String,
    val imageUrl: String,
    val summary: String,
    val content: String,
    val isViral: Boolean = true,
    val isSaved: Boolean = false,
    val timestamp: Long = System.currentTimeMillis()
)
