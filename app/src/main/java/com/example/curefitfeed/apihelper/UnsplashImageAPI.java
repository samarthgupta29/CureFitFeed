package com.example.curefitfeed.apihelper;

import com.example.curefitfeed.model.CultVpImages;
import com.example.curefitfeed.model.CustomListItem;
import com.example.curefitfeed.model.EatVpImages;
import com.example.curefitfeed.model.FoodDetail;
import com.example.curefitfeed.model.MindVpImages;
import com.example.curefitfeed.model.UnsplashImagePOJO;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
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

    @GET("5d28209b2c000058003ed7da")
    Call<List<FoodDetail>> getFoodDetail();

}
