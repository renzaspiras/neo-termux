package com.termux.app.terminal.Inject;

import com.termux.app.terminal.cmx.Linux;
import com.termux.app.terminal.Lazy.Automation;
import com.termux.app.terminal.Lazy.Clock;
import com.termux.app.terminal.Lazy.Filex;
import com.termux.app.terminal.Lazy.Messages;

import android.app.Activity;
import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import java.nio.file.Files;

public class Core{
    Automation auto = new Automation();
    Linux linux = new Linux();

    boolean init = false;

    public Core(Context cont, Activity act, AppCompatActivity aca){
        Messages msg = new Messages(cont);

        Runnable run = new Runnable() {
            @Override
            public void run() {
                boolean TERMUX = Filex.doesFolderExist(expanded_path("TERMUX"));
                boolean TOKEN = Filex.doesFileExist(expanded_path("TERMUX/TOKEN"));
                if (TERMUX) {
                    if(!TOKEN){
                        install(cont, act, aca);
                    }
                    else {
                        init = true;
                    }
                }
                else {
                    if(!TOKEN){
                        Filex.createFolder(expanded_path("TERMUX"));
                        init = true;
                        install(cont, act, aca);
                    }
                    else {
                        init = true;
                    }
                }
            }
        };
        boolean consent = Filex.checkAndRequestPermission(act, run);

        if (!consent) {
            if(init){
                //msg.Toaster("Re-open the App..."); Just ignore
            }
            else {
                msg.Toaster("Please Enable the Storage Permission Manually...");
            }
            linux.clear(aca);
            Filex.checkAndRequestPermission(act, run);
        }
    }

    private void install(Context cont, Activity act, AppCompatActivity aca){
        Messages msg = new Messages(cont);
        linux.termux_setup_storage(aca);
        linux.enter(aca);
        linux.termux_setup_storage(aca);
        linux.enter(aca);
        linux.ls(aca);
        Filex.downloadFileFromURL(aca, "https://raw.githubusercontent.com/renzaspiras/arch-termux/main/cmx.sh");
        msg.Toaster("Access Granted");
    }

    private String expanded_path(String FileName){
        FileName = "/storage/emulated/0/" + FileName;
        return FileName;
    }

}
