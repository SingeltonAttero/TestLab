package com.yakow.weber.myapplication.entity

import com.yakow.weber.myapplication.model.data.server.models.JokeResponse

/**
 * Created on 26.02.19
 * @author YWeber */
 
data class Joke (val description:String,
                 val content:String){

    companion object {
        fun convertResponseToEntity(response:JokeResponse) = Joke(response.desc,response.elementPureHtml)
    }
}