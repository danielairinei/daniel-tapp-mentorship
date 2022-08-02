package com.example.mentorship.features.recyclerMultipleTypes

import java.util.*

sealed class GroupedArticlesListItem(val id: Long) {

    data class Article(
        val articleId: Long,
        val title: String,
        val author: String,
        val date: Date
    ) : GroupedArticlesListItem(articleId)

    data class SectionHeader(
        val date: Date
    ) : GroupedArticlesListItem(date.time)
}