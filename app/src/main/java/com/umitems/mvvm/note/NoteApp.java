package com.umitems.mvvm.note;

import android.app.Application;
import android.content.res.Resources;

import com.umitems.mvvm.note.di.components.AppComponent;
import com.umitems.mvvm.note.di.components.DaggerAppComponent;
import com.umitems.mvvm.note.di.modules.AppModule;

import io.realm.Realm;
import timber.log.Timber;

/**
 * Created by umitems on 9/27/16.
 */

public class NoteApp extends Application {

    private static NoteApp sInstance = null;

    private static AppComponent sAppComponent=null;

    @Override
    public void onCreate() {
        super.onCreate();

        sInstance = this;
        sAppComponent = DaggerAppComponent.builder()
            .appModule(new AppModule(this))
            .build();

        if(BuildConfig.DEBUG) { Timber.plant(new Timber.DebugTree()); }
    }

    public static NoteApp getInstance() { return sInstance; }

    public static AppComponent getAppComponent() { return sAppComponent; }

    public static Realm getRealm() { return sAppComponent.realm(); }

    public static Resources getRes() { return sInstance.getResources(); }


}
