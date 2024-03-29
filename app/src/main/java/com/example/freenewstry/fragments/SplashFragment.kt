package com.example.freenewstry.fragments

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.freenewstry.R

class SplashFragment : Fragment() {

    private lateinit var progressBar: ProgressBar
    private lateinit var splashTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindingFun()
        timerFun()
    }

    private fun bindingFun(){
        progressBar = requireView().findViewById(R.id.progress)
        splashTextView = requireView().findViewById(R.id.introsplashtv)
    }

    private fun timerFun(){
        val timer = object : CountDownTimer(2000, 1000){
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
            }

        }
        timer.start()
    }

}