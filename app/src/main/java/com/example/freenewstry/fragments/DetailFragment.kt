package com.example.freenewstry.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.fragment.app.activityViewModels
import com.example.freenewstry.R
import com.example.freenewstry.viewmodels.CustomViewModel

class DetailFragment : Fragment() {

    val myViewModel : CustomViewModel by activityViewModels()

    private lateinit var webView: WebView

    private var extraHeaders : HashMap<String, String> = HashMap()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        webView = requireView().findViewById(R.id.detailwebview)

        extraHeaders.put("X-RapidAPI-Key", "847310f156msh94c344d4a1fb18fp15549cjsn88ea6d094e14")

        webView.settings.javaScriptEnabled = true
        webView.loadUrl(myViewModel.article.value!!.link, extraHeaders)


    }
}