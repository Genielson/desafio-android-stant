package com.example.desafio_android_stant.data.models

import com.google.gson.annotations.SerializedName

data class MovieContentModel(
    @SerializedName("page")
    val page:Int,
    @SerializedName("result")
    val result: List<ResponseResultModel>
)
