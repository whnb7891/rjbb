package com.rjbb.gg.ui

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor() : ViewModel() {

    fun updateSetting(key: String, value: String) {
        Timber.i("Updated setting $key = $value")
    }
}