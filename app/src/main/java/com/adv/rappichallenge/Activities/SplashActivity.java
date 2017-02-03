package com.adv.rappichallenge.Activities;

import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Ruben Flores on 2/2/2017.
 */

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
