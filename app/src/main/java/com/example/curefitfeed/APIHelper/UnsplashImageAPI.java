package com.example.curefitfeed.APIHelper;

import com.example.curefitfeed.Model.CultVpImages;
import com.example.curefitfeed.Model.EatVpImages;
import com.example.curefitfeed.Model.MindVpImages;
import com.example.curefitfeed.Model.UnsplashImagePOJO;
import com.example.curefitfeed.Model.UnsplashImageResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UnsplashImageAPI {

    @GET("/photos/random")
    Call<List<UnsplashImagePOJO>> getImages(@Query("count") int count, @Query("client_id") String client_id);

    @GET("5d25e4662f0000175bc10bb5")
    Call<EatVpImages> getEatVpImages();

    @GET("5d25ea482f0000df95c10c07")
    Call<MindVpImages> getMindVpImages();

    @GET("5d25ea852f0000a157c10c09")
    Call<CultVpImages> getCultVpImages();

}
