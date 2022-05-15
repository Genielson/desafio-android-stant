package com.example.desafio_android_stant.data.models

import com.google.gson.annotations.SerializedName

data class MovieContentModel(
    @SerializedName("page")
    var page:Int,
    @SerializedName("results")
    var result: List<ResponseResultModel>,
    @SerializedName("total_pages")
    var total_pages:Int,
    @SerializedName("total_results")
    var total_results:Int
)
