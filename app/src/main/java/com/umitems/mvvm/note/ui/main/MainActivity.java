package com.umitems.mvvm.note.ui.main;

import android.os.Bundle;

import com.umitems.mvvm.note.R;
import com.umitems.mvvm.note.databinding.ActivityMainBinding;
import com.umitems.mvvm.note.ui.base.BaseActivity;
import com.umitems.mvvm.note.ui.base.view.MvvmView;
import com.umitems.mvvm.note.ui.base.viewModel.NoOpViewModel;

public class MainActivity extends BaseActivity <ActivityMainBinding, NoOpViewModel> implements MvvmView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityComponent().inject(this);
        setAndBindContentView(R.layout.activity_main, savedInstanceState);
        //setContentView(R.layout.activity_main);
    }
}
