package com.yakow.weber.myapplication.model.data.server

import com.yakow.weber.myapplication.model.data.server.models.JokeResponse
import com.yakow.weber.myapplication.model.data.server.models.JokeSitesResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created on 24.02.19
 * @author YWeber */

interface Api {
    @GET("api/sources")
    fun getAllDataSourceAna(): Single<List<List<JokeSitesResponse>>>

    @GET("api/get")
    fun getJokes(
        @Query("site") site: String = "bash.im",
        @Query("name") name: String = "bash",
        @Query("num") num: Int = 100
    ): Single<List<JokeResponse>>
}