package com.yakow.weber.myapplication.ui.jokes

import android.view.View
import com.yakow.weber.myapplication.R
import com.yakow.weber.myapplication.entity.Joke
import com.yakow.weber.myapplication.ui.base.adapter.BaseRecyclerAdapter
import com.yakow.weber.myapplication.ui.base.adapter.BaseViewHolder
import kotlinx.android.synthetic.main.item_jokes_adapter.view.*

/**
 * Created on 27.02.19
 * @author YWeber */

class JokesAdapter(override var dataSet: MutableList<Joke>) : BaseRecyclerAdapter<Joke, JokesAdapter.JokesViewHolder>() {

    override fun createViewHolder(view: View, viewType: Int): JokesViewHolder = JokesViewHolder(view)

    override fun getLayoutIdForPosition(position: Int): Int = R.layout.item_jokes_adapter

    inner class JokesViewHolder(itemView: View) : BaseViewHolder<Joke>(itemView) {
        override fun bind(item: Joke) {
            itemView.jokesContentView.text = item.content
        }

    }

}