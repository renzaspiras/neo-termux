package com.termux.app.terminal.Lazy;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.termux.app.TermuxActivity;

public class Filex {
    private static final int STORAGE_PERMISSION_CODE = 1;

    private static ProgressDialog pDialog;
    private static final int progress_bar_type = 0;

    public static boolean doesFolderExist(String folderPath) {
        File folder = new File(folderPath);
        return folder.exists() && folder.isDirectory();
    }

    public static boolean doesFileExist(String filePath) {
        File file = new File(filePath);
        return file.exists() && file.isFile();
    }

    public static void createFolder(String folderPath) {
        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
    }

    public static boolean createFile(String filePath) {
        File file = new File(filePath);
        try {
            return file.createNewFile(); // Attempt to create the file
        } catch (IOException e) {
            return false; // Unable to create the file
        }
    }

    public static boolean checkAndRequestPermission(Activity activity, Runnable onPermissionChecked) {
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED ||
            ContextCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission not granted, request it
            ActivityCompat.requestPermissions(activity,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE},
                STORAGE_PERMISSION_CODE);
        } else {
            // Permissions already granted, execute the Runnable
            if (onPermissionChecked != null) {
                onPermissionChecked.run();
            }
        }
        return false;
    }

    // Method to handle the result of the permission request
    public static void onRequestPermissionsResult(Activity activity, int requestCode, int[] grantResults, Runnable onPermissionChecked) {
        if (requestCode == STORAGE_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, execute the Runnable
                if (onPermissionChecked != null) {
                    onPermissionChecked.run();
                }
            } else {
                // Permission denied, handle accordingly
                // You may choose to show a message or perform other actions here
            }
        }
    }




    public static void downloadFileFromURL(Activity activity, String fileUrl) {
        new DownloadFileFromURL(activity).execute(fileUrl);
    }

    private static class DownloadFileFromURL extends AsyncTask<String, String, String> {
        private Activity mActivity;

        public DownloadFileFromURL(Activity activity) {
            this.mActivity = activity;
        }

        /**
         * Before starting background thread Show Progress Bar Dialog
         **/
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            showDialog(progress_bar_type);
        }

        /**
         * Downloading file in background thread
         **/
        @Override
        protected String doInBackground(String... f_url) {
            int count;
            try {
                URL url = new URL(f_url[0]);
                URLConnection conection = url.openConnection();
                conection.connect();

                // this will be useful so that you can show a typical 0-100%
                // progress bar
                int lengthOfFile = conection.getContentLength();

                // download the file
                InputStream input = new BufferedInputStream(url.openStream(),
                    8192);

                // Output stream
                OutputStream output = new FileOutputStream(Environment
                    .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                    + "/cmx.sh");

                byte data[] = new byte[1024];

                long total = 0;

                while ((count = input.read(data)) != -1) {
                    total += count;
                    // publishing the progress....
                    // After this onProgressUpdate will be called
                    publishProgress("" + (int) ((total * 100) / lengthOfFile));

                    // writing data to file
                    output.write(data, 0, count);
                }

                // flushing output
                output.flush();

                // closing streams
                output.close();
                input.close();
            } catch (Exception e) {
                Log.e("Error: ", e.getMessage());
            }

            return null;
        }

        /**
         * Updating progress bar
         **/
        protected void onProgressUpdate(String... progress) {
            // setting progress percentage
            pDialog.setProgress(Integer.parseInt(progress[0]));
        }

        /**
         * After completing background task Dismiss the progress dialog
         **/
        @Override
        protected void onPostExecute(String file_url) {
            // dismiss the dialog after the file was downloaded
            dismissDialog(progress_bar_type);

            // Notify TermuxActivity that file download is complete
            if (mActivity instanceof TermuxActivity) {
                ((TermuxActivity) mActivity).onFileDownloadComplete();
            }
        }

        private void showDialog(int id) {
            pDialog = new ProgressDialog(mActivity);
            pDialog.setMessage("Downloading CMX Package...");
            pDialog.setIndeterminate(false);
            pDialog.setMax(100);
            pDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        private void dismissDialog(int id) {
            if (pDialog != null && pDialog.isShowing()) {
                pDialog.dismiss();
            }
        }
    }
}
