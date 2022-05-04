package com.dnw.nomadworks.ui.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dnw.nomadworks.databinding.FragmentCategoriesBinding
import com.dnw.nomadworks.ui.adapter.CatListRVAdapter

class CategoriesFragment : Fragment() {

    // generate a class based on layout name
    private lateinit var binding: FragmentCategoriesBinding
    //instance properties
    private lateinit var catAdapter : CatListRVAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoriesBinding.inflate(inflater, container, false)
        val view = binding.root
        initRecyclerView()
        return view
    }

    private fun initRecyclerView() {
        val catLRV = binding.categoriesListRecycleView
            catAdapter = CatListRVAdapter()

        catLRV.layoutManager =
            LinearLayoutManager(activity , LinearLayoutManager.VERTICAL,false)
        catLRV.adapter = catAdapter

    }
}