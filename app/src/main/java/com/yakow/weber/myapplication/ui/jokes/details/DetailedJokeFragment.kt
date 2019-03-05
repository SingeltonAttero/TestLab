package com.yakow.weber.myapplication.ui.jokes.details

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.navigation.Navigation
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.yakow.weber.myapplication.R
import com.yakow.weber.myapplication.entity.Joke
import com.yakow.weber.myapplication.extension.rxOnClickListener
import com.yakow.weber.myapplication.extension.toSpanned
import com.yakow.weber.myapplication.presenter.jokes.detailed.DetailedJokePresenter
import com.yakow.weber.myapplication.presenter.jokes.detailed.DetailedJokeView
import com.yakow.weber.myapplication.toothpick.DI
import com.yakow.weber.myapplication.toothpick.system.router.NavigatorRouter
import com.yakow.weber.myapplication.toothpick.system.router.RouterProvider
import com.yakow.weber.myapplication.ui.base.BaseFragment
import com.yakow.weber.myapplication.ui.jokes.dialog.SaveDatabaseDialog
import com.yakow.weber.myapplication.ui.jokes.dialog.Select
import kotlinx.android.synthetic.main.fragment_detailed_joke.*
import org.jetbrains.anko.support.v4.share
import org.jetbrains.anko.support.v4.toast
import toothpick.Toothpick

/**
 * Created on 28.02.19
 * @author YWeber */

class DetailedJokeFragment : BaseFragment(), DetailedJokeView {
    companion object {
        private const val DIALOG_SAVE = "dialog save db"
    }

    @InjectPresenter
    lateinit var presenter: DetailedJokePresenter

    private val router: RouterProvider
        get() = NavigatorRouter(Navigation.findNavController(context as FragmentActivity, R.id.navHostFragment))

    @ProvidePresenter
    fun providerPresenter(): DetailedJokePresenter = Toothpick
            .openScope(DI.MENU_SCOPE)
            .getInstance(DetailedJokePresenter::class.java)

    override val layoutRes: Int
        get() = R.layout.fragment_detailed_joke

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        toolbar?.setDisplayHomeAsUpEnabled(true)
        toolbar?.title = getString(R.string.jokes)
        jokesFab.rxOnClickListener {
            SaveDatabaseDialog.newInstance {
                when (it) {
                    is Select.Positive -> presenter.saveJoke()
                    is Select.Negative -> toast("negative")
                }
            }.show(childFragmentManager, DIALOG_SAVE)
        }.bind()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
            when (item.itemId) {
                R.id.shareItem -> {
                    share(presenter.joke.content.toSpanned().toString())
                    true
                }
                android.R.id.home -> {
                    router.back()
                    true
                }
                else -> super.onOptionsItemSelected(item)
            }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.joke_menu, menu)
    }

    override fun onStop() {
        toolbar?.setDisplayHomeAsUpEnabled(false)
        super.onStop()
    }

    override fun bindJoke(joke: Joke) {
        jokeContentView.text = joke.content.toSpanned()
        sourceView.text = joke.description
    }


}