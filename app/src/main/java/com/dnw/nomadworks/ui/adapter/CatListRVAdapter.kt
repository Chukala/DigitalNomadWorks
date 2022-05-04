package com.dnw.nomadworks.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dnw.nomadworks.R
import com.dnw.nomadworks.databinding.CategoryListLayoutBinding

class CatListRVAdapter : RecyclerView.Adapter<CatListRVAdapter.ViewHolder>() {

        private var catNames = arrayOf("Accounting","Computers","House Work","Mobile Phones","Office Help","Programming","Skilled","Utility")
        private val catImg = intArrayOf(
            R.drawable.accounting,
            R.drawable.computers,
            R.drawable.house_work,
            R.drawable.mobile_phones,
            R.drawable.office_help,
            R.drawable.programming,
            R.drawable.skilled,
            R.drawable.utility)
        private val catDesc = arrayOf("Auditing, Finance, Leisure","Maintenance,Networking","House Work","Samsung,Iphone","Office Help","mobile app, websites, E-commerce","Skilled","Utility")

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): CatListRVAdapter.ViewHolder {
            return ViewHolder(CategoryListLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }

        override fun onBindViewHolder(holder: CatListRVAdapter.ViewHolder, position: Int) {

            // category fragments
            holder.listBinding.catTitleTV.text = catNames[position]
            holder.listBinding.catImgIV.setImageResource(catImg[position])
            holder.listBinding.catDescTV.text = catDesc[position]
        }

        override fun getItemCount(): Int {
            return catNames.size
        }
        inner class ViewHolder(val listBinding: CategoryListLayoutBinding): RecyclerView.ViewHolder(listBinding.root)
    }
