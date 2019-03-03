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
import com.yakow.weber.myapplication.extension.toSpanned
import com.yakow.weber.myapplication.presenter.jokes.detailed.DetailedJokePresenter
import com.yakow.weber.myapplication.presenter.jokes.detailed.DetailedJokeView
import com.yakow.weber.myapplication.toothpick.DI
import com.yakow.weber.myapplication.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_detailed_joke.*
import org.jetbrains.anko.support.v4.toast
import toothpick.Toothpick

/**
 * Created on 28.02.19
 * @author YWeber */

class DetailedJokeFragment : BaseFragment(), DetailedJokeView {

    @InjectPresenter
    lateinit var presenter: DetailedJokePresenter

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
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
            when (item.itemId) {
                R.id.shareItem -> {
                    toast("test")
                    true
                }
                android.R.id.home -> {
                    Navigation.findNavController(context as FragmentActivity,R.id.navHostFragment).popBackStack()
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