package com.example.movies.ModelClasses

import com.google.gson.annotations.SerializedName

data class AutoComplete(
    val d: List<D>,
    val q: String,
    val v: Int
)