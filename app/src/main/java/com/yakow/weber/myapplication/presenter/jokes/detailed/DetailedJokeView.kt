package com.yakow.weber.myapplication.presenter.jokes.detailed

import com.arellomobile.mvp.MvpView
import com.yakow.weber.myapplication.entity.Joke

/**
 * Created on 02.03.19
 * @author YWeber */

interface DetailedJokeView : MvpView {
    fun bindJoke(joke:Joke)
}