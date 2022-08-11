package com.example.mentorship.features.gallery.fragments

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.mentorship.R
import com.example.mentorship.databinding.FragmentPhotoDetailsBinding
import com.example.mentorship.features.gallery.model.PhotoItem
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding

class PhotoDetailsFragment : Fragment(R.layout.fragment_photo_details) {

    private val binding by viewBinding(FragmentPhotoDetailsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.photoDetailsIV.loadUrl(arguments?.getString(KEY_URL))
        binding.photoDetailsTitleTV.text = arguments?.getString(KEY_TITLE)
        binding.photoDetailsYearTV.text = arguments?.getInt(KEY_YEAR).toString()
    }

    private fun ImageView.loadUrl(url: String?) {
        Glide.with(this)
            .load(url)
            .placeholder(R.drawable.ic_baseline_refresh_24)
            .error(R.drawable.ic_baseline_error_24)
            .into(this)
    }

    companion object {
        private const val KEY_URL = "url"
        private const val KEY_TITLE = "title"
        private const val KEY_YEAR = "year"

        fun newInstance(photoItem: PhotoItem?): PhotoDetailsFragment {
            val fragment = PhotoDetailsFragment()
            val bundle = Bundle()

            bundle.putString(KEY_URL, photoItem?.url)
            bundle.putString(KEY_TITLE, photoItem?.title)
            photoItem?.year?.let { bundle.putInt(KEY_YEAR, it) }

            fragment.arguments = bundle

            return fragment
        }
    }
}