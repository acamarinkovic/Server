package org.universaal.nativeandroid.lightserver;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.google.gson.Gson;
import com.pixplicity.easyprefs.library.Prefs;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rec)
    RecyclerView rec;
    @BindView(R.id.fragment_holder)
    RecyclerView fragmentHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        rec.setLayoutManager( new LinearLayoutManager(this));
        fragmentHolder.setLayoutManager( new LinearLayoutManager(this));
        rec.setAdapter(new CountryListAdapter(this,AllUsers.getInstance().getUsers()));
    }

    @Override
    protected void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
        Gson gson = new Gson();
        AllUsers user = gson.fromJson(Prefs.getString(Constants.USER,""), AllUsers.class);
        AllUsers.getInstance(user);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
        Gson gson = new Gson();
        String user = gson.toJson(AllUsers.getInstance(), AllUsers.class);
        Prefs.putString(Constants.USER,user);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Subscribe
    public void onEvent(Event event) {
        User user = event.getUser();
        switch (user.getType()) {
            case Constants.FALL_DETECTED: {

            }
            break;
            case Constants.MESSAGE: {

            }
            break;
            case Constants.FIRST_NAME: {

            }
            break;
            case Constants.PRESSURE: {

            }
            break;
            case Constants.TEMPERATURE: {

            }
            break;
        }

    }


    @Subscribe
    public void onEventClick(EventClick event) {
        fragmentHolder.setVisibility(View.VISIBLE);
        fragmentHolder.setAdapter(new UserHistoryListAdapter(this,AllUsers.getInstance().getEvents(event.getUser().getUserId())));
    }

    @Override
    public void onBackPressed() {
        if( fragmentHolder.getVisibility()==View.VISIBLE)
        {
            fragmentHolder.setVisibility(View.GONE);
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
