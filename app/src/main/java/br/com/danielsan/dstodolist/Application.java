package br.com.danielsan.dstodolist;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatDelegate;

/**
 * Created by daniel on 25/03/16.
 */
public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FragmentManager.enableDebugLogging(BuildConfig.DEBUG);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO);
    }

}
