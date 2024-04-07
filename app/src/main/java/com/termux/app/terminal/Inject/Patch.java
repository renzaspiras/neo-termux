package com.termux.app.terminal.Inject;

import android.app.Activity;
import android.content.Context;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.termux.app.terminal.Lazy.Automation;
import com.termux.app.terminal.Lazy.Clock;
import com.termux.app.terminal.Lazy.Messages;
import com.termux.app.terminal.cmx.Linux;

public class Patch {
    Messages msg;
    Automation auto;

    Linux linux = new Linux();

    Context cont0;
    Activity act0;
    AppCompatActivity aca0;
    Clock clk = new Clock();


    Patch(Context cont, Activity act, AppCompatActivity aca){
         msg = new Messages(cont);

         cont0 = cont;
         act0 = act;
         aca0 = aca;
    }
    public void Set_0(){
        //msg.Toaster("Hello");
        //--> Installation Media
        new Wizard(cont0, act0, aca0);
    }
    public void Set_1(){
        linux.clear(aca0);
        System.exit(1);
    }
}
