package com.dexterverse.myrecipeapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class MainViewModel : ViewModel() {
    // type
    data class RecipeState(
        val loading: Boolean = true,
        val list: List<Category> = emptyList(),
        val error: String? = null
    )

    // state private and public
    private val _categoriesState = mutableStateOf(RecipeState())
    val categoriesState: State<RecipeState> = _categoriesState

    //constructor i guess
    init {
        fetchCategories()
    }

    // Fetching Api
    private fun fetchCategories() {
        viewModelScope.launch {
            try {
                val response = recipeService.getCategories()
                _categoriesState.value = _categoriesState.value.copy(
                    list = response.categories,
                    loading = false,
                    error = null,
                )
            } catch (e: Exception) {
                _categoriesState.value = _categoriesState.value.copy(
                    list = emptyList(),
                    loading = false,
                    error = "Error fetching categories ${e.message}"
                )
            }
        }
    }

}