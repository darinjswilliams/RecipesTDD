package com.example.recipes.model.local

import android.content.Context
import android.content.res.AssetManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.recipes.model.Recipe
import com.example.recipes.model.readStream
import timber.log.Timber
import java.io.File
import java.io.InputStream

class RecipeStore(val context: Context, val directory: String) {

    val recipes = arrayListOf<Recipe>()


    init {
        val streams = getAssetStreams(context.assets, directory)

        streams.forEach {
            val recipe = readStream(it.bufferedReader().readLines())
            Timber.i("Read the following $it")
            if (recipe != null) {
                recipes.add(recipe)
                lookUpMap.put(recipe.id, recipe)
            }
        }
    }


    companion object  {
    val lookUpMap = hashMapOf<String, Recipe>()

        fun getAssetStreams(manager: AssetManager, directory: String): List<InputStream> {
            val filenames: Array<String>? = getFileNames(manager, directory)
            val streams = arrayListOf<InputStream>()

            filenames?.forEach {
                val file = File(directory, it)
                try {
                    val inputStream: InputStream = manager.open(file.path)
                    Timber.i("Name of file: $inputStream")
                    streams.add(inputStream)
                } catch (e: Exception) {
                    Timber.e("Exception ${e.localizedMessage}")
                }
            }
            return streams
        }

        //get all the files
        fun getFileNames(manager: AssetManager, directory: String): Array<String>? {

            try {
                Timber.i("Directory Name $directory")
                return manager.list(directory)
            } catch (e: Exception) {
                Timber.e("Exception: ${e.localizedMessage}")
                return emptyArray()
            }
        }

        fun getRecipe(recipeId: String): Recipe? {
            return lookUpMap.get(recipeId)
        }

        fun getAllRecipes(): LiveData<List<Recipe>> {

            val cacheList =
              Transformations.switchMap(lookUpMap, feed -> {
                return feed.values.toList()
            });
            return ca
        }

    }
}
