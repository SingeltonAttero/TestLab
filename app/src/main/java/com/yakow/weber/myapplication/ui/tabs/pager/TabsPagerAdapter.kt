package com.yakow.weber.myapplication.ui.tabs.pager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.yakow.weber.myapplication.toothpick.favorites.FavoritesFragment
import com.yakow.weber.myapplication.ui.about.AboutFragment
import com.yakow.weber.myapplication.ui.sites.SitesFragment

/**
 * Created on 07.03.19
 * @author YWeber */

class TabsPagerAdapter(fragmentManager: FragmentManager,
                       private val countTab: Int) : FragmentStatePagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment = when (position) {
        0 -> {
            SitesFragment()
        }
        else -> {
            FavoritesFragment()
        }
    }

    override fun getCount(): Int = countTab
}