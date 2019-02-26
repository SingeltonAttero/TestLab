package com.yakow.weber.myapplication.presenter.sites

import com.arellomobile.mvp.InjectViewState
import com.yakow.weber.myapplication.entity.JokeSites
import com.yakow.weber.myapplication.extension.userMessage
import com.yakow.weber.myapplication.model.interactor.SitesInteractor
import com.yakow.weber.myapplication.presenter.base.BasePresenter
import com.yakow.weber.myapplication.toothpick.system.ResourceManager
import com.yakow.weber.myapplication.toothpick.system.message.SystemMessageNotifier
import timber.log.Timber
import javax.inject.Inject

/**
 * Created on 24.02.19
 * @author YWeber */
@InjectViewState
class SitesPresenter @Inject constructor(private val systemMessage: SystemMessageNotifier,
                                         private val interactor: SitesInteractor,
                                         private val resourceManager: ResourceManager
) : BasePresenter<SitesView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        interactor.getSites()
                .doOnSubscribe { viewState.showProgress(true) }
                .doAfterTerminate { viewState.showProgress(false) }
                .subscribe({
                    viewState.siteList(it)
                },{
                    Timber.e(it)
                    systemMessage.systemMessage(it.userMessage(resourceManager))
                }).bind()
    }

    fun goToDetails(jokeSites: JokeSites) = systemMessage.systemMessage(jokeSites.toString())
}