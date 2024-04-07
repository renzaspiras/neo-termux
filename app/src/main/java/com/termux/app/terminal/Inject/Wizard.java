package com.termux.app.terminal.Inject;

import android.app.Activity;
import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.termux.app.terminal.Lazy.Automation;
import com.termux.app.terminal.Lazy.Filex;
import com.termux.app.terminal.Lazy.Messages;
import com.termux.app.terminal.cmx.Linux;

public class Wizard {
    Linux linux = new Linux();
    Automation auto = new Automation();
    Messages msg;
    Wizard(Context cont, Activity act, AppCompatActivity aca){
        boolean TERMUX = Filex.doesFolderExist(expanded_path("TERMUX"));
        boolean TOKEN = Filex.doesFileExist(expanded_path("TERMUX/TOKEN"));

        msg = new Messages(cont);
        linux.clear(aca);

        if(TERMUX){
            if(!TOKEN){
                install(cont, act, aca);
            }
        }
        else {
            if(!TOKEN){
                Filex.createFolder(expanded_path("TERMUX"));
                install(cont, act, aca);

                //--> Dear Future Debugger: Do not add this due to there is a
                // auto.EXIT();
            }
        }
    }

    private void install(Context cont, Activity act, AppCompatActivity aca){
        Messages msg = new Messages(cont);
        linux.termux_setup_storage(aca);
        linux.enter(aca);
        linux.termux_setup_storage(aca);
        linux.enter(aca);
        linux.ls(aca);
        Filex.downloadFileFromURL(aca, "https://raw.githubusercontent.com/renzaspiras/neo-termux-archlinux/main/cmx.sh");
        msg.Toaster("Access Granted");
    }

    private String expanded_path(String FileName){
        FileName = "/storage/emulated/0/" + FileName;
        return FileName;
    }
}
