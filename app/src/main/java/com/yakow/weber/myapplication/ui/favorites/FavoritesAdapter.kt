package com.yakow.weber.myapplication.ui.favorites

import android.view.View
import com.yakow.weber.myapplication.R
import com.yakow.weber.myapplication.entity.Favorites
import com.yakow.weber.myapplication.extension.toSpanned
import com.yakow.weber.myapplication.ui.base.adapter.BaseRecyclerAdapter
import com.yakow.weber.myapplication.ui.base.adapter.BaseViewHolder
import kotlinx.android.synthetic.main.item_favorites_adapter.view.*

/**
 * Created on 12.03.19
 * @author YWeber */

class FavoritesAdapter(override var dataSet: MutableList<Favorites>) : BaseRecyclerAdapter<Favorites, FavoritesAdapter.FavoritesViewHolder>() {

    override fun createViewHolder(view: View, viewType: Int): FavoritesViewHolder = FavoritesViewHolder(view)

    override fun getLayoutIdForPosition(position: Int): Int = R.layout.item_favorites_adapter

    inner class FavoritesViewHolder(itemView: View) : BaseViewHolder<Favorites>(itemView) {
        override fun bind(item: Favorites) {
            itemView.saveDateView.text = item.saveDate
            itemView.saveTypeContentView.text = item.typeContent
            itemView.saveContentView.text = item.content.toSpanned()

        }
    }
}