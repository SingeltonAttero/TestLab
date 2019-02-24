package com.yakow.weber.myapplication.ui

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.yakow.weber.myapplication.R
import com.yakow.weber.myapplication.presenter.MainPresenter
import com.yakow.weber.myapplication.presenter.MainView
import com.yakow.weber.myapplication.toothpick.DI
import com.yakow.weber.myapplication.toothpick.system.androidx.MvpAppCompatActivity
import org.jetbrains.anko.toast
import toothpick.Toothpick

/**
 * Created on 24.02.19
 * @author YWeber
 * project CodeTestLab */
class MainActivity : MvpAppCompatActivity(), MainView {

    @InjectPresenter
    lateinit var presenter: MainPresenter

    @ProvidePresenter
    fun providerPresenter(): MainPresenter = Toothpick
        .openScope(DI.APP_SCOPE)
        .getInstance(MainPresenter::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun showToastError(message: String) {
        toast(message).show()
    }
}
