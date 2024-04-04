package com.termux.app.terminal.Inject;

import com.termux.app.terminal.Lazy.Automation;
import com.termux.app.terminal.Lazy.Messages;
import android.content.Context;

public class Core{
    public Core(Context cont){
        Messages msg = new Messages(cont);
        Automation auto = new Automation();

        // Sample COde
        //msg.Toaster("Testing");
        //auto.openURL(cont, "https://google.com");
        //msg.Dialog("Consent", "Hello World");

    }
}
