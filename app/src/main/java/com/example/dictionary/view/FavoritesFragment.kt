package com.example.dictionary.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dictionary.R
import com.example.dictionary.databinding.FavoritesLayoutBinding
import com.example.dictionary.view.viewmodel.FavoritesViewModel
import com.example.model.DataModel
import com.example.utils.toStringConverter
import org.koin.core.qualifier.named
import org.koin.core.scope.Scope
import org.koin.java.KoinJavaComponent.getKoin

class FavoritesFragment: Fragment() {

    private val koinScope: Scope by lazy {getKoin().createScope("favoritesScope", named(FAVORITES_SCOPE))}
    private val viewModel: FavoritesViewModel by koinScope.inject()

    private var _binding: FavoritesLayoutBinding? = null
    private val viewBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FavoritesLayoutBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    private var adapter: ListAdapter? = null
    private val onListItemClickListener: ListAdapter.OnListItemClickListener =
        object : ListAdapter.OnListItemClickListener {
            override fun onItemClick(data: DataModel) {
                parentFragmentManager
                    .beginTransaction()
                    .replace(
                        R.id.container,
                            DetailsFragment.newInstance(
                            data.text,
                            toStringConverter(data.meanings),
                            data.meanings?.get(0)?.imageUrl, data.isFavorite
                        )
                    )
                    .addToBackStack("")
                    .commit()
            }
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.init()

        viewModel.mutableLiveData.observe(viewLifecycleOwner) { setAdapter(it) }
    }

    private fun setAdapter(list: List<DataModel>) {
        if (adapter == null) {
            viewBinding.favoritesRecyclerview.layoutManager = LinearLayoutManager(context)
            viewBinding.favoritesRecyclerview.adapter = ListAdapter(onListItemClickListener, list)
        } else {
            adapter!!.setData(list)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        koinScope.close()
    }

    companion object Factory {
        private const val FAVORITES_SCOPE = "favorites_scope"
        fun newInstance(): Fragment = FavoritesFragment()
    }
}