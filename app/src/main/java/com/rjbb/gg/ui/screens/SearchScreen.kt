package com.rjbb.gg.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.rjbb.gg.ui.SearchViewModel

@Composable
fun SearchScreen(
    viewModel: SearchViewModel,
    navController: NavHostController
) {
    var searchValue by remember { mutableStateOf("") }
    var selectedDataType by remember { mutableStateOf("INT") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            "GG 修改器",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        OutlinedTextField(
            value = searchValue,
            onValueChange = { searchValue = it },
            label = { Text("输入搜索值") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        ExposedDropdownMenuBox(
            expanded = false,
            onExpandedChange = {}
        ) {
            OutlinedTextField(
                value = selectedDataType,
                onValueChange = { selectedDataType = it },
                label = { Text("数据类型") },
                modifier = Modifier.fillMaxWidth(),
                readOnly = true
            )
        }

        Button(
            onClick = {
                viewModel.search(searchValue, selectedDataType)
                navController.navigate("results")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp),
            enabled = searchValue.isNotEmpty()
        ) {
            Icon(Icons.Default.Search, contentDescription = "Search")
            Spacer(modifier = Modifier.width(8.dp))
            Text("搜索")
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = { navController.navigate("settings") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("设置")
        }
    }
}