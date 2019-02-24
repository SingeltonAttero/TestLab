package com.yakow.weber.myapplication.model.repository

import com.yakow.weber.myapplication.entity.JokeSites
import com.yakow.weber.myapplication.model.data.server.Api
import com.yakow.weber.myapplication.toothpick.system.schedulers.SchedulersProvider
import io.reactivex.Single
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created on 24.02.19
 * @author YWeber */

class SitesRepository @Inject constructor(private val api: Api,
                                          private val schedulers: SchedulersProvider) {

    fun loadAllSites(): Single<List<JokeSites>> = api.getAllDataSourceAna()
            .map { listResponse ->
                listResponse.reduce { acc, list -> acc.plus(list) }
                        .map { JokeSites.convertResponseToEntity(it) }
            }
            .delay(25,TimeUnit.SECONDS)
            .subscribeOn(schedulers.io())
            .observeOn(schedulers.ui())


}