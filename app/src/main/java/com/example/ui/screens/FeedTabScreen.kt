package com.example.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.NewsArticle
import com.example.ui.components.BreakingNewsBanner
import com.example.ui.components.CategoryChipsBar
import com.example.ui.components.NewsCard
import com.example.ui.theme.NavyContainer
import com.example.ui.theme.NavyPrimary

@Composable
fun FeedTabScreen(
    articles: List<NewsArticle>,
    selectedCategory: String,
    onCategorySelected: (String) -> Unit,
    onArticleClick: (NewsArticle) -> Unit,
    onBookmarkToggle: (String) -> Unit,
    onListenClick: (NewsArticle) -> Unit,
    onLoadMoreClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxSize()) {
        // Breaking News Banner Ticker
        BreakingNewsBanner(
            onBannerClick = {
                if (articles.isNotEmpty()) {
                    onListenClick(articles.first())
                }
            }
        )

        // Category Chips Row
        CategoryChipsBar(
            selectedCategory = selectedCategory,
            onCategorySelected = onCategorySelected
        )

        if (articles.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(32.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        imageVector = Icons.Default.Newspaper,
                        contentDescription = null,
                        modifier = Modifier.padding(16.dp),
                        tint = MaterialTheme.colorScheme.outline
                    )
                    Text(
                        text = "No se encontraron noticias en esta categoría.",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        textAlign = TextAlign.Center
                    )
                }
            }
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(articles, key = { it.id }) { article ->
                    NewsCard(
                        article = article,
                        onArticleClick = onArticleClick,
                        onBookmarkToggle = onBookmarkToggle,
                        onListenClick = onListenClick
                    )
                }

                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        OutlinedButton(
                            onClick = onLoadMoreClick,
                            shape = RoundedCornerShape(24.dp),
                            colors = ButtonDefaults.outlinedButtonColors(contentColor = NavyPrimary)
                        ) {
                            Text(
                                text = "Cargar más noticias",
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Icon(
                                imageVector = Icons.Default.ExpandMore,
                                contentDescription = null
                            )
                        }
                    }
                }

                // Spacing at bottom for FAB / Voice Player
                item {
                    Spacer(modifier = Modifier.height(100.dp))
                }
            }
        }
    }
}
