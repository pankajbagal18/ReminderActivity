package com.example.panks.reminderactivity;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;

public class NotificationHelper extends ContextWrapper{
    private static final String channel_id = "com.example.panks.reminderactivity.Reminder";
    private static final String channel_name = "com.example.panks.reminderactivity.Reminder";
    private NotificationManager manager;
    public NotificationHelper(Context base) {
        super(base);
        createChannel();
    }
    private void createChannel(){
        NotificationChannel notificationChannel = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationChannel = new NotificationChannel(channel_id,channel_name, NotificationManager.IMPORTANCE_DEFAULT);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationChannel.enableLights(true);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationChannel.enableVibration(true);
        }
    }
}
