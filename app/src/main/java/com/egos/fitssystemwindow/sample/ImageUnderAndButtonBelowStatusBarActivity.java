package com.egos.fitssystemwindow.sample;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Egos on 2016/12/12.
 */
public class ImageUnderAndButtonBelowStatusBarActivity extends AppCompatActivity {


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_under_and_button_below_status_bar);
    }
}
