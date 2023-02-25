package com.example.movies.ModelClasses

import com.google.gson.annotations.SerializedName

data class D(
    @SerializedName("i")
    val imageOfMovie: I?,

    val id: String,

    @SerializedName("l")
    val movieName: String?,

    @SerializedName("q")
    val type: String?,

    @SerializedName("qid")
    val typeId: String?,

    @SerializedName("rank")
    val rankOfMovie: Int?,

    @SerializedName("s")
    val starCastOfMovie: String?,

    @SerializedName("y")
    val yearOfRelease: Int?,

    val yr: String
)