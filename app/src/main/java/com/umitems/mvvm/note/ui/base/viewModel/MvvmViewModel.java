package com.umitems.mvvm.note.ui.base.viewModel;

import android.databinding.Observable;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.umitems.mvvm.note.ui.base.view.MvvmView;

/**
 * Created by umitems on 9/27/16.
 */

public interface MvvmViewModel<V extends MvvmView> extends Observable {
    void attachView(V view, Bundle saveInstanceState);
    void detachView();

    void saveInstanceState(@NonNull Bundle outState);
    void restoreInstanceState(@NonNull Bundle savedInstanceState);
}
