package com.hula.healthcare;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.hula.healthcare.R;

public class MainActivity extends SuperActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().requestFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.activity_main);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,
                R.layout.title_main);
    }

}
