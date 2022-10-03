package com.example.freenewstry.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.freenewstry.R
import com.example.freenewstry.viewmodels.CustomViewModel


class HomeFragment : Fragment(), View.OnClickListener {

    val myViewModel : CustomViewModel by activityViewModels()

    private lateinit var searchButton : Button

    private lateinit var searchBar : EditText
    private lateinit var languageBar : EditText
    private lateinit var pageBar : EditText
    private lateinit var pageSizeBar : EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindingFun()
    }

    fun bindingFun(){
        searchButton = requireView().findViewById(R.id.buttonsearch)
        searchBar = requireView().findViewById(R.id.searchbar)
        languageBar = requireView().findViewById(R.id.langparamsearch)
        pageBar = requireView().findViewById(R.id.pageparamsearch)
        pageSizeBar = requireView().findViewById(R.id.pagesizeparamsearch)

        searchButton.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {

        when(p0!!.id){
            R.id.buttonsearch -> {
                getData()
                findNavController().navigate(R.id.action_homeFragment_to_listFragment)

            }
        }

    }

    fun getData(){
        var a : Int?
        var b : Int?

        try {
            a = pageBar.text.toString().toInt()
            b = pageSizeBar.text.toString().toInt()
        } catch (ex : Exception){
            a = null
            b = null
        }

        myViewModel.getDataResponse(searchBar.text.toString(), languageBar.text.toString(), a, b )

    }

}