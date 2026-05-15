package com.rjbb.gg.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.rjbb.gg.ui.ResultsViewModel

@Composable
fun ResultsScreen(
    viewModel: ResultsViewModel,
    navController: NavHostController
) {
    val results by viewModel.searchResults.collectAsState(initial = emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            }
            Text(
                "搜索结果 (${results.size})",
                style = MaterialTheme.typography.headlineSmall
            )
        }

        if (results.isEmpty()) {
            Text(
                "未找到结果",
                modifier = Modifier.padding(16.dp)
            )
        } else {
            LazyColumn {
                items(results) { result ->
                    ResultItem(result) { address ->
                        viewModel.selectResult(address)
                        // 可以导航到修改屏幕
                    }
                }
            }
        }
    }
}

@Composable
fun ResultItem(
    address: Long,
    onSelect: (Long) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                "0x${address.toString(16).uppercase()}",
                style = MaterialTheme.typography.bodyMedium
            )
            Button(
                onClick = { onSelect(address) },
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Text("修改")
            }
        }
    }
}