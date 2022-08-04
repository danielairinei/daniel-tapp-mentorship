package com.example.mentorship.features.gallery.fragments

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.mentorship.R
import com.example.mentorship.databinding.FragmentPhotoDetailsBinding
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding

class PhotoDetailsFragment : Fragment(R.layout.fragment_photo_details) {

    private val binding by viewBinding(FragmentPhotoDetailsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.photoDetailsIV.loadUrl(arguments?.getString("url"))
        binding.photoDetailsTitleTV.text = arguments?.getString("title")
        binding.photoDetailsYearTV.text = arguments?.getInt("year").toString()
    }

    private fun ImageView.loadUrl(url: String?) {
        Glide.with(this)
            .load(url)
            .placeholder(R.drawable.ic_baseline_refresh_24)
            .error(R.drawable.ic_baseline_error_24)
            .into(this)
    }
}