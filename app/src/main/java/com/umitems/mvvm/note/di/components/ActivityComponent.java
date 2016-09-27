package com.umitems.mvvm.note.di.components;

import com.umitems.mvvm.note.ui.main.MainActivity;
import com.umitems.mvvm.note.di.modules.ActivityModule;
import com.umitems.mvvm.note.di.scope.PerActivity;

import dagger.Component;

/**
 * Created by umitems on 9/27/16.
 */
@PerActivity
@Component(dependencies = AppComponent.class, modules = {ActivityModule.class})
public interface ActivityComponent {

    void inject(MainActivity activity);
}
