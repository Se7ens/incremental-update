package com.douyu.im.bs;

import android.content.pm.ApplicationInfo;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private static String OLD_APK_PATH = "";
    private static String NEW_APK_PATH = "";
    private static String PATCH_PATH = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txt = (TextView) findViewById(R.id.txt);
        txt.setText("BsDiff newwwww APP");

        ApplicationInfo applicationInfo = getApplicationInfo();
        OLD_APK_PATH = applicationInfo.sourceDir;
        NEW_APK_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "new.apk";
        PATCH_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "apk.patch";

        File file = new File(PATCH_PATH);
        long ien = file.length();
        Toast.makeText(MainActivity.this, "" + ien, Toast.LENGTH_LONG).show();

        this.findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, OLD_APK_PATH + "\n" + NEW_APK_PATH + "\n" + PATCH_PATH, Toast.LENGTH_LONG).show();

                try {
                 int ret =  BsdiffJNI.applyPatchToOldApk(OLD_APK_PATH, NEW_APK_PATH, PATCH_PATH);
                  Toast.makeText(MainActivity.this, "" + ret, Toast.LENGTH_LONG).show();
                } catch (Throwable e) {
                    e.printStackTrace();
                }
            }
        });

    }

}
