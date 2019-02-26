package com.yakow.weber.myapplication.ui.jokes

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.yakow.weber.myapplication.R
import com.yakow.weber.myapplication.entity.Joke
import com.yakow.weber.myapplication.presenter.jokes.JokesPresenter
import com.yakow.weber.myapplication.presenter.jokes.JokesView
import com.yakow.weber.myapplication.toothpick.DI
import com.yakow.weber.myapplication.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_jokes.*
import toothpick.Toothpick

/**
 * Created on 26.02.19
 * @author YWeber */

class JokesFragment : BaseFragment(), JokesView {


    @InjectPresenter
    lateinit var presenter: JokesPresenter

    @ProvidePresenter
    fun providerPresenter(): JokesPresenter = Toothpick
            .openScope(DI.NETWORK_SCOPE)
            .getInstance(JokesPresenter::class.java)

    override val layoutRes: Int
        get() = R.layout.fragment_jokes

    private lateinit var adapter: JokesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar?.title = getString(R.string.jokes)
        adapter = JokesAdapter(mutableListOf())
        jokesRecycler.adapter = adapter
        jokesRecycler.layoutManager = LinearLayoutManager(context)
    }

    override fun bindJokes(listJoke: List<Joke>) {
        adapter.replaceData(listJoke.toMutableList())
    }

    override fun showProgress(visible: Boolean) {
        showDialog(visible)
    }
}