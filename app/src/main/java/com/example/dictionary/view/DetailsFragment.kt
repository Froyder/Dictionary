package com.example.dictionary.view

import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import coil.ImageLoader
import coil.request.LoadRequest
import coil.transform.CircleCropTransformation
import com.example.dictionary.R
import com.example.dictionary.databinding.DetailsLayoutBinding
import com.example.dictionary.view.viewmodel.DetailsViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.qualifier.named
import org.koin.core.scope.Scope

class DetailsFragment: Fragment(), KoinComponent {

    private val koinScope: Scope by lazy { getKoin().createScope("detailsScope", named(DETAILS_SCOPE))}
    private val viewModel: DetailsViewModel by koinScope.inject()

    private var _binding: DetailsLayoutBinding? = null
    private val viewBinding get() = _binding!!

    private val text: String by lazy { arguments?.getString(ARG_TEXT).orEmpty() }
    private val meanings: String by lazy { arguments?.getString(ARG_MEANINGS).orEmpty() }
    private val imageURL: String by lazy { arguments?.getString(ARG_URL).orEmpty() }
    private val status: String by lazy { arguments?.getString(ARG_FAVORITE).orEmpty() }

    private var isFavorite = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DetailsLayoutBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.descriptionHeader.text = text
        viewBinding.descriptionTextview.text = meanings
        useCoilToLoadPhoto(viewBinding.descriptionImageview, imageURL)

        if (status != "true") {
            isFavorite = false
            viewBinding.favoriteIb.setImageResource(INACTIVE)
        } else {
            isFavorite = true
            viewBinding.favoriteIb.setImageResource(ACTIVE)
        }

        viewBinding.favoriteIb.setOnClickListener {
            isFavorite = if (!isFavorite) {
                viewBinding.favoriteIb.setImageResource(ACTIVE)
                Toast.makeText(context, "Word $text was added to favorites!", Toast.LENGTH_SHORT).show()
                viewModel.addToFavorite(text, "true")
                true
            } else {
                viewBinding.favoriteIb.setImageResource(INACTIVE)
                Toast.makeText(context, "Word $text was removed from favorites!", Toast.LENGTH_SHORT).show()
                viewModel.addToFavorite(text, "false")
                false
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.S)
    private fun useCoilToLoadPhoto(imageView: ImageView, imageLink: String) {

        val blurEffect = RenderEffect.createBlurEffect(3f, 5f, Shader.TileMode.MIRROR)

        val request =
            LoadRequest.Builder(requireContext())
                .data("https:$imageLink")
                .target(
                    onStart = {},
                    onSuccess = { result ->
                        imageView.setImageDrawable(result)
                        imageView.setRenderEffect(blurEffect)
                    },
                    onError = {
                        imageView.setImageResource(R.drawable.ic_launcher_foreground)
                        imageView.setRenderEffect(blurEffect)
                    }
                )
                .transformations(CircleCropTransformation())
                .build()
        ImageLoader(requireContext()).execute(request)
    }

    override fun onDestroy() {
        super.onDestroy()
        koinScope.close()
    }

    companion object Factory {
        private const val ARG_TEXT = "arg_text"
        private const val ARG_MEANINGS = "arg_meanings"
        private const val ARG_URL = "arg_URL"
        private const val ARG_FAVORITE = "false"
        private const val ACTIVE = R.drawable.ic_baseline_favorite_24
        private const val INACTIVE = R.drawable.ic_baseline_favorite_border_24
        private const val DETAILS_SCOPE = "details_scope"

        fun newInstance(text: String?, meanings: String?, URL: String?, status: String?): Fragment {
            val fragment = DetailsFragment()
            fragment.arguments = bundleOf(
                ARG_TEXT to text,
                ARG_MEANINGS to meanings,
                ARG_URL to URL,
                ARG_FAVORITE to status
            )
            return fragment
        }
    }
}