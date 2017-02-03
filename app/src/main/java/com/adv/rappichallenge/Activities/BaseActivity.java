package com.adv.rappichallenge.Activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.adv.rappichallenge.R;
import com.adv.rappichallenge.Reader.ReaderService;
import com.adv.rappichallenge.helpers.Const;
import com.adv.rappichallenge.helpers.ServiceGenerator;
import com.adv.rappichallenge.interfaces.IService;
import com.google.gson.Gson;

/**
 * Created by Ruben Flores on 2/1/2017.
 */

public class BaseActivity extends AppCompatActivity {
    public ProgressDialog progress;
    public Gson gson = new Gson();
    public IService client;
    public String token = "";
    public SharedPreferences prefs;
    public ReaderService reader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        prefs = this.getSharedPreferences(
                Const.PACKAGE_NAME, Context.MODE_PRIVATE);

        if(getResources().getBoolean(R.bool.isTablet)){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }else{
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }


        client = ServiceGenerator.createService(IService.class, this);

        progress = new ProgressDialog(this);
        progress.setTitle("");
        progress.setCancelable(false);
        progress.setMessage("Espere ...");

    }

    public void showToast(String text){
        Toast.makeText(this,""+text,Toast.LENGTH_SHORT).show();
    }
}
