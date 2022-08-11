package com.example.mentorship.features.recyclerMultipleTypes

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class GroupedArticlesListViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

    abstract fun bind(item: GroupedArticlesListItem)
}