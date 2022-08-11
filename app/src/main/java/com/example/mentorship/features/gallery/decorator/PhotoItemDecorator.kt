package com.example.mentorship.features.gallery.decorator

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class PhotoItemDecorator(private val space: Float) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)

        outRect.top = space.toInt() / 2
        outRect.bottom = space.toInt() / 2
        outRect.left = space.toInt() / 2
        outRect.right = space.toInt() / 2
    }
}