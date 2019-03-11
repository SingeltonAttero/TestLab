package com.yakow.weber.myapplication.ui.jokes

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.navigation.Navigation
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.yakow.weber.myapplication.R
import com.yakow.weber.myapplication.entity.Joke
import com.yakow.weber.myapplication.presenter.jokes.JokesPresenter
import com.yakow.weber.myapplication.presenter.jokes.JokesView
import com.yakow.weber.myapplication.toothpick.DI
import com.yakow.weber.myapplication.toothpick.system.router.NavigatorRouter
import com.yakow.weber.myapplication.toothpick.system.router.RouterProvider
import com.yakow.weber.myapplication.ui.base.BaseFragment
import com.yakow.weber.myapplication.ui.jokes.adapter.JokesPagingAdapter
import kotlinx.android.synthetic.main.fragment_jokes.*
import toothpick.Toothpick

/**
 * Created on 26.02.19
 * @author YWeber */

class JokesFragment : BaseFragment(), JokesView, SwipeRefreshLayout.OnRefreshListener {
    override fun onRefresh() {
        presenter.loadJokes()
    }

    @InjectPresenter
    lateinit var presenter: JokesPresenter

    @ProvidePresenter
    fun providerPresenter(): JokesPresenter = Toothpick
            .openScope(DI.MENU_SCOPE)
            .getInstance(JokesPresenter::class.java)

    private val router:RouterProvider
        get() = NavigatorRouter(Navigation.findNavController(context as FragmentActivity,R.id.navHostFragment))

    lateinit var adapter: JokesPagingAdapter

    override val layoutRes: Int
        get() = R.layout.fragment_jokes

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar?.title = getString(R.string.jokes)
        adapter = JokesPagingAdapter(compositeDisposable) { joke -> presenter.goToDetailed(joke, router) }
        jokesRecycler.adapter = adapter
        jokesRecycler.layoutManager = LinearLayoutManager(context)
        jokesSwipeRefresh.setOnRefreshListener(this)
    }

    override fun bindJokes(jokesPagedList: PagedList<Joke>) {
        adapter.submitList(jokesPagedList)
    }

    override fun showProgress(visible: Boolean) {
        jokesSwipeRefresh.isRefreshing = visible
    }
}