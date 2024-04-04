package com.termux.app.terminal.Lazy;

import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import android.content.Context;

import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;


public class Automation {

    public  void openURL(Context context, String url){
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        }
    }
}
