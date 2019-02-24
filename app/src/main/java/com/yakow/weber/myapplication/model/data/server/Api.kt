package com.yakow.weber.myapplication.model.data.server

import com.yakow.weber.myapplication.model.data.server.models.JokeSitesResponse
import io.reactivex.Single
import retrofit2.http.GET

/**
 * Created on 24.02.19
 * @author YWeber */

interface Api {
    @GET("/api/sources")
    fun getAllDataSourceAna(): Single<List<List<JokeSitesResponse>>>
}