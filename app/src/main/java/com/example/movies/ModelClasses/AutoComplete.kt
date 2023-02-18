package com.example.movies.ModelClasses

import com.google.gson.annotations.SerializedName

data class AutoComplete(
    @SerializedName("d")
    val detailList: List<D>,
    val q: String,
    val v: Int
)