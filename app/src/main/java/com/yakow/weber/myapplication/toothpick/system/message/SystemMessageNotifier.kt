package com.yakow.weber.myapplication.toothpick.system.message

import com.jakewharton.rxrelay2.PublishRelay
import io.reactivex.Observable

/**
 * Created on 22.02.19
 * @author YWeber */

class SystemMessageNotifier {
    private val systemMessageNotifier: PublishRelay<SystemMessage> = PublishRelay.create<SystemMessage>()
    fun notifier(): Observable<SystemMessage> = systemMessageNotifier.hide()
    fun systemMessage(message: String) = systemMessageNotifier.accept(SystemMessage(message))
    fun systemMessage(message: String, type: SystemMessageType) = systemMessageNotifier.accept(SystemMessage(message, type))
}