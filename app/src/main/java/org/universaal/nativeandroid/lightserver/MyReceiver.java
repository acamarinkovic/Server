package org.universaal.nativeandroid.lightserver;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.MainThread;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

public class MyReceiver extends BroadcastReceiver {
    public static int NOTIF_ID = 8225;

    @Override
    public void onReceive(Context context, Intent intent) {
        String json = intent.getExtras().getString("lamp");
        Gson gson = new Gson();
        User user = gson.fromJson(json, User.class);
        if (user.getType().equals(Constants.FIRST_NAME)) {
            AllUsers.getInstance().setUsers(user);

            Intent notificationIntent = new Intent(context,
                    MainActivity.class);
            PendingIntent contentIntent = PendingIntent.getActivity(context, 0,
                    notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            NotificationCompat.Builder builder = new NotificationCompat.Builder(
                    context)
                    .setContentTitle(user.getName())
                    .setContentText("User update").setContentIntent(contentIntent)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);
            Notification notif = builder.build();
            // Show the notification
            NotificationManager manager = (NotificationManager) context
                    .getSystemService(Context.NOTIFICATION_SERVICE);
            manager.notify(NOTIF_ID, notif);
        } else {
            EventBus.getDefault().post(new Event(user));
            AllUsers.getInstance().addEvent(user);
            User byEvent = AllUsers.getInstance().getUserrByEvent(user);
            Intent notificationIntent = new Intent(context,
                    MainActivity.class);
            PendingIntent contentIntent = PendingIntent.getActivity(context, 0,
                    notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            NotificationCompat.Builder builder = new NotificationCompat.Builder(
                    context)
                    .setContentTitle(byEvent.getName())
                    .setContentText("new incident" + user.getType()).setContentIntent(contentIntent)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);
            Notification notif = builder.build();
            // Show the notification
            NotificationManager manager = (NotificationManager) context
                    .getSystemService(Context.NOTIFICATION_SERVICE);
            manager.notify(NOTIF_ID, notif);
        }


    }
}
