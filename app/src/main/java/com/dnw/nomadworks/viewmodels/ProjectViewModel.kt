package com.dnw.nomadworks.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dnw.nomadworks.models.ProjectModel
import com.dnw.nomadworks.repository.ProjectRepo
import com.google.firebase.database.MutableData

class ProjectViewModel(application: Application): AndroidViewModel(application) {
    private val repo = ProjectRepo()
    val isPosted : LiveData<Boolean>
    val getListLiveData : LiveData<List<ProjectModel>>



    init {
        isPosted = repo.isPosted
        getListLiveData = repo.getListLiveData
    }

    fun post(project : ProjectModel){
        repo.postProject(project)
    }

    fun getData(){
        repo.getProjectList()
    }

}