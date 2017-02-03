package com.adv.rappichallenge.repositories;

import android.content.Context;

import com.adv.rappichallenge.helpers.ServiceGenerator;
import com.adv.rappichallenge.interfaces.IDataRepository;
import com.adv.rappichallenge.interfaces.IService;
import com.adv.rappichallenge.interfaces.OnSelect_Listener;
import com.adv.rappichallenge.models.Root;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Ruben Flores on 7/5/2016.
 */
public class WS implements IDataRepository {
    private IService client;
    private static WS _instance;

    public WS(Context context) {
        this.client = ServiceGenerator.createService(IService.class, context);
    }

    public synchronized static WS getInstance(Context context)
    {
        if (_instance == null)
        {
            _instance = new WS(context);
        }

        return _instance;
    }


    @Override
    public void getFeeds(final OnSelect_Listener listener) {
        Call<Root> call = client.getFeed();
        call.enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                listener.onComplete(response.body());
            }

            @Override
            public void onFailure(Call<Root> call, Throwable t) {
                listener.onError();
            }
        });
    }
}
