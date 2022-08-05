package com.example.mentorship.features.recyclerMultipleTypes

import android.annotation.SuppressLint
import com.example.mentorship.databinding.ItemHeaderMonthBinding
import java.text.SimpleDateFormat

class MonthHeaderViewHolder(private val binding: ItemHeaderMonthBinding) : GroupedArticlesListViewHolder(binding) {

    @SuppressLint("SimpleDateFormat")
    override fun bind(item: GroupedArticlesListItem) {
        val monthHeader = (item as? GroupedArticlesListItem.SectionHeader)
            ?: throw IllegalArgumentException("Unable to cast item to ArticleListItem.SectionHeader")
        binding.root.text = SimpleDateFormat("dd-MM-yyyy").format(monthHeader.date)
    }
}