package org.universaal.nativeandroid.lightserver;

import android.content.ContextWrapper;

import com.pixplicity.easyprefs.library.Prefs;

/**
 * Created by aleks on 14.10.2017..
 */

public class Application extends android.app.Application {

    private static Application m_instance;

    @Override
    public void onCreate() {
        super.onCreate();
        m_instance=this;


        new Prefs.Builder()
                .setContext(this)
                .setMode(ContextWrapper.MODE_PRIVATE)
                .setPrefsName(getPackageName())
                .setUseDefaultSharedPreference(true)
                .build();
    }


    public static Application getInstance()
    {
        return m_instance;
    }
}