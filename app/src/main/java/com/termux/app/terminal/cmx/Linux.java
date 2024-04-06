package com.termux.app.terminal.cmx;

import android.content.Context;
import android.content.res.AssetManager;
import android.view.KeyEvent;

import androidx.appcompat.app.AppCompatActivity;

import com.termux.app.terminal.Lazy.Automation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Linux extends AppCompatActivity {
    Automation auto = new Automation();



    public void clear(AppCompatActivity aca){

        auto.keyPress(aca, KeyEvent.KEYCODE_C);
        auto.keyPress(aca, KeyEvent.KEYCODE_L);
        auto.keyPress(aca, KeyEvent.KEYCODE_E);
        auto.keyPress(aca, KeyEvent.KEYCODE_A);
        auto.keyPress(aca, KeyEvent.KEYCODE_R);
        auto.keyPress(aca, KeyEvent.KEYCODE_ENTER);
    }

    public  void ls(AppCompatActivity aca){
        auto.keyPress(aca, KeyEvent.KEYCODE_L);
        auto.keyPress(aca, KeyEvent.KEYCODE_S);
        auto.keyPress(aca, KeyEvent.KEYCODE_ENTER);
    }

    public void termux_setup_storage(AppCompatActivity aca){
        auto.keyPress(aca,KeyEvent.KEYCODE_T);
        auto.keyPress(aca,KeyEvent.KEYCODE_E);
        auto.keyPress(aca,KeyEvent.KEYCODE_R);
        auto.keyPress(aca,KeyEvent.KEYCODE_M);
        auto.keyPress(aca,KeyEvent.KEYCODE_U);
        auto.keyPress(aca,KeyEvent.KEYCODE_X);
        auto.keyPress(aca,KeyEvent.KEYCODE_MINUS);
        auto.keyPress(aca,KeyEvent.KEYCODE_S);
        auto.keyPress(aca,KeyEvent.KEYCODE_E);
        auto.keyPress(aca,KeyEvent.KEYCODE_T);
        auto.keyPress(aca,KeyEvent.KEYCODE_U);
        auto.keyPress(aca,KeyEvent.KEYCODE_P);
        auto.keyPress(aca,KeyEvent.KEYCODE_MINUS);
        auto.keyPress(aca,KeyEvent.KEYCODE_S);
        auto.keyPress(aca,KeyEvent.KEYCODE_T);
        auto.keyPress(aca,KeyEvent.KEYCODE_O);
        auto.keyPress(aca,KeyEvent.KEYCODE_R);
        auto.keyPress(aca,KeyEvent.KEYCODE_A);
        auto.keyPress(aca,KeyEvent.KEYCODE_G);
        auto.keyPress(aca,KeyEvent.KEYCODE_E);

    }

    public void yes(AppCompatActivity aca){
        auto.keyPress(aca,KeyEvent.KEYCODE_SPACE);
        auto.keyPress(aca,KeyEvent.KEYCODE_MINUS);
        auto.keyPress(aca,KeyEvent.KEYCODE_Y);
        enter(aca);
    }

    public void enter(AppCompatActivity aca){
        auto.keyPress(aca,KeyEvent.KEYCODE_ENTER);
    }

    public void inject_cmx_utils(AppCompatActivity aca){
        auto.keyPress(aca,KeyEvent.KEYCODE_B);
        auto.keyPress(aca,KeyEvent.KEYCODE_A);
        auto.keyPress(aca,KeyEvent.KEYCODE_S);
        auto.keyPress(aca,KeyEvent.KEYCODE_H);

        auto.keyPress(aca,KeyEvent.KEYCODE_SPACE);
        auto.keyPress(aca,KeyEvent.KEYCODE_S);
        auto.keyPress(aca,KeyEvent.KEYCODE_T);
        auto.keyPress(aca,KeyEvent.KEYCODE_O);
        auto.keyPress(aca,KeyEvent.KEYCODE_R);
        auto.keyPress(aca,KeyEvent.KEYCODE_A);
        auto.keyPress(aca,KeyEvent.KEYCODE_G);
        auto.keyPress(aca,KeyEvent.KEYCODE_E);
        auto.keyPress(aca,KeyEvent.KEYCODE_SLASH);
        auto.keyPress(aca,KeyEvent.KEYCODE_D);
        auto.keyPress(aca,KeyEvent.KEYCODE_O);
        auto.keyPress(aca,KeyEvent.KEYCODE_W);
        auto.keyPress(aca,KeyEvent.KEYCODE_N);
        auto.keyPress(aca,KeyEvent.KEYCODE_L);
        auto.keyPress(aca,KeyEvent.KEYCODE_O);
        auto.keyPress(aca,KeyEvent.KEYCODE_A);
        auto.keyPress(aca,KeyEvent.KEYCODE_D);
        auto.keyPress(aca,KeyEvent.KEYCODE_S);
        auto.keyPress(aca,KeyEvent.KEYCODE_SLASH);
        auto.keyPress(aca,KeyEvent.KEYCODE_C);
        auto.keyPress(aca,KeyEvent.KEYCODE_M);
        auto.keyPress(aca,KeyEvent.KEYCODE_X);
        auto.keyPress(aca,56);
        auto.keyPress(aca,KeyEvent.KEYCODE_S);
        auto.keyPress(aca,KeyEvent.KEYCODE_H);
        auto.keyPress(aca,KeyEvent.KEYCODE_ENTER);

    }

}
