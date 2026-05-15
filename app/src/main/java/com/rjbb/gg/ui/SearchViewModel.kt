package com.rjbb.gg.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rjbb.gg.domain.search.SearchEngine
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchEngine: SearchEngine
) : ViewModel() {

    fun search(value: String, dataType: String) {
        viewModelScope.launch {
            try {
                Timber.i("Searching for value: $value, type: $dataType")
                val results = searchEngine.search(value, dataType)
                Timber.i("Found ${results.size} results")
            } catch (e: Exception) {
                Timber.e(e, "Search failed")
            }
        }
    }
}