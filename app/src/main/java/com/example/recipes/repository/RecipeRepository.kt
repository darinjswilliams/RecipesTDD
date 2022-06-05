package com.example.recipes.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.recipes.model.Recipe
import com.example.recipes.model.local.RecipeStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RecipeRepository(val context: Context, val directory: String) {

    lateinit var recipeList: LiveData<List<Recipe>>

    suspend fun retrieveFiles() {
        withContext(Dispatchers.IO) {
            retrieveInputFiles()
        }
    }

    private suspend fun retrieveInputFiles() {

        recipeList = RecipeStore.getAllRecipes()
    }
}