package com.yakow.weber.myapplication.entity

import com.yakow.weber.myapplication.model.data.server.models.JokeSitesResponse

/**
 * Created on 24.02.19
 * @author YWeber */

data class JokeSites (val url:String,
                      val name:String,
                      val description:String){

    companion object {
        fun convertResponseToEntity(response:JokeSitesResponse): JokeSites {
            return JokeSites(response.site,response.name,response.desc)
        }

    }
}