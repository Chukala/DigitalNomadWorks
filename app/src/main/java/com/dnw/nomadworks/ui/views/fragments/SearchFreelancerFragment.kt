package com.dnw.nomadworks.ui.views.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dnw.nomadworks.databinding.FragmentSearchFreelancerBinding

import com.dnw.nomadworks.models.ProjectModel
import com.dnw.nomadworks.ui.adapter.ProjectRVAdapter
import com.dnw.nomadworks.viewmodels.ProjectViewModel

class SearchFreelancerFragment : Fragment() {
    // generate a class based on layout name
    private lateinit var binding: FragmentSearchFreelancerBinding
    //instance properties
    private lateinit var projAdapter : ProjectRVAdapter
    private lateinit var viewModel: ProjectViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentSearchFreelancerBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[ProjectViewModel::class.java]

        initRecyclerView()

        return binding.root
    }


    private fun initRecyclerView() {
        viewModel.getData()
        val projectList = ArrayList<ProjectModel>()

        val projLRV = binding.projectRV
             projAdapter = ProjectRVAdapter(projectList)

        projLRV.layoutManager =
            LinearLayoutManager(activity , LinearLayoutManager.VERTICAL,false)
        projLRV.adapter = projAdapter

        Log.d("projAdapter","$projectList")
       viewModel.getListLiveData.observe(viewLifecycleOwner){
           projectList.addAll(it)
       }
    }


}





