package com.yakow.weber.myapplication.toothpick.system.message

/**
 * Created on 22.02.19
 * @author YWeber */

data class SystemMessage (
    val message: String,
    val type: SystemMessageType = SystemMessageType.TOAST
)