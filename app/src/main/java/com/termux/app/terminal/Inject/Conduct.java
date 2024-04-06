package com.termux.app.terminal.Inject;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class Conduct {
    static Patch p;
    Conduct(Context cont, Activity act, AppCompatActivity aca){
        p = new Patch(cont,act, aca);
    }


    public static final int REQUEST_FILE_PERMISSION = 1;

    public static void requestFilePermission(Activity activity) {
        // Check if permission is not granted
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED) {

            // Request the permission
            ActivityCompat.requestPermissions(activity,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                REQUEST_FILE_PERMISSION);
        } else {
            // Permission is already granted
            p.Set_0();
        }
    }

    // Handle permission request result
    public static void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults, Activity activity) {
        if (requestCode == REQUEST_FILE_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted
                p.Set_0();
            } else {
                // Permission denied
                p.Set_1();
            }
        }
    }
}
