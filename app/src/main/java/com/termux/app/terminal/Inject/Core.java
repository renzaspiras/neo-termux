package com.termux.app.terminal.Inject;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import androidx.appcompat.app.AppCompatActivity;

import com.termux.app.terminal.Lazy.Messages;

public class Core {
    // Automation auto = new Automation();
    // Linux linux = new Linux();
    boolean init = false;
    Messages msg;

    public Core(Context cont, Activity act, AppCompatActivity aca) {
        msg = new Messages(cont);
        Conduct cond = new Conduct(cont, act, aca);
        Conduct.requestFilePermission(act);
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        msg.Toaster("ok?");
        if (requestCode == Conduct.REQUEST_FILE_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted
                // You can proceed with your logic here
            } else {
                // Permission denied
                // Handle the denial case here
            }
        }
    }
}
