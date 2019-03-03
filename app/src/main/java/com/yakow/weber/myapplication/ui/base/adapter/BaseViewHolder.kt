package com.yakow.weber.myapplication.ui.base.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created on 13.02.19
 * @author YWeber */
abstract class BaseViewHolder<T>(view: View) : RecyclerView.ViewHolder(view) {

    private val containerView: View
        get() = itemView

    abstract fun bind(item: T)

}