package com.yakow.weber.myapplication.toothpick.system.executor

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor

/**
 * Created on 28.02.19
 * @author YWeber */

class MainThreadExecutor : Executor {
    private val handler = Handler(Looper.getMainLooper())
    override fun execute(command: Runnable?) {
        handler.post(command)
    }
}