package com.umitems.mvvm.note.di.components;

import android.content.Context;
import android.content.res.Resources;

import com.umitems.mvvm.note.di.modules.AppModule;
import com.umitems.mvvm.note.di.qualifier.AppContext;
import com.umitems.mvvm.note.di.scope.PerApplication;

import dagger.Component;
import io.realm.Realm;

/**
 * Created by umitems on 9/27/16.
 */
@PerApplication
@Component(modules = {AppModule.class})
public interface AppComponent {
    @AppContext
    Context context();
    Resources resources();

    Realm realm();
}
