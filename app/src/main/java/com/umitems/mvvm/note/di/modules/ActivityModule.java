package com.umitems.mvvm.note.di.modules;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.umitems.mvvm.note.di.qualifier.ActivityContext;
import com.umitems.mvvm.note.di.scope.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by umitems on 9/27/16.
 */

@Module
public class ActivityModule {

    private  final AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity){
        mActivity = activity;
    }

    @Provides
    @PerActivity
    @ActivityContext
    Context provideActivityContext() {return mActivity;}

    @Provides
    @PerActivity
    FragmentManager provideFragmentManager() { return mActivity.getSupportFragmentManager(); }

   /* @Provides
    @PerActivity
    Navigator provideNavigator() { return new ActivityNavigator(mActivity); }*/

}
