package com.termux.app.terminal.Lazy;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.KeyEvent;
import android.content.Context;;
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
}
