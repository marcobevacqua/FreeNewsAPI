package com.example.freenewstry.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.freenewstry.adapters.AdapterRest
import com.example.freenewstry.models.Article
import com.example.freenewstry.models.DataResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CustomViewModel : ViewModel() {

    var articlesList : MutableLiveData<ArrayList<Article>> = MutableLiveData()
    var article : MutableLiveData<Article> = MutableLiveData()

    fun getDataResponse(query: String, lang : String?, page : Int?, page_size : Int?){
        AdapterRest.clientEndpoints!!.getDataResponse(query, lang, page, page_size)?.enqueue(object : Callback<DataResponse>{
            override fun onResponse(call: Call<DataResponse>, response: Response<DataResponse>) {
                articlesList.value = response.body()?.articles

            }

            override fun onFailure(call: Call<DataResponse>, t: Throwable) {

            }
        })

    }


}