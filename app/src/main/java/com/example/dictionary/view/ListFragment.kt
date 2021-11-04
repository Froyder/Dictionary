package com.example.dictionary.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dictionary.R
import com.example.dictionary.databinding.ListLayoutBinding
import com.example.dictionary.model.data.AppState
import com.example.dictionary.model.data.DataModel
import com.example.dictionary.view.viewmodel.ListFragmentViewModel

class ListFragment : Fragment(), ListFragmentView {

    companion object Factory {
        fun newInstance(): Fragment = ListFragment()
    }

    private val viewModel: ListFragmentViewModel by activityViewModels()

    private var _binding: ListLayoutBinding? = null
    private val viewBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ListLayoutBinding.inflate(inflater, container, false)

        viewModel.mutableLiveData.observe(viewLifecycleOwner) { renderData(it) }
        return viewBinding.root
    }

    private var adapter: MainAdapter? = null
    private val onListItemClickListener: MainAdapter.OnListItemClickListener =
        object : MainAdapter.OnListItemClickListener {
            override fun onItemClick(data: DataModel) {
                Toast.makeText(context, data.text, Toast.LENGTH_SHORT).show()
            }
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.searchButton.setOnClickListener { onSearchButtonClicked() }
    }

    private fun onSearchButtonClicked() {
        viewModel.getData(viewBinding.editText.text.toString())
        hideKeyboard()
    }

    override fun renderData(appState: AppState) {
        when (appState) {
            is AppState.Success -> {
                viewBinding.progressBar.visibility = View.GONE
                val dataModel = appState.data
                if (dataModel == null || dataModel.isEmpty()) {
                    onErrorOccurred(getString(R.string.empty_server_response_on_success))
                } else {
                    if (adapter == null) {
                        viewBinding.mainActivityRecyclerview.layoutManager =
                            LinearLayoutManager(context)
                        viewBinding.mainActivityRecyclerview.adapter =
                            MainAdapter(onListItemClickListener, dataModel)
                    } else {
                        adapter!!.setData(dataModel)
                    }
                }
            }
            is AppState.Loading -> {
                viewBinding.progressBar.visibility = View.VISIBLE
            }
            is AppState.Error -> {
                onErrorOccurred(appState.error.message)
            }
        }
    }

    private fun onErrorOccurred(error: String?) {
        Toast.makeText(context, "An error occurred: $error", Toast.LENGTH_SHORT).show()
    }

    private fun hideKeyboard() {
        viewBinding.editText.clearFocus()
        val keyboard =
            requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        keyboard.hideSoftInputFromWindow(viewBinding.editText.windowToken, 0)
    }
}