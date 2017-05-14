package com.example.sandra.gcmemployee;

import android.os.AsyncTask;

/**
 * Created by Sandra on 5/13/2017.
 */

public class MyAsync extends AsyncTask<String, Void, Void> {
    @Override
    protected Void doInBackground(String... strings) {
        MainActivity.sendNotification(strings[0], strings[1]);
        return null;
    }
}
