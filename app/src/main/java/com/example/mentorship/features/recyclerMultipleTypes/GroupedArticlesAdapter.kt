package com.example.mentorship.features.recyclerMultipleTypes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.mentorship.R
import com.example.mentorship.databinding.ItemArticleBinding
import com.example.mentorship.databinding.ItemHeaderMonthBinding

class GroupedArticlesAdapter : ListAdapter<GroupedArticlesListItem, GroupedArticlesListViewHolder>(GroupedArticlesDiffUtilItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupedArticlesListViewHolder {
        return when (viewType) {
            TYPE_ARTICLE -> ArticleViewHolder(ItemArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            TYPE_MONTH_HEADER -> MonthHeaderViewHolder(ItemHeaderMonthBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            else -> throw IllegalStateException("Unsupported viewType")
        }
    }

    override fun onBindViewHolder(holder: GroupedArticlesListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemViewType(position: Int): Int =
        when (getItem(position)) {
            is GroupedArticlesListItem.Article -> TYPE_ARTICLE
            is GroupedArticlesListItem.SectionHeader -> TYPE_MONTH_HEADER
        }

    companion object {
        private const val TYPE_ARTICLE = R.layout.item_article
        private const val TYPE_MONTH_HEADER = R.layout.item_header_month
    }
}