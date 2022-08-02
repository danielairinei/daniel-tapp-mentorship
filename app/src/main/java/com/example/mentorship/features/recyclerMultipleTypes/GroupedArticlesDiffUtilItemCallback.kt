package com.example.mentorship.features.recyclerMultipleTypes

import androidx.recyclerview.widget.DiffUtil

object GroupedArticlesDiffUtilItemCallback : DiffUtil.ItemCallback<GroupedArticlesListItem>() {

    override fun areItemsTheSame(
        newItem: GroupedArticlesListItem,
        oldItem: GroupedArticlesListItem
    ): Boolean = newItem.id == oldItem.id

    override fun areContentsTheSame(
        newItem: GroupedArticlesListItem,
        oldItem: GroupedArticlesListItem
    ): Boolean = newItem == oldItem
}