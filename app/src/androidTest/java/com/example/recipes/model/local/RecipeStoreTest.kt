package com.example.recipes.model.local

import androidx.test.platform.app.InstrumentationRegistry
import com.example.recipes.model.local.RecipeStore.Companion.getRecipe
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.notNullValue
import org.junit.Test

class RecipeStoreTest {

    @Test
    fun recipeStore_nullDirectory() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val recipeStore = RecipeStore(context, null.toString())
        assertThat(recipeStore, notNullValue())
        assertThat(recipeStore.recipes, notNullValue())
        assertThat(recipeStore.recipes.size, `is`(0))
    }

    @Test
    fun recipeStore_countRecipes() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val recipeStore = RecipeStore(context, "recipes")
        assertThat(recipeStore, notNullValue())
        assertThat(recipeStore.recipes, notNullValue())
        assertThat(recipeStore.recipes.size, `is`(4))
    }

    @Test
    fun recipeStore_chocolatePudding() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val recipeStore = RecipeStore(context, "recipes")
        assertThat(recipeStore, notNullValue())
        val recipeId = getRecipe("chocolate_pudding")
        assertThat(recipeId?.id, `is`("chocolate_pudding"))
        assertThat(recipeId?.title, `is`("Chocolate Pudding"))
    }
}