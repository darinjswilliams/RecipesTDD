package com.example.recipes.model

import com.example.recipes.model.Prefix.ID_PREFIX
import com.example.recipes.model.Prefix.TITLE_PREFIX


data class Recipe(val id: String, val title: String, val desc: String)

fun readStream(input: List<String>): Recipe? {
    var myId = String()
    lateinit var title: String
    val descBuilder = StringBuilder()

    //Skip the prexfx and extact the value
    for(line in input){
        if(line.startsWith(ID_PREFIX)){
            myId = line.substring(ID_PREFIX.length)
            continue
        }
        if(line.startsWith(TITLE_PREFIX)){
            title = line.substring(TITLE_PREFIX.length)
            continue
        }

        if(descBuilder.length > 0){
            descBuilder.append("\n")
        }
        descBuilder.append(line)

    }

    return Recipe(myId, title, descBuilder.toString())
}

object Prefix {
    const val ID_PREFIX = "id="
    const val TITLE_PREFIX = "title="
}

