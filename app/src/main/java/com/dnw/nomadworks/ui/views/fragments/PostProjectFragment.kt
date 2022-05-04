package com.dnw.nomadworks.ui.views.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.dnw.nomadworks.databinding.FragmentPostProjectBinding
import com.dnw.nomadworks.models.ProjectModel
import com.dnw.nomadworks.ui.views.activities.MainActivity
import com.dnw.nomadworks.viewmodels.ProjectViewModel
import com.google.android.material.datepicker.DateValidatorPointForward.now
import java.sql.Timestamp
import java.time.LocalDate.now
import java.time.YearMonth.now
import java.time.ZonedDateTime.now

class PostProjectFragment : Fragment() {

    // generate a class based on layout name
    private lateinit var binding: FragmentPostProjectBinding

    private lateinit var viewModel: ProjectViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this)[ProjectViewModel::class.java]

        binding = FragmentPostProjectBinding.inflate(inflater, container, false)
         init()
        return binding.root

    }

    fun init(){
        binding.projectPostBtn.setOnClickListener {
            Log.d("post submit Btn", "Submit button clicked ")
            val pTitle = binding.projectTitleETV.text.toString()
            val pDesc = binding.projectDescETV.text.toString()
            val pBudget = binding.budgetETV.text.toString()
            val pDeadLine = binding.projectDeadlineETV.text.toString()
            val pId = pTitle
            binding.pbLoading.visibility = View.VISIBLE

            val project = ProjectModel(pId,pTitle,pDesc,pBudget,pDeadLine)

            if (isValid(pId,pTitle,pDesc,pBudget,pDeadLine)) {
                viewModel.post(project)
            } else {
                Log.d("Fill the data", "Empty or Null")
                Toast.makeText(context,"please fill the data",Toast.LENGTH_SHORT).show()

            }
        }

        viewModel.isPosted.observe(viewLifecycleOwner){
            val msg: String
            if (it == true){
                binding.pbLoading.visibility = View.GONE
                msg = "Successfully posted your project..."
                val intent = Intent(context, MainActivity::class.java)
                   startActivity(intent)
           } else {
                msg = "post failed, Please try again!!"
            }
            Toast.makeText(context,msg,Toast.LENGTH_LONG).show()
        }

    }


    /** check the input fields are not null or empty */
    private fun isValid(pId:String, pTitle: String, pDesc: String, pBudget: String, pDeadLine: String): Boolean {
        if (pId.isNullOrEmpty() || pTitle.isNullOrEmpty() || pDesc.isNullOrEmpty() || pBudget.isNullOrEmpty() || pDeadLine.isNullOrEmpty()) {
            return false
        }
        return true
    }

}