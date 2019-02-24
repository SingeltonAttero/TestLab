package com.yakow.weber.myapplication.presenter

import com.arellomobile.mvp.InjectViewState
import com.yakow.weber.myapplication.presenter.base.BasePresenter
import com.yakow.weber.myapplication.toothpick.system.message.SystemMessageNotifier
import javax.inject.Inject

/**
 * Created on 24.02.19
 * @author YWeber
 * project CodeTestLab */
@InjectViewState
class MainPresenter @Inject constructor(private val systemMessage: SystemMessageNotifier) : BasePresenter<MainView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        systemMessage.notifier()
            .subscribe {
                viewState.showToastError(it.message)
            }.bind()
    }
}