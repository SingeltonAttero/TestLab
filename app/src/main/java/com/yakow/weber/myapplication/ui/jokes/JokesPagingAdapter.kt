package com.yakow.weber.myapplication.ui.jokes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.yakow.weber.myapplication.R
import com.yakow.weber.myapplication.entity.Joke
import com.yakow.weber.myapplication.ui.base.adapter.BaseViewHolder
import kotlinx.android.synthetic.main.item_jokes_adapter.view.*

/**
 * Created on 27.02.19
 * @author YWeber */

class JokesPagingAdapter() :
    PagedListAdapter<Joke, JokesPagingAdapter.JokesViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokesPagingAdapter.JokesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_jokes_adapter, parent, false)
        return JokesViewHolder(view)
    }

    override fun onBindViewHolder(holder: JokesPagingAdapter.JokesViewHolder, position: Int) {
        getItem(position)?.let { item -> holder.bind(item) }
    }

    class JokesViewHolder(itemView: View) : BaseViewHolder<Joke>(itemView) {
        override fun bind(item: Joke) {
            itemView.jokesContentView.text = item.content
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Joke>() {
        override fun areItemsTheSame(oldItem: Joke, newItem: Joke): Boolean = oldItem.content == newItem.content
        override fun areContentsTheSame(oldItem: Joke, newItem: Joke): Boolean = oldItem == newItem
    }
}