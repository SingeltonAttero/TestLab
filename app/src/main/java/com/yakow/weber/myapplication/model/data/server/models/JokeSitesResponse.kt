package com.yakow.weber.myapplication.model.data.server.models

import com.google.gson.annotations.SerializedName

/**
 * Created on 24.02.19
 * @author YWeber */

data class JokeSitesResponse(
    @SerializedName("site") val site: String,
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String,
    @SerializedName("parsel") val parsel: String,
    @SerializedName("encoding") val encoding: String,
    @SerializedName("linkpar") val linkpar: String,
    @SerializedName("desc") val desc: String
)