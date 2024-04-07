package com.termux.app.terminal.Lazy

import android.os.Handler

class Clock {
    fun CommandDelay(totalDelayMillis:Int, action:Runnable){
        Handler().postDelayed(action, totalDelayMillis.toLong())
    }
}
