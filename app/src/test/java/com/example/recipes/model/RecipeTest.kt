package com.example.recipes.model

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.notNullValue
import org.junit.Test

class RecipeTest{
    @Test
    fun water(){
        val stream = this::class.java.getResourceAsStream("/recipes/water.txt")
            ?.bufferedReader()?.readLines()
        assertThat(stream, notNullValue())

        val recipe = stream?.let { readStream(it) }
        assertThat(recipe?.id, `is`("water"))
        assertThat(recipe?.title,  `is`("Water"))
        assertThat(recipe?.desc,  `is`("Put glass under tap. Open tap. Close tap. Drink."))
    }

    @Test
    fun mix(){
        val stream = this::class.java.getResourceAsStream("/recipes/mixed.txt")
            ?.bufferedReader()?.readLines()
        assertThat(stream, notNullValue())

        val recipe = stream?.let { readStream(it) }
        assertThat(recipe?.id, `is`("punch"))
        assertThat(recipe?.title,  `is`("Punch"))
        assertThat(recipe?.desc,  `is`("Juice of 3 lemons\n" +
                "1 orange\n" +
                "1 pint grape juice\n" +
                "1 cup sugar\n" +
                "1 cup water\n" +
                "1 pine apple juice\n" +
                "Mix all together and strain. Add large piece of ice."))
    }
}