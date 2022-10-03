package com.example.freenewstry.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.freenewstry.R
import com.example.freenewstry.viewmodels.CustomViewModel

class MainActivity : AppCompatActivity() {

    //val yViewModel : CustomViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //myViewModel.getDataResponse()
    }

}