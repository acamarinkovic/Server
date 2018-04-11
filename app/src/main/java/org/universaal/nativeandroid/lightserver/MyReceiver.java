package org.universaal.nativeandroid.lightserver;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.MainThread;
import android.support.v4.app.NotificationCompat;
import android.text.style.TtsSpan;
import android.widget.Toast;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.universaal.nativeandroid.lightserver.organizer.UserEvent;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyReceiver extends BroadcastReceiver {
    public static int NOTIF_ID = 8225;

    @Override
    public void onReceive(Context context, Intent intent) {
        String sender = intent.getStringExtra("sender");
        String type = intent.getStringExtra("type");
        String extra = null;
        if (type != null) {
            switch (type) {
                case Constants.UPDATE:
                    String image = intent.getStringExtra("image");
                    String address = intent.getStringExtra("address");
                    if (image!=null &&address!=null)
                    {
                        extra = "Update: " + address;
                    }
                    break;
                case Constants.FALL_DETECTED:
                    float fall = intent.getFloatExtra("fall", -1);
                    if (fall != -1)
                    {
                        extra = "Fall detected";
                    }
                    break;
                case Constants.HEARTH_RATE:
                    int beats = intent.getIntExtra("beats", -1);
                    if (beats != -1) {
                        extra = "Beats: " + intent.getIntExtra("beats", -1);
                    }
                    break;
                case Constants.PRESSURE:
                    float sys = intent.getFloatExtra("sys", -1.0f);
                    float dias = intent.getFloatExtra("dias", -1.0f);
                    if (sys != -1.0f && dias != -1.0f) {
                        extra = "Pressure: " + String.valueOf(sys) + "/" + String.valueOf(dias);
                    }
                    break;
                case Constants.TEMPERATURE:
                    float temp = intent.getFloatExtra("temp", -1.0f);
                    if (temp != -1.0f) {
                        extra = "Temperature: " + String.valueOf(temp);
                    }
                    break;
                case Constants.MESSAGE:
                    String msg = intent.getStringExtra("message");
                    if (msg != null && !msg.isEmpty()) {
                        extra = "Message: " + msg;
                    }
                    break;
            }

            if (extra != null) {
                User user = AllUsers.getInstance().getUserByName(sender);
                if (user == null && type.equals(Constants.UPDATE)) {
                    user = new User(sender, intent.getStringExtra("image"),intent.getStringExtra("address"));
                    AllUsers.getInstance().addUser(user);
                }
                if(user!=null)
                {
                    user.addEvent(new UserEvent(extra, new SimpleDateFormat("d.M.yyyy HH:mm").format(Calendar.getInstance().getTime())));
                    EventBus.getDefault().post(new Event(user));
                }
            }
        }


    }
}
