package com.example.mentorship.features.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.mentorship.databinding.ItemDemoRecyclerBinding

class ArticleAdapter : ListAdapter<Article, ArticleViewHolder>(ArticleDiffUtilCallback) {

    private var viewHolderIndex = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val binding = ItemDemoRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        ++viewHolderIndex
        return ArticleViewHolder(binding, viewHolderIndex)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    override fun getItemCount(): Int = currentList.size
}