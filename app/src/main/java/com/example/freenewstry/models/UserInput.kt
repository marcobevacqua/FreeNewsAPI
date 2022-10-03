package com.example.freenewstry.models


import com.google.gson.annotations.SerializedName

data class UserInput(

    @SerializedName("from")
    val from: String,
    @SerializedName("lang")
    val lang: String,
    @SerializedName("page")
    val page: Int,
    @SerializedName("q")
    val q: String,
    @SerializedName("size")
    val size: Int,
    @SerializedName("sort_by")
    val sortBy: String,

    var myUserInputId : String
)