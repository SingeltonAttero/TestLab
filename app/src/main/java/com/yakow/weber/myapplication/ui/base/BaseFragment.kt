package com.yakow.weber.myapplication.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.app.ActionBar
import com.yakow.weber.myapplication.toothpick.system.disposable.ComponentDisposables
import com.yakow.weber.myapplication.toothpick.system.disposable.ComponentDisposablesProvider
import com.yakow.weber.myapplication.ui.MainActivity
import com.yakow.weber.myapplication.toothpick.system.androidx.MvpAppCompatFragment

/**
 * Created on 13.02.19
 * @author YWeber */

abstract class BaseFragment : MvpAppCompatFragment(), ComponentDisposablesProvider by ComponentDisposables() {
    companion object {
        const val DIALOG_TAG = "dialog fragment"
    }

    val toolbar: ActionBar?
        get() = (activity as MainActivity).supportActionBar

    abstract val layoutRes: Int @LayoutRes get

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutRes, container, false)
    }

    fun showDialog(progress: Boolean) {
        val fragment = childFragmentManager.findFragmentByTag(DIALOG_TAG)
        if (fragment != null && !progress) {
            (fragment as ProgressDialogFragment).dismissAllowingStateLoss()
            childFragmentManager.executePendingTransactions()
        } else if (fragment == null && progress) {
            val progressDialogFragment = ProgressDialogFragment()
            progressDialogFragment.show(childFragmentManager, DIALOG_TAG)
            childFragmentManager.executePendingTransactions()
        }
    }
    override fun onDestroy() {
        clear()
        super.onDestroy()
    }
}