package com.yakow.weber.myapplication.ui.favorites

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.yakow.weber.myapplication.R
import com.yakow.weber.myapplication.entity.Favorites
import com.yakow.weber.myapplication.presenter.favorites.FavoritesPresenter
import com.yakow.weber.myapplication.presenter.favorites.FavoritesView
import com.yakow.weber.myapplication.toothpick.DI
import com.yakow.weber.myapplication.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_favorites.*
import toothpick.Toothpick

/**
 * Created on 12.03.19
 * @author YWeber */

class FavoritesFragment : BaseFragment(), FavoritesView {

    @InjectPresenter
    lateinit var presenter: FavoritesPresenter

    @ProvidePresenter
    fun providerPresenter(): FavoritesPresenter = Toothpick.openScope(DI.MENU_SCOPE)
            .getInstance(FavoritesPresenter::class.java)

    override val layoutRes: Int
        get() = R.layout.fragment_favorites

    lateinit var favoritesAdapter: FavoritesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        favoritesAdapter = FavoritesAdapter(mutableListOf())
        favoritesRecycler.adapter = favoritesAdapter
        favoritesRecycler.layoutManager = LinearLayoutManager(context)
    }

    override fun bindFavorites(favoritesList: List<Favorites>) {
        favoritesAdapter.replaceData(favoritesList)
    }

}