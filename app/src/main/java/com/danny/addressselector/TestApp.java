package com.danny.addressselector;

import android.app.Application;

import com.danny.addressselector.view.CityPickerView;

/**
 * Created by steve on 3/17/18.
 */

public class TestApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        CityPickerView.getInstance().init(this);
    }
}
