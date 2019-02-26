package com.yakow.weber.myapplication.model.data.server.models

import com.google.gson.annotations.SerializedName

/**
 * Created on 26.02.19
 * @author YWeber */

data class JokeResponse(
    @SerializedName("site") val site: String,
    @SerializedName("name") val name: String,
    @SerializedName("desc") val desc: String,
    @SerializedName("link") val link: Any?,
    @SerializedName("elementPureHtml") val elementPureHtml: String
)