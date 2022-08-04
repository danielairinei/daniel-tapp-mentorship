package com.example.mentorship.features.gallery.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.mentorship.databinding.ItemPhotoBinding
import com.example.mentorship.features.gallery.model.PhotoItem

typealias OnPhotoClickListener = (photoID: Int) -> Unit

class PhotoAdapter(private val onPhotoClickListener: OnPhotoClickListener) :
    ListAdapter<PhotoItem, PhotoViewHolder>(PhotoDiffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding = ItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return PhotoViewHolder(binding, onPhotoClickListener)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}