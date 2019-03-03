package com.yakow.weber.myapplication.ui.sites

import android.view.View
import com.yakow.weber.myapplication.R
import com.yakow.weber.myapplication.entity.JokeSites
import com.yakow.weber.myapplication.extension.rxOnClickListener
import com.yakow.weber.myapplication.ui.base.adapter.BaseRecyclerAdapter
import com.yakow.weber.myapplication.ui.base.adapter.BaseViewHolder
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.item_sites_adapter.view.*

/**
 * Created on 24.02.19
 * @author YWeber */

class SitesAdapter(
        private val disposables: CompositeDisposable,
        override var dataSet: MutableList<JokeSites>,
                   private val clickItem: (jokeSites: JokeSites) -> Unit) : BaseRecyclerAdapter<JokeSites, SitesAdapter.SitesViewHolder>() {

    override fun createViewHolder(view: View, viewType: Int): SitesViewHolder = SitesViewHolder(view)

    override fun getLayoutIdForPosition(position: Int): Int = R.layout.item_sites_adapter

    inner class SitesViewHolder(itemView: View) : BaseViewHolder<JokeSites>(itemView) {
        override fun bind(item: JokeSites) {
            itemView.nameView.text = item.name
            itemView.siteView.text = item.url
            itemView.descriptionView.text = item.description
            disposables.add(itemView.rxOnClickListener { clickItem(item) })
        }
    }

}