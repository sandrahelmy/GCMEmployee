package com.example.sandra.gcmemployee;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;


public class MainActivity extends AppCompatActivity {
    public static Boolean iAccepted = false;
    static String requestURL = "https://fcm.googleapis.com/fcm/send";
    static String key = "AIzaSyB_EZJ0nUfa0bDpkVI722OeQVRx0_uV7Jo";
    static String toToken = "ccJPptZVAnM:APA91bHQx1phUevu-8bqCBI8nt1FM-YAFVWyJ46sD1AQ8jnUIwCdUrfS3p_2Bafsla8RmvjvGhqiXVr2DNgyXYPNE1lQYAkNsrpg0Fmyk1GVa3aOyxKN9d4BYtLJRaQ_olNSMYYeWbin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent intent = new Intent(this, RegistrationIntentService.class);
        startService(intent);

    }

    public static void sendNotification(String notificationTitle, String notificationBody){
        HttpsURLConnection connection = null;
        try {
            URL url = new URL(requestURL);
            connection = (HttpsURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization", "key="
                    +  key);

            JSONObject root = new JSONObject();
            JSONObject notification = new JSONObject();
            notification.put("title", notificationTitle);
            notification.put("body", notificationBody);
//            notification.put("click_action", "OPEN_TASK_REQUIRED");

            root.put("notification", notification);
//            root.put("to" , toToken);
            if(notificationTitle.equals("Task Taken")){
                root.put("to", "/topics/global");
            } else {
                root.put("to", "/topics/manager");
                notification.put("click_action", "OPEN_TASK_TAKEN");
            }


            byte[] outputBytes = root.toString().getBytes("UTF-8");
            OutputStream os = connection.getOutputStream();
            os.write(outputBytes);
            os.flush();
            os.close();
            connection.getInputStream();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

//    /***Async class***/
//    //params, progress, result
//    public class MyAsync extends AsyncTask<String, Void, Void> {
//
//        @Override
//        protected Void doInBackground(String... strings) {
//            sendNotification(strings[0], strings[1]);
//            return null;
//        }
//
//    }
}
