package com.example.mentorship.features.recyclerview

import androidx.recyclerview.widget.DiffUtil

object ArticleDiffUtilCallback : DiffUtil.ItemCallback<Article>() {

    override fun areItemsTheSame(
        newItem : Article,
        oldItem : Article
    ) : Boolean = newItem.id == oldItem.id

    override fun areContentsTheSame(
        newItem : Article,
        oldItem : Article
    ) : Boolean = newItem == oldItem
}