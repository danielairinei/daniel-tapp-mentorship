package com.example.mentorship.features.recyclerMultipleTypes

import com.example.mentorship.databinding.ItemArticleBinding
import java.lang.IllegalArgumentException

class ArticleViewHolder(private val binding: ItemArticleBinding) : GroupedArticlesListViewHolder(binding) {

    override fun bind(item: GroupedArticlesListItem) {
        val article =
            (item as? GroupedArticlesListItem.Article) ?: throw IllegalArgumentException("Unable to cast item to ArticleListItem.Article")
        binding.articleAuthorTV.text = article.author
        binding.articleNameTV.text = article.title
        binding.articleDateTV.text = article.date.toString()
    }
}