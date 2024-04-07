package com.termux.app.terminal.Lazy;

import android.os.Handler;

public class Clock {
    public void CommandDelay(int totalDelayMillis, Runnable action){
        new Handler().postDelayed(action, (long) totalDelayMillis);
    }
}
