package com.yakow.weber.myapplication.ui.sites

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.yakow.weber.myapplication.R
import com.yakow.weber.myapplication.entity.JokeSites
import com.yakow.weber.myapplication.presenter.sites.SitesPresenter
import com.yakow.weber.myapplication.presenter.sites.SitesView
import com.yakow.weber.myapplication.toothpick.DI
import com.yakow.weber.myapplication.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_sites.*
import toothpick.Toothpick

/**
 * Created on 24.02.19
 * @author YWeber */

class SitesFragment : BaseFragment(), SitesView {

    @InjectPresenter
    lateinit var presenter: SitesPresenter

    @ProvidePresenter
    fun providerPresenter(): SitesPresenter = Toothpick
            .openScope(DI.NETWORK_SCOPE)
            .getInstance(SitesPresenter::class.java)

    private lateinit var adapter: SitesAdapter

    override val layoutRes: Int
        get() = R.layout.fragment_sites

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar?.title = getString(R.string.source)
        adapter = SitesAdapter(compositeDisposable, mutableListOf()) { presenter.goToDetails(it) }
        sitesRecycler.adapter = adapter
        sitesRecycler.layoutManager = LinearLayoutManager(this.activity)
    }

    override fun showProgress(visible: Boolean) {
        showDialog(visible)
    }

    override fun siteList(sites: List<JokeSites>) {
        adapter.replaceData(sites.toMutableList())
    }

}