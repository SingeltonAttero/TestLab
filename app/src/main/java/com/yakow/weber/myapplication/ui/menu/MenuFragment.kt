package com.yakow.weber.myapplication.ui.menu

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.yakow.weber.myapplication.R
import com.yakow.weber.myapplication.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_menu.*

/**
 * Created on 25.02.19
 * @author YWeber */

class MenuFragment : BaseFragment() {
    override val layoutRes: Int
        get() = R.layout.fragment_menu

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val menuNavController = Navigation.findNavController(context as FragmentActivity,R.id.nav_menu_host_fragment)
        NavigationUI.setupWithNavController(bottomNavigationView, menuNavController)
    }
}