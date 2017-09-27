package com.pdfdownload.view.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.pdfdownload.R;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.transform.Result;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.READ_PHONE_STATE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

/**
 * Created by avikaljain on 27/9/17.
 */

public class DownloadFileActivity extends AppCompatActivity {

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.buttonPlay)
    public void playFile() {
        File file = new File("/sdcard/Cdn/cdntest.mp3");
        if (file.exists()) {
            playAudio();
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (checkWritePermission()) {
                    loadDataFromServer();
                } else {
                    ActivityCompat.requestPermissions(this, new String[]{WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE}, 201);
                }
            } else {
                loadDataFromServer();
            }
        }
    }

    private void playAudio() {
        MediaPlayer mp = new MediaPlayer();
        try {
            mp.setDataSource("/mnt/sdcard/Cdn/cdntest.mp3");
            mp.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }

        mp.start();
    }

    @OnClick(R.id.buttonDownload)
    public void downloadFile() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkWritePermission()) {
                loadDataFromServer();
            } else {
                ActivityCompat.requestPermissions(this, new String[]{WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE}, 201);
            }
        } else {
            loadDataFromServer();
        }
    }

    private void dirMake(String dir) {
        File f = new File(dir);
        if (dir.length() >= 0 && !f.isDirectory()) {
            f.mkdirs();
        }
    }

    private void loadDataFromServer() {
        dirMake("/sdcard/Cdn");
        File file = new File("/sdcard/Cdn/cdntest.mp3");
        if (file.exists()) {
            Toast.makeText(this, "File Already", Toast.LENGTH_SHORT).show();
        } else {
            new DownloadFile().execute();
        }

    }

    private boolean checkWritePermission() {
        int result = ContextCompat.checkSelfPermission(this, WRITE_EXTERNAL_STORAGE);
        int result1 = ContextCompat.checkSelfPermission(this, READ_EXTERNAL_STORAGE);
        return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED;
    }

    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 201:
                if (grantResults.length > 0) {
                    boolean phoneStateAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    if (phoneStateAccepted) {
                        loadDataFromServer();
                    } else {
                        Toast.makeText(DownloadFileActivity.this, "Permission Denied", Toast.LENGTH_LONG).show();
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            if (shouldShowRequestPermissionRationale(READ_PHONE_STATE)) {
                                showMessageOKCancel("You need to allow access the permissions",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                                    requestPermissions(new String[]{READ_PHONE_STATE},
                                                            200);
                                                }
                                            }
                                        });
                                return;
                            }
                        }
                    }
                }
                break;

        }

    }

    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(DownloadFileActivity.this)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }

    private class DownloadFile extends AsyncTask<String, Integer, String> {


        @Override
        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... urlParams) {
            int count;
            try {
                URL url = new URL("http://139.59.19.112:8080/mantra/mantra1.mp3");
                URLConnection conexion = url.openConnection();
                conexion.connect();
                // this will be useful so that you can show a tipical 0-100% progress bar
                int lenghtOfFile = conexion.getContentLength();

                // downlod the file
                InputStream input = new BufferedInputStream(url.openStream());
                OutputStream output = new FileOutputStream("/sdcard/Cdn/cdntest.mp3");

                byte data[] = new byte[1024];

                long total = 0;

                while ((count = input.read(data)) != -1) {
                    total += count;
                    // publishing the progress....
                    publishProgress((int) (total * 100 / lenghtOfFile));
                    output.write(data, 0, count);
                }

                output.flush();
                output.close();
                input.close();
            } catch (Exception e) {
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {

            progressBar.setVisibility(View.GONE);
            playAudio();

        }
    }
}
