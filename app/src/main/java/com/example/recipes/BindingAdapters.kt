package com.example.recipes

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recipes.model.Recipe
import timber.log.Timber

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Recipe>?){
    Timber.i("Size of data %s...", data?.size)
    val adapter = recyclerView.adapter as RecycleListAdapter
    adapter.submitList(data)
}