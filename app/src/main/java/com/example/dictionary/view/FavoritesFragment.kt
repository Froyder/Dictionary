package com.example.dictionary.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dictionary.R
import com.example.dictionary.databinding.FavoritesLayoutBinding
import com.example.dictionary.view.viewmodel.FavoritesViewModel
import com.example.model.DataModel
import com.example.utils.toStringConverter

class FavoritesFragment: Fragment() {

    private var _binding: FavoritesLayoutBinding? = null
    private val viewBinding get() = _binding!!

    private val viewModel: FavoritesViewModel by activityViewModels()

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

    companion object Factory {
        fun newInstance(): Fragment = FavoritesFragment()
    }
}