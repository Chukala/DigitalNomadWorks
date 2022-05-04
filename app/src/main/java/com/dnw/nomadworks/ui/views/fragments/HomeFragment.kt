package com.dnw.nomadworks.ui.views.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dnw.nomadworks.databinding.FragmentHomeBinding
import com.dnw.nomadworks.ui.adapter.CategoryRVAdapter
import com.dnw.nomadworks.ui.adapter.HowItWorksRVAdapter
import com.dnw.nomadworks.ui.views.fragments.PostProjectFragment


class HomeFragment : Fragment() {
    // generate a class based on layout name
    private lateinit var binding: FragmentHomeBinding
    //instance properties
    private lateinit var hIwAdapter : HowItWorksRVAdapter
    private lateinit var catAdapter : CategoryRVAdapter

   // post_project_btn
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
            initRecyclerView()
       /*binding.postProjectBtn.setOnClickListener {
           gotoPost()
       }*/
        return view

    }


    private fun initRecyclerView() {
            val hIwRV = binding.howItWorksRecyclerView
            val catRV = binding.categoriesRecycleView

            hIwAdapter = HowItWorksRVAdapter()
            catAdapter = CategoryRVAdapter()

            hIwRV.layoutManager =
                LinearLayoutManager(activity ,LinearLayoutManager.HORIZONTAL,false)
            hIwRV.adapter = hIwAdapter

            catRV.layoutManager =
                  LinearLayoutManager(activity ,LinearLayoutManager.HORIZONTAL,false)
            catRV.adapter = catAdapter

        }

    /*private fun gotoPost(){
        val intent = Intent(context, PostProjectFragment::class.java)
            startActivity(intent)
        }*/

}

