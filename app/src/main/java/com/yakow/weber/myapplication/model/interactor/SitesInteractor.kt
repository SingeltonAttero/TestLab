package com.yakow.weber.myapplication.model.interactor

import com.yakow.weber.myapplication.entity.JokeSites
import com.yakow.weber.myapplication.model.repository.SitesRepository
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created on 24.02.19
 * @author YWeber */

class SitesInteractor @Inject constructor( private val repository: SitesRepository) {
    fun getSites(): Single<List<JokeSites>> = repository.loadAllSites()
}