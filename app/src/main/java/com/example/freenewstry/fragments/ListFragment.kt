package com.example.freenewstry.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.freenewstry.R
import com.example.freenewstry.adapters.ArticlesRecyclerAdapter
import com.example.freenewstry.models.Article
import com.example.freenewstry.viewmodels.CustomViewModel

class ListFragment : Fragment() {

    val myViewModel : CustomViewModel by activityViewModels()

    private lateinit var recyclerView: RecyclerView

    var articlesList : ArrayList<Article> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindingFun()
        setUpViewModel()
    }

    fun bindingFun(){
        recyclerView = requireView().findViewById(R.id.recyclernews)
        recyclerView.adapter = ArticlesRecyclerAdapter(articlesList, myViewModel, this)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    fun setUpViewModel(){

        myViewModel.articlesList.observe(viewLifecycleOwner){
            articlesList.addAll(it ?: arrayListOf())
            recyclerView.adapter!!.notifyDataSetChanged()
        }

    }
}