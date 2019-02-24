package com.yakow.weber.myapplication.presenter

import com.arellomobile.mvp.MvpView

/**
 * Created on 24.02.19
 * @author YWeber
 * project CodeTestLab */

interface MainView : MvpView {
    fun showToastError(message: String)
}