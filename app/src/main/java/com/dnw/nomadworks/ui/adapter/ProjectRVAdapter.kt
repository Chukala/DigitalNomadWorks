package com.dnw.nomadworks.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dnw.nomadworks.databinding.ProjectListLayoutBinding
import com.dnw.nomadworks.models.ProjectModel

class ProjectRVAdapter(var projectList: List<ProjectModel>) : RecyclerView.Adapter<ProjectRVAdapter.ViewHolder>(){

        /*private var projTitle = arrayOf("I want an android mobile app built for my business.","I want a mobile app works in all mobile os for my business.","I want an android mobile app built for my business")
        private val projDesc = arrayOf("Lorem Ipsum is simply dummy text of the printing and typesetting industry Lorem Ipsum is simply dummy text","Lorem Ipsum is simply dummy text of the printing and typesetting industry Lorem Ipsum is simply dummy text","Lorem Ipsum is simply dummy text of the printing and typesetting industry.")
        private val projPostedOn = arrayOf("05/05/2022","25/04/2022","10/05/2022")
        private val projBudget = arrayOf("1,800","500","1,200")*/

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): ProjectRVAdapter.ViewHolder {
            return ViewHolder(ProjectListLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }

        override fun onBindViewHolder(holder: ProjectRVAdapter.ViewHolder, position: Int) {

            // project search fragments
            holder.projListBinding.postTitleTV.text = projectList[position].pTitle
            holder.projListBinding.postDescTV.text = projectList[position].pDesc
            holder.projListBinding.postedDateTV.text = projectList[position].pDeadline
            holder.projListBinding.postBudgetTV.text = projectList[position].pBudget
        }

        override fun getItemCount(): Int {
             return projectList.size
        }
        inner class ViewHolder(val projListBinding: ProjectListLayoutBinding): RecyclerView.ViewHolder(projListBinding.root)
    }

