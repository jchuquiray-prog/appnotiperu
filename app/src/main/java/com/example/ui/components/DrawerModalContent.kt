package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.MainTab
import com.example.ui.theme.NavyContainer
import com.example.ui.theme.NavyPrimary

@Composable
fun DrawerModalContent(
    selectedCategory: String,
    onCategorySelected: (String) -> Unit,
    onTabSelected: (MainTab) -> Unit,
    onCloseDrawer: () -> Unit
) {
    ModalDrawerSheet(
        modifier = Modifier
            .width(300.dp)
            .fillMaxHeight()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            // Header
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(NavyPrimary)
                    .padding(20.dp)
            ) {
                Column {
                    Text(
                        text = "Perú Político",
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Text(
                        text = "Información con autonomía y rigor",
                        color = Color.White.copy(alpha = 0.8f),
                        fontSize = 12.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Main sections
            DrawerSectionTitle("SECCIONES PRINCIPALES")

            DrawerMenuItem(
                label = "Feed Principal",
                icon = Icons.Default.Newspaper,
                onClick = {
                    onTabSelected(MainTab.FEED)
                    onCloseDrawer()
                }
            )

            DrawerMenuItem(
                label = "Radio & Boletín Hablado",
                icon = Icons.Default.VolumeUp,
                onClick = {
                    onTabSelected(MainTab.ESCUCHAR)
                    onCloseDrawer()
                }
            )

            DrawerMenuItem(
                label = "Noticias Guardadas",
                icon = Icons.Default.Bookmark,
                onClick = {
                    onTabSelected(MainTab.GUARDADOS)
                    onCloseDrawer()
                }
            )

            HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp, horizontal = 16.dp))

            // Categories
            DrawerSectionTitle("CATEGORÍAS POLÍTICAS")

            listOf("Todas", "Congreso", "Ejecutivo", "Economía", "Judicial", "Regiones", "Electoral").forEach { category ->
                val isSelected = category.equals(selectedCategory, ignoreCase = true)
                NavigationDrawerItem(
                    label = {
                        Text(
                            text = category,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
                        )
                    },
                    selected = isSelected,
                    onClick = {
                        onCategorySelected(category)
                        onTabSelected(MainTab.FEED)
                        onCloseDrawer()
                    },
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 2.dp),
                    colors = NavigationDrawerItemDefaults.colors(
                        selectedContainerColor = NavyContainer,
                        selectedTextColor = Color.White,
                        unselectedTextColor = MaterialTheme.colorScheme.onSurface
                    )
                )
            }

            HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp, horizontal = 16.dp))

            // About
            DrawerSectionTitle("PERÚ POLÍTICO v1.0")

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = null,
                    tint = NavyPrimary,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = "Aplicación oficial de síntesis y monitoreo político peruano con inteligencia de audio.",
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    lineHeight = 16.sp
                )
            }
        }
    }
}

@Composable
private fun DrawerSectionTitle(title: String) {
    Text(
        text = title,
        fontSize = 11.sp,
        fontWeight = FontWeight.ExtraBold,
        color = NavyPrimary,
        letterSpacing = 1.sp,
        modifier = Modifier.padding(horizontal = 20.dp, vertical = 8.dp)
    )
}

@Composable
private fun DrawerMenuItem(
    label: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(horizontal = 20.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = NavyPrimary,
            modifier = Modifier.size(22.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = label,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}
