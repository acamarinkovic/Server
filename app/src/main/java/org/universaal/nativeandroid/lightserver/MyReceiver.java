package org.universaal.nativeandroid.lightserver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String json = intent.getExtras().getString("lamp");
        Gson gson = new Gson();
        User user = gson.fromJson(json, User.class);
        if (user.getType().equals(Constants.FIRST_NAME)) {
            AllUsers.getInstance().setUsers(user);
        }else {
            EventBus.getDefault().post(new Event(user));
        }
    }
}
