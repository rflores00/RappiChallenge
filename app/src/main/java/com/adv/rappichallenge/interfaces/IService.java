package com.adv.rappichallenge.interfaces;

import com.adv.rappichallenge.models.Root;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Ruben Flores on 2/1/2017.
 */

public interface IService {

    @GET("topfreeapplications/limit=20/json")
    Call<Root> getFeed();

}
