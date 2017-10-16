package org.universaal.nativeandroid.lightserver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(Application.getInstance(), intent.getExtras().getString("lamp"),Toast.LENGTH_LONG).show();


    }
}
