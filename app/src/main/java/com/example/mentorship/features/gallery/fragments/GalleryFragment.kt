package com.example.mentorship.features.gallery.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mentorship.R
import com.example.mentorship.databinding.FragmentGalleryBinding
import com.example.mentorship.features.gallery.adapter.PhotoAdapter
import com.example.mentorship.features.gallery.decorator.PhotoItemDecorator
import com.example.mentorship.features.gallery.model.PhotoItem
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding

class GalleryFragment : Fragment(R.layout.fragment_gallery) {

    private val binding by viewBinding(FragmentGalleryBinding::bind)
    private val photosList: List<PhotoItem> = getPhotosList()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val galleryRvAdapter = PhotoAdapter(::onPhotoClickListener)
        binding.root.adapter = galleryRvAdapter
        binding.root.layoutManager = GridLayoutManager(parentFragment?.context, 3)

        binding.root.addItemDecoration(PhotoItemDecorator(resources.getDimension(R.dimen.photo_item_decorator_space)))
        galleryRvAdapter.submitList(photosList)
    }

    private fun getPhotosList(): List<PhotoItem> {
        val photos: List<PhotoItem> = mutableListOf<PhotoItem>().apply {
            (0..101).forEach { index ->
                add(
                    PhotoItem(
                        index,
                        "https://picsum.photos/id/${120 + index}/500/500",
                        "Tapp $index",
                        1920 + index
                    )
                )
            }
        }
        return photos
    }

    private fun onPhotoClickListener(photoID: Int) {
        val photoItem: PhotoItem? = photosList.find { it.id == photoID }
        val bundle = Bundle()

        bundle.putString("url", photoItem?.url)
        bundle.putString("title", photoItem?.title)
        photoItem?.year?.let { bundle.putInt("year", it) }

        val photoFragment = PhotoDetailsFragment()
        photoFragment.arguments = bundle

        requireActivity().supportFragmentManager.beginTransaction()
            .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right)
            .addToBackStack(photoFragment.toString())
            .replace(R.id.fragment_container, photoFragment).commit()
    }
}