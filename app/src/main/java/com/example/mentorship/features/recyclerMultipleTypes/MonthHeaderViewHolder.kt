package com.example.mentorship.features.recyclerMultipleTypes

import com.example.mentorship.databinding.ItemHeaderMonthBinding
import java.lang.IllegalArgumentException

class MonthHeaderViewHolder(private val binding: ItemHeaderMonthBinding) : GroupedArticlesListViewHolder(binding) {

    override fun bind(item: GroupedArticlesListItem) {
        val monthHeader = (item as? GroupedArticlesListItem.SectionHeader)
            ?: throw IllegalArgumentException("Unable to cast item to ArticleListItem.SectionHeader")
        binding.monthHeaderTV.text = monthHeader.date.toString()
    }
}