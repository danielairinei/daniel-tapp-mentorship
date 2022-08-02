package com.example.mentorship.features.recyclerview

import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.mentorship.R
import com.example.mentorship.databinding.ItemDemoRecyclerBinding

class ArticleViewHolder(private val binding: ItemDemoRecyclerBinding, private val viewHolderIndex: Int) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(article: Article) {
        binding.articleTV.text = article.name
        binding.viewHolderTV.text = "ViewHolder index $viewHolderIndex"
        setBackgroundForIndex()
    }

    private fun setBackgroundForIndex() {
        val baseColor = ResourcesCompat.getColor(binding.root.resources, R.color.blue_200, null)
        binding.root.setBackgroundColor(baseColor + (viewHolderIndex * BASE_COLOR_MULTIPLIER).toInt())
    }

    companion object {
        private const val BASE_COLOR_MULTIPLIER = 3.5f
    }
}