package com.example.mentorship.features.customview.customviews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.example.mentorship.R
import com.example.mentorship.databinding.ViewLoadingButtonBinding

// Compound View
class LoadingButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
) : FrameLayout(context, attrs) {

    private val binding: ViewLoadingButtonBinding = ViewLoadingButtonBinding.inflate(LayoutInflater.from(context), this, true)
    private val textBtn: String?

    var isLoading: Boolean = false
        set(value) {
            field = value
            if (value) {
                binding.loadingBtn.text = ""
                binding.loadingPB.visibility = VISIBLE
                binding.loadingBtn.isClickable = false
            } else {
                binding.loadingPB.visibility = INVISIBLE
                binding.loadingBtn.text = textBtn
                binding.loadingBtn.isClickable = true
            }
        }

    init {
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.LoadingButton)
        textBtn = attributes.getString(R.styleable.LoadingButton_text)
        binding.loadingBtn.text = textBtn

        attributes.recycle()
    }

    override fun setOnClickListener(l: OnClickListener?) {
        binding.loadingBtn.setOnClickListener(l)
    }
}