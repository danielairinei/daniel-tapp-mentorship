package com.example.mentorship.features.recyclerview

import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mentorship.databinding.ActivityRecyclerBinding
import com.example.mentorship.viewBinding

class RecyclerActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityRecyclerBinding::inflate)
    private lateinit var recyclerAdapter: ArticleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        recyclerAdapter = ArticleAdapter()
        val recyclerView = binding.listRV
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val layoutManager = recyclerView.layoutManager as LinearLayoutManager

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (layoutManager.findFirstVisibleItemPosition() > 3) {
                    binding.scrollToTopFAB.visibility = VISIBLE
                }

                if (layoutManager.findFirstVisibleItemPosition() <= 3) {
                    binding.scrollToTopFAB.visibility = INVISIBLE
                }
            }
        })
        recyclerView.adapter = recyclerAdapter
        recyclerAdapter.submitList(getArticles())

        binding.scrollToTopFAB.setOnClickListener {
            recyclerView.smoothScrollToPosition(0)
        }
    }

    private fun getArticles(): List<Article> =
        (0..100).map { index -> Article(index, "Article Index $index") }
}
