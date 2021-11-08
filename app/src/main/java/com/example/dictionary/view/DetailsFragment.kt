package com.example.dictionary.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import coil.ImageLoader
import coil.drawable.CrossfadeDrawable
import coil.request.LoadRequest
import coil.transform.CircleCropTransformation
import coil.transition.CrossfadeTransition
import com.example.dictionary.R
import com.example.dictionary.databinding.DetailsLayoutBinding

class DetailsFragment: Fragment() {

    private var _binding: DetailsLayoutBinding? = null
    private val viewBinding get() = _binding!!

    private val text: String by lazy { arguments?.getString(ARG_TEXT).orEmpty() }
    private val meanings: String by lazy { arguments?.getString(ARG_MEANINGS).orEmpty() }
    private val imageURL: String by lazy { arguments?.getString(ARG_URL).orEmpty() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DetailsLayoutBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.descriptionHeader.text = text
        viewBinding.descriptionTextview.text = meanings
        useCoilToLoadPhoto(viewBinding.descriptionImageview, imageURL)
    }

    private fun useCoilToLoadPhoto(imageView: ImageView, imageLink: String) {
        val request =
            LoadRequest.Builder(requireContext())
                .data("https:$imageLink")
                .target(
                    onStart = {},
                    onSuccess = { result ->
                        imageView.setImageDrawable(result)
                    },
                    onError = {
                        imageView.setImageResource(R.drawable.ic_launcher_foreground)
                    }
                )
                .transformations(CircleCropTransformation())
                .build()
                ImageLoader(requireContext()).execute(request)
    }

    companion object Factory {
        private const val ARG_TEXT = "arg_text"
        private const val ARG_MEANINGS = "arg_meanings"
        private const val ARG_URL = "arg_URL"

        fun newInstance(text: String?, meanings: String?, URL: String?): Fragment {
            val fragment = DetailsFragment()
            fragment.arguments = bundleOf(
                ARG_TEXT to text,
                ARG_MEANINGS to meanings,
                ARG_URL to URL
            )
            return fragment
        }
    }

}