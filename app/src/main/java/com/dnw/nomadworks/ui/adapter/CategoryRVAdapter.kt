package com.dnw.nomadworks.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dnw.nomadworks.R
import com.dnw.nomadworks.databinding.CategoryListLayoutBinding
import com.dnw.nomadworks.databinding.CategoryRowLayoutBinding

class CategoryRVAdapter : RecyclerView.Adapter<CategoryRVAdapter.ViewHolder>() {

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
    private val catDesc = arrayOf("Auditing, Finance, Leisure, Bookkeeping","Computers","House Work","Mobile Phones","Office Help","Programming","Skilled","Utility")

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryRVAdapter.ViewHolder {
       return ViewHolder(
            CategoryRowLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
           ,CategoryListLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
       )
    }

    override fun onBindViewHolder(holder: CategoryRVAdapter.ViewHolder, position: Int) {
        // Home fragment
        holder.binding.categoryNameTV.text = catNames[position]
        holder.binding.categoryImgIV.setImageResource(catImg[position])

        // category fragments
        holder.listBinding.catTitleTV.text = catNames[position]
        holder.listBinding.catImgIV.setImageResource(catImg[position])
        holder.listBinding.catDescTV.text = catDesc[position]
    }

    override fun getItemCount(): Int {
        return catNames.size
    }
    inner class ViewHolder(val binding: CategoryRowLayoutBinding, val listBinding: CategoryListLayoutBinding): RecyclerView.ViewHolder(binding.root)
}