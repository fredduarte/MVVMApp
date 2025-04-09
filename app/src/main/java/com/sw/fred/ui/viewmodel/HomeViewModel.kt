package com.sw.fred.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sw.fred.data.domain.Category
import com.sw.fred.data.domain.Recipe
import com.sw.fred.data.repository.MealDbRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: MealDbRepository,
): ViewModel() {

    // StateFlow to hold the list of ALL Categories
    private var _categories: MutableStateFlow<List<Category>> = MutableStateFlow(emptyList())

    // StateFlow to hold the ViewState list of ALL Recipes.
    // Category & Recipes info combined.
    private var _viewState: MutableStateFlow<ViewState> = MutableStateFlow(ViewState.Loading)
    val viewState = _viewState.asStateFlow()

    init {
        getRecipesForAllCategories()
    }

    private fun getRecipesForAllCategories() {
        _viewState.value = ViewState.Loading
        viewModelScope.launch(Dispatchers.IO) {
            try {
                // Fetch all categories
                val categories = repository.getCategories()

                val allCategoryRecipes = mutableListOf<CategoryRecipes>()
                // Fetch recipes for ALL categories
                categories.forEach { category ->
                    val recipes = withContext(Dispatchers.IO) {
                        repository.getRecipesByCategory(category = category.name)
                    }

                    allCategoryRecipes.add(
                        CategoryRecipes(category = category, recipes = recipes),
                    )
                }

                // Update the Recipes observable with the new ViewState
                _viewState.value = ViewState.Success(
                    categoryRecipes = allCategoryRecipes,
                )
            } catch (e: Exception) {
                Log.e(TAG, e.toString())
                _viewState.value = ViewState.Error(
                    message = e.message,
                )
            }
        }
    }

    sealed interface ViewState {
        data class Success(
            val categoryRecipes: List<CategoryRecipes>,
        ) : ViewState

        data class Error(
            val message: String?,
        ) : ViewState

        object Loading : ViewState

        object NoResults : ViewState
    }

    data class CategoryRecipes(
        val category: Category,
        val recipes: List<Recipe>,
    )

    companion object {
        private const val TAG = "HomeViewModel"
    }
}
