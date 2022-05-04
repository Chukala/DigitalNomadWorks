package com.dnw.nomadworks.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.dnw.nomadworks.databinding.FragmentSearchFreelancerBinding
import com.dnw.nomadworks.models.ProjectModel
import com.dnw.nomadworks.ui.adapter.ProjectRVAdapter
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class ProjectRepo {
    private lateinit var binding: FragmentSearchFreelancerBinding
    private var auth: FirebaseAuth = FirebaseAuth.getInstance()
    private var db: FirebaseDatabase = FirebaseDatabase.getInstance()
    private var dbRef: DatabaseReference = db.reference.child("Projects")
    val isPosted = MutableLiveData<Boolean>()

    val getListLiveData: MutableLiveData<List<ProjectModel>> by lazy {
        MutableLiveData<List<ProjectModel>>()
    }


    fun postProject(project: ProjectModel) {

        dbRef.child(project.pId).setValue(project).addOnCompleteListener {
            if (it.isSuccessful) {
                Log.d("Post", "your project is successfully posted!")
                isPosted.value = it.isSuccessful

            } else {
                Log.d("Post Failed", "Post project failed")
                isPosted.value = false
            }
        }
    }



    // Read from the database
    fun getProjectList() {
        dbRef.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                var proList = ArrayList<ProjectModel>()
                for(data in snapshot.children){
                    var projects = data.getValue(ProjectModel::class.java)
                    Log.i("firebase", "Got value ${projects}")
                    if(projects != null){
                        proList.add(projects )
                        Log.i("proList", "Got value ${proList}")
                    }
                }

                    getListLiveData.value = proList
                Log.i("getListLiveDatavalue", "Got value ${getListLiveData.value}")


            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("cancel", error.toString())
            }
        })

    }
}