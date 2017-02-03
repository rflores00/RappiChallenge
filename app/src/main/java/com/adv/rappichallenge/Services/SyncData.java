package com.adv.rappichallenge.Services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.IBinder;
import android.util.Log;

import com.adv.rappichallenge.Reader.ReaderService;
import com.adv.rappichallenge.repositories.SQL;
import com.adv.rappichallenge.repositories.WS;

import static com.adv.rappichallenge.helpers.Const.LOCAL_CONNETION;
import static com.adv.rappichallenge.helpers.Const.SERVICE_CONNETION;
import static com.adv.rappichallenge.helpers.Const.TAG;

/**
 * Created by Ruben Flores on 2/1/2017.
 */

public class SyncData extends Service {

    public SyncData() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Log.d(TAG, "Service Created...");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "Service Started...");

        Intent i = new Intent("event");
        if(isNetworkAvailable()){
            ReaderService.getSingleton().set_iDataRepository(WS.getInstance(this));
            i.putExtra("connetion_type", SERVICE_CONNETION);
        }else{
            ReaderService.getSingleton().set_iDataRepository(SQL.getInstance(this));
            i.putExtra("connetion_type", LOCAL_CONNETION);
        }

        sendBroadcast(i);

        return START_NOT_STICKY;
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        return activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "Service Destroy...");
    }
}
