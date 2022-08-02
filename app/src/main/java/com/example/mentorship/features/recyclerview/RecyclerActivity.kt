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
        binding.listRV.adapter = recyclerAdapter
        binding.listRV.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        displayFabAfterThirdItem()
        recyclerAdapter.submitList(getArticles())

        binding.scrollToTopFAB.setOnClickListener {
            binding.listRV.smoothScrollToPosition(0)
        }
    }

    private fun getArticles(): List<Article> =
        (0..100).map { index -> Article(index, "Article Index $index") }

    private fun displayFabAfterThirdItem() {
        val layoutManager = binding.listRV.layoutManager as LinearLayoutManager

        binding.listRV.addOnScrollListener(object : RecyclerView.OnScrollListener() {
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
    }
}
