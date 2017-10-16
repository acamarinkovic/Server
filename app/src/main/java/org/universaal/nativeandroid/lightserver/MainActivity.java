package org.universaal.nativeandroid.lightserver;

import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.universaal.nativeandroid.lightserver.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);

    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    @Subscribe
    public void onEvent(Event event){
        User user=event.getUser();
        switch (user.getType())
        {
            case Constants.FALL_DETECTED:{

            }break;
            case Constants.MESSAGE:{

            }break;
            case Constants.FIRST_NAME:{

            }break;
            case Constants.PRESSURE:{

            }break;
            case Constants.TEMPERATURE:{

            }break;
        }

    }


    @Override
    protected void onPause() {
        super.onPause();
    }
}
