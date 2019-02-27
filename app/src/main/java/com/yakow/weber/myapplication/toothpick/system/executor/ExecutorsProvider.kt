package com.yakow.weber.myapplication.toothpick.system.executor

import java.util.concurrent.Executor

/**
 * Created on 28.02.19
 * @author YWeber */
interface ExecutorsProvider {
    fun mainThreadExecutor(): Executor
    fun newSingleThreadExecutor(): Executor
}