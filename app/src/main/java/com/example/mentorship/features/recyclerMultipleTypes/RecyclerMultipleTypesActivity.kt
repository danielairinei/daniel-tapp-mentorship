package com.example.mentorship.features.recyclerMultipleTypes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mentorship.databinding.ActivityRecyclerMultipleTypesBinding
import com.example.mentorship.viewBinding
import java.util.*

class RecyclerMultipleTypesActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityRecyclerMultipleTypesBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val recyclerAdapter = GroupedArticlesAdapter()
        binding.multipleTypesListRV.adapter = recyclerAdapter
        binding.multipleTypesListRV.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        recyclerAdapter.submitList(getGroupedArticles())
    }

    private fun getGroupedArticles(): List<GroupedArticlesListItem> {
        val articlesList = mutableListOf<GroupedArticlesListItem>()
        val calendar = Calendar.getInstance()
        var date = calendar.time
        (1..100L).forEach { index ->
            if (index % SECTION_DAYS_COUNT == 0L) {
                calendar.add(Calendar.MONTH, 1)
                date = calendar.time
                articlesList.add(
                    GroupedArticlesListItem.SectionHeader(date)
                )
            }
            articlesList.add(
                GroupedArticlesListItem.Article(index, "Article Title #$index", "Article Author #$index", date)
            )
        }
        return articlesList
    }

    companion object {
        private const val SECTION_DAYS_COUNT = 5
    }
}