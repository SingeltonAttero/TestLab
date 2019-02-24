package com.yakow.weber.myapplication.toothpick.system.schedulers

import io.reactivex.Scheduler

/**
 * Created on 05.02.19
 * @author YWeber */

interface SchedulersProvider {
    fun ui(): Scheduler
    fun computation(): Scheduler
    fun trampoline(): Scheduler
    fun newThread(): Scheduler
    fun io(): Scheduler
}