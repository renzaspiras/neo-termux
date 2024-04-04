package com.termux.app.terminal.Lazy;

import android.content.Context;
import android.widget.Toast;
import android.app.AlertDialog;

public class Messages {
    private final Context context;

    public Messages(Context context) {
        this.context = context;
    }

    public  void Toaster(String msg){
        Toast.makeText(context,msg, Toast.LENGTH_SHORT).show();
    }

    public void  Dialog(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title)
            .setMessage(message)
            .setPositiveButton("OK", null)
            .show();
    }
}
