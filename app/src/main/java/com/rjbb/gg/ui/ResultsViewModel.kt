package com.rjbb.gg.ui

import androidx.lifecycle.ViewModel
import com.rjbb.gg.domain.memory.MemoryModifier
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ResultsViewModel @Inject constructor(
    private val memoryModifier: MemoryModifier
) : ViewModel() {

    private val _searchResults = MutableStateFlow<List<Long>>(emptyList())
    val searchResults: StateFlow<List<Long>> = _searchResults

    fun selectResult(address: Long) {
        Timber.i("Selected result: 0x${address.toString(16)}")
        // Handle selection
    }

    fun updateResults(results: List<Long>) {
        _searchResults.value = results
    }
}