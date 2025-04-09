package com.sw.fred.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sw.fred.data.domain.Category
import com.sw.fred.data.repository.MealDbRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: MealDbRepository,
): ViewModel() {

    private var _categories: MutableStateFlow<List<Category>> = MutableStateFlow(emptyList())
    val category = _categories.asStateFlow()

    /**
     * Fetches the list of categories from the repository and emits it to the UI.
     */
    fun getCategories() {
        viewModelScope.launch {
            try {
                _categories.emit(repository.getCategories())
            } catch (e: Exception) {
                Log.e("HomeViewModel", e.toString())
            }
        }
    }
}
