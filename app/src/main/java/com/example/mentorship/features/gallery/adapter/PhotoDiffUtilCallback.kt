package com.example.mentorship.features.gallery.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.mentorship.features.gallery.model.PhotoItem

object PhotoDiffUtilCallback : DiffUtil.ItemCallback<PhotoItem>() {

    override fun areItemsTheSame(
        newItem: PhotoItem,
        oldItem: PhotoItem
    ): Boolean = newItem.id == oldItem.id

    override fun areContentsTheSame(
        newItem: PhotoItem,
        oldItem: PhotoItem
    ): Boolean = newItem == oldItem
}