package com.dnw.nomadworks.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dnw.nomadworks.R
import com.dnw.nomadworks.databinding.HowitworksRowLayoutBinding


class HowItWorksRVAdapter :
    RecyclerView.Adapter<HowItWorksRVAdapter.ViewHolder>() {

       private var titles = arrayOf("Register an account","Post your project","Get proposals","Get your project done")
       private var desc = arrayOf("Registering an account is very easy in our app. Just go to the register and put your email, and you are done.",
        "Post your project easily with our easy to use interface, then wait for the freelancers to submit their proposals.",
        "After posting your project , you will wait for the freelancers to post their proposals.You choose and the work done.",
        "After choosing a freelancer, your work will start. You and the freelancer will be in total contact and cooperation.")
       private val images = intArrayOf(R.drawable.ic_account_blue,R.drawable.ic_post,R.drawable.ic_proposal,R.drawable.ic_check)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(HowitworksRowLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.howItWorksItemTitle.text = titles[position]
        holder.binding.howItWorksItemDesc.text = desc[position]
        holder.binding.howItWorksItemImage.setImageResource(images[position])
    }

    // number of items to be rendered in recyclerview
    override fun getItemCount(): Int {
        return titles.size
    }

    inner class ViewHolder(val binding: HowitworksRowLayoutBinding):RecyclerView.ViewHolder(binding.root)

}