package com.yakow.weber.myapplication.ui.menu

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.yakow.weber.myapplication.R
import com.yakow.weber.myapplication.model.interactor.JokesInteractor
import com.yakow.weber.myapplication.model.repository.JokesRepository
import com.yakow.weber.myapplication.toothpick.DI
import com.yakow.weber.myapplication.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_menu.*
import timber.log.Timber
import toothpick.Toothpick
import toothpick.config.Module

/**
 * Created on 25.02.19
 * @author YWeber */

class MenuFragment : BaseFragment() {
    override val layoutRes: Int
        get() = R.layout.fragment_menu

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val menuNavController = Navigation.findNavController(context as FragmentActivity, R.id.navMenuHostFragment)
        NavigationUI.setupWithNavController(bottomNavigationView, menuNavController)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Toothpick.openScopes(DI.NETWORK_SCOPE,DI.MENU_SCOPE).installModules(object : Module(){
            init {
                bind(JokesInteractor::class.java).to(JokesInteractor::class.java).singletonInScope()
                bind(JokesRepository::class.java).to(JokesRepository::class.java).singletonInScope()
                Timber.e("init interactor and repository")
            }
        })
        super.onCreate(savedInstanceState)
    }
}