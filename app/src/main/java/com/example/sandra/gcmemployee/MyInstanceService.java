package com.example.sandra.gcmemployee;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.google.android.gms.iid.InstanceIDListenerService;

public class MyInstanceService extends InstanceIDListenerService {
    public MyInstanceService() {
    }

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        // Fetch updated Instance ID token and notify our app's server of any changes (if applicable).
        Intent intent = new Intent(this, RegistrationIntentService.class);
        startService(intent);

    }
}
