package com.yakow.weber.myapplication.ui.tabs

import android.os.Bundle
import android.view.View
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.yakow.weber.myapplication.R
import com.yakow.weber.myapplication.ui.base.BaseFragment
import com.yakow.weber.myapplication.ui.tabs.pager.TabsPagerAdapter
import kotlinx.android.synthetic.main.fragment_tabs.*

/**
 * Created on 07.03.19
 * @author YWeber */

class TabsFragment : BaseFragment() {
    override val layoutRes: Int
        get() = R.layout.fragment_tabs

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar?.title = getString(R.string.source)
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.source)))
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.favorites)))
        tabsViewPager.adapter = TabsPagerAdapter(childFragmentManager,tabLayout.tabCount)
        tabsViewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabsViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        toolbar?.title = getString(R.string.source)
                    }
                    else -> {
                        toolbar?.title = getString(R.string.favorites)
                    }
                }
            }

        })
    }
}