package com.umitems.mvvm.note.ui.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.umitems.mvvm.note.NoteApp;
import com.umitems.mvvm.note.di.components.ActivityComponent;
import com.umitems.mvvm.note.di.components.DaggerActivityComponent;
import com.umitems.mvvm.note.di.modules.ActivityModule;
import com.umitems.mvvm.note.ui.base.view.MvvmView;
import com.umitems.mvvm.note.ui.base.viewModel.MvvmViewModel;

import javax.inject.Inject;

import io.realm.Realm;

/**
 * Created by umitems on 9/27/16.
 */

public abstract class BaseActivity <B extends ViewDataBinding, V extends MvvmViewModel> extends AppCompatActivity {

    protected B binding;
    @Inject protected V viewModel;


    @Inject
    Realm realm;

    private ActivityComponent mActivityComponent;

    protected final void setAndBindContentView(@LayoutRes int layoutResId, @Nullable Bundle savedInstanceState){
        if(viewModel == null){throw  new IllegalStateException("viewModel must not be null and should be injected via activityComponent().inject(this)");}
        binding = DataBindingUtil.setContentView(this,layoutResId);
        //binding.setVariable(BR.vm,viewModel);

        viewModel.attachView((MvvmView)this,savedInstanceState);
    }


    protected final ActivityComponent activityComponent(){
        if(mActivityComponent==null){
            mActivityComponent = DaggerActivityComponent.builder()
                .appComponent(NoteApp.getAppComponent())
                .activityModule(new ActivityModule(this))
                .build();
        }
        return mActivityComponent;
    }


    @Override
    @CallSuper
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if(viewModel != null) { viewModel.saveInstanceState(outState); }
    }

    @Override
    @CallSuper
    protected void onDestroy() {
        super.onDestroy();
        if(viewModel != null) { viewModel.detachView(); }
        if(realm != null) { realm.close(); }
        binding = null;
        viewModel = null;
        mActivityComponent = null;
        realm = null;

    }

}
