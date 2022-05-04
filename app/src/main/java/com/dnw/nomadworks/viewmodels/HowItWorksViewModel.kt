package com.dnw.nomadworks.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dnw.nomadworks.R
import com.dnw.nomadworks.models.HowItWorksModel

class HowItWorksViewModel:ViewModel() {
    private var _steps = MutableLiveData<List<HowItWorksModel>>()
    // only observe the data
    val steps : LiveData<List<HowItWorksModel>> = _steps
     //get() = _steps

    // method
    fun getSteps(){
        val list = mutableListOf<HowItWorksModel>()

        list.add(
            HowItWorksModel(
                "Register an account",
                "Registering an account is very easy in our app. Just go to the register and put your email, and you are done.",
                R.drawable.ic_account_blue
        )
        )
        list.add(
            HowItWorksModel(
                "Post your project",
                "Post your project easily with our easy to use interface, then wait for the freelancers to submit their proposals.",
                R.drawable.ic_post
            )
        )
        list.add(
            HowItWorksModel(
                "Get proposals",
                "After posting your project , you will wait for the freelancers to post their proposals.You choose the best fit for freelancer and start the work.",
                R.drawable.ic_proposal
            )
        )
        list.add(
            HowItWorksModel(
                "Get your project done",
                "After choosing a freelancer, your work will start. You and the freelancer will be in total contact and cooperation.",
                R.drawable.ic_check
            ))

        _steps.value = list
    }
}