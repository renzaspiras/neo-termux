package com.termux.app.terminal.Lazy;

import static androidx.core.view.KeyEventDispatcher.dispatchKeyEvent;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.KeyEvent;
import android.widget.Toast;
import android.content.Context;

import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Automation extends  AppCompatActivity{

    public  void openURL(Context context, String url){
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        }
    }
    public void keyPress(Activity activity, int keyCode) {
        activity.dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, keyCode));
    }

    public void Reload(Activity activity) {
        // Get the class name of the main activity
        String className = activity.getClass().getName();

        // Create an intent to start the main activity
        Intent intent = new Intent(activity, activity.getClass());
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        // Start the new instance of the main activity
        activity.startActivity(intent);

        // Finish the current activity
        activity.finish();
    }
}
