package com.yakow.weber.myapplication.ui.jokes.dialog

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import com.yakow.weber.myapplication.R
import com.yakow.weber.myapplication.toothpick.system.androidx.MvpAppCompatDialogFragment

/**
 * Created on 03.03.19
 * @author YWeber */

class SaveDatabaseDialog : MvpAppCompatDialogFragment() {

    companion object {
        fun newInstance(click: (button: Select) -> Unit) = SaveDatabaseDialog().apply {
            this.click = click
        }
    }

    private lateinit var click: (button: Select) -> Unit

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        isCancelable = false
        return inflater.inflate(R.layout.dialog_save_database, container, false)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(activity as FragmentActivity, R.style.SaveDatabaseDialogTheme)
            .setIcon(ContextCompat.getDrawable(this.context!!, R.drawable.icon_jokes))
            .setTitle(getString(R.string.save_joke_from_bd))
            .setMessage(getString(R.string.this_joke_available_favorits))
            .setPositiveButton(getString(R.string.save_db)) { _, _ -> click(Select.Positive) }
            .setNegativeButton(getString(R.string.cancel_saved)) { _, _ -> click(Select.Negative) }
            .create()
    }


    override fun getTheme(): Int {
        return android.R.style.Theme_Black_NoTitleBar_Fullscreen
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setWindowAnimations(R.style.Animation_Design_BottomSheetDialog)
    }
}

sealed class Select {
    object Positive : Select()
    object Negative : Select()
}