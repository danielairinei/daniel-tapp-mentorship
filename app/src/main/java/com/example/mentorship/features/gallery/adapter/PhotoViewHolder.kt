package com.example.mentorship.features.gallery.adapter

import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mentorship.R
import com.example.mentorship.databinding.ItemPhotoBinding
import com.example.mentorship.features.gallery.model.PhotoItem

class PhotoViewHolder(private val binding: ItemPhotoBinding, private val onPhotoClickListener: OnPhotoClickListener) :
    RecyclerView.ViewHolder(binding.root) {

    private var photographId: Int? = null

    init {
        binding.root.setOnClickListener {
            photographId?.let { photographId ->
                onPhotoClickListener(photographId)
            }
        }
    }

    fun bind(photoItem: PhotoItem) {
        photographId = photoItem.id

        binding.photoIV.loadUrl(photoItem.url)
        binding.photoNameTV.text = photoItem.title
        binding.photoYearTV.text = photoItem.year.toString()
    }

    private fun ImageView.loadUrl(url: String?) {
        Glide.with(this)
            .load(url)
            .placeholder(R.drawable.ic_baseline_refresh_24)
            .error(R.drawable.ic_baseline_error_24)
            .into(this)
    }
}