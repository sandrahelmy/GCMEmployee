package com.example.sandra.gcmemployee;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.gcm.GcmListenerService;


public class MyService extends GcmListenerService {
    @Override
    public void onMessageReceived(String from, Bundle bundle) {
        super.onMessageReceived(from, bundle);
        Intent i = new Intent(this, TaskRequiredActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        String notificationTitle = (String) bundle.get("title");

        if(MainActivity.iAccepted == false && notificationTitle.equals("Task Required")){
            String notificationBody = (String) bundle.get("body");
            i.putExtra("notificationBody", notificationBody);
            i.putExtra("title", notificationTitle);
            startActivity(i);
        }
    }
}
