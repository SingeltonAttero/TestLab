package com.yakow.weber.myapplication.toothpick.system.executor

import java.util.concurrent.Executor
import java.util.concurrent.Executors

/**
 * Created on 28.02.19
 * @author YWeber */

class AppExecutors : ExecutorsProvider {
    override fun newSingleThreadExecutor(): Executor = Executors.newSingleThreadExecutor()
    override fun mainThreadExecutor(): Executor = MainThreadExecutor()
}