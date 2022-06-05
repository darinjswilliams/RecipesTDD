package com.example.recipes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recipes.databinding.ListItemBinding
import com.example.recipes.model.Recipe

class RecycleListAdapter(private val clickListener: RecipeListener): ListAdapter<Recipe, RecipeViewHolder>(RecipeDiffCallBack) {

    companion object RecipeDiffCallBack : ItemCallback<Recipe>() {
        override fun areItemsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
            return newItem == oldItem
        }

        override fun areContentsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
       return RecipeViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipeProperty = getItem(position)
        holder.bind(recipeProperty)
    }

    override fun onCurrentListChanged(
        previousList: MutableList<Recipe>,
        currentList: MutableList<Recipe>
    ) {
        super.onCurrentListChanged(previousList, currentList)
    }

}

class RecipeListener(val clickListener: (recipe: Recipe) -> Unit){
    fun onClick(recipe: Recipe) = clickListener(recipe)
}

class RecipeViewHolder(private var binding: ListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(recipe: Recipe) {
        binding.recipeProperty = recipe
//        binding.recipeTile.text = recipe.title
        binding.executePendingBindings()
    }

    //Add Companion object to inflate viewholder
    //create the parent objecdt based om the view
    companion object {
        fun from(parent: ViewGroup) : RecipeViewHolder{
            return RecipeViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context)))
        }
    }
}