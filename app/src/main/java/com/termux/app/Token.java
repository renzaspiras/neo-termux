package com.termux.app;

import android.content.Context;
import android.widget.Toast;
import java.io.File;

public class Token {

    public static boolean isTermuxDirectoryExists(Context context) {
        // Path to the Android folder
        String androidFolderPath = "/storage/emulated/0/";

        // Directory name to check
        String directoryName = "TERMUX";

        // Create a File object for the Android folder
        File androidFolder = new File(androidFolderPath);

        // Check if the Android folder exists and is a directory
        if (androidFolder.exists() && androidFolder.isDirectory()) {
            // Create a File object for the TERMUX directory inside Android folder
            File termuxDirectory = new File(androidFolder, directoryName);

            // Check if the TERMUX directory exists
            if (termuxDirectory.exists() && termuxDirectory.isDirectory()) {
                showToast(context, true);
                return true;
            }
        }
        showToast(context, false);
        return false;
    }

    private static void showToast(Context context, boolean exists) {
        //Toast.makeText(context, "TERMUX directory exists: " + exists, Toast.LENGTH_SHORT).show();
    }
}
