package com.example.mentorship.features.recyclerMultipleTypes

import android.annotation.SuppressLint
import com.example.mentorship.databinding.ItemArticleBinding
import java.text.SimpleDateFormat

class ArticleViewHolder(private val binding: ItemArticleBinding) : GroupedArticlesListViewHolder(binding) {

    @SuppressLint("SimpleDateFormat")
    override fun bind(item: GroupedArticlesListItem) {
        val article =
            (item as? GroupedArticlesListItem.Article) ?: throw IllegalArgumentException("Unable to cast item to ArticleListItem.Article")
        binding.articleAuthorTV.text = article.author
        binding.articleNameTV.text = article.title
        binding.articleDateTV.text = SimpleDateFormat("dd-MM-yyyy").format(article.date)
    }
}