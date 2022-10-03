package com.example.freenewstry.interfaces

import androidx.lifecycle.MutableLiveData
import com.example.freenewstry.models.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Query

interface ClientEndPoints {

    @GET("/v1/search")
    fun getDataResponse(@Query("q") searchParam : String,
                        @Query("lang") lang : String?,
                        @Query("page") page : Int?,
                        @Query("page_size") page_size : Int?) : Call<DataResponse>

}