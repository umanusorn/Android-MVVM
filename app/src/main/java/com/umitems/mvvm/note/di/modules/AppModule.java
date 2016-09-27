package com.umitems.mvvm.note.di.modules;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import com.umitems.mvvm.note.BuildConfig;
import com.umitems.mvvm.note.di.qualifier.AppContext;
import com.umitems.mvvm.note.di.scope.PerApplication;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by umitems on 9/27/16.
 */

@Module
public class AppModule {

    private final Application mApp;

    public AppModule(Application app){mApp=app;}

    @Provides
    @PerApplication
    @AppContext
    Context provideAppContext(){
        return mApp;
    }

    @Provides
    @PerApplication
    Resources provideResources(){
        return mApp.getResources();
    }

    @Provides
    @PerApplication
    static RealmConfiguration provideRealmConfiguration(@AppContext Context context){
        RealmConfiguration.Builder builder = new RealmConfiguration.Builder(context);
        if(BuildConfig.DEBUG){ builder = builder.deleteRealmIfMigrationNeeded(); }
        return builder.build();
    }

    @Provides
    static Realm provideRealm(RealmConfiguration realmConfiguration){
        return Realm.getInstance(realmConfiguration);
    }
}
