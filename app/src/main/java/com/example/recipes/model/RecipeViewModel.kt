package com.example.recipes.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import timber.log.Timber

class RecipeViewModel(application: Application) : AndroidViewModel(application) {

    private val _recipes = MutableLiveData<Recipe>()

    val recipes: LiveData<Recipe>
        get() = _recipes

    init {
        viewModelScope.launch {

        }
    }

    fun displayRecipes(recipe: Recipe) {
        Timber.i("Display Recipe ID data.. ${recipe.id}")
        Timber.i("Display Recipe Title .. ${recipe.title}")
        _recipes.value = recipe
    }
}