package com.yakow.weber.myapplication.ui.about

import android.os.Bundle
import android.view.View
import com.yakow.weber.myapplication.R
import com.yakow.weber.myapplication.ui.base.BaseFragment

/**
 * Created on 26.02.19
 * @author YWeber */

class AboutFragment  : BaseFragment() {
    override val layoutRes: Int
        get() = R.layout.fragment_about

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar?.title = getString(R.string.about)
    }
}