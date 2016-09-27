package com.umitems.mvvm.note.di.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by umitems on 9/27/16.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity{}
