package com.termux.app.terminal.Lazy;

import android.os.Handler;

public class Clock {
    public void CommandDelay(int totalDellayMillis, Runnable action){
        new Handler().postDelayed(action, (long) totalDellayMillis);
    }
}
