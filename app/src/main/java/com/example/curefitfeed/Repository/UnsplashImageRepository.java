package com.example.curefitfeed.Repository;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.MutableLiveData;

import com.example.curefitfeed.APIHelper.UnsplashImageAPI;
import com.example.curefitfeed.Model.CultMonthlySubscriptionItem;
import com.example.curefitfeed.Model.CultSelectMembershipItem;
import com.example.curefitfeed.Model.CultUnlimitedMembershipItem;
import com.example.curefitfeed.Model.CultFeed;
import com.example.curefitfeed.Model.CultFeedPOJO;
import com.example.curefitfeed.Model.CultVpImages;
import com.example.curefitfeed.Model.CultWorkoutItem;
import com.example.curefitfeed.Model.CustomListItem;
import com.example.curefitfeed.Model.EatFeed;
import com.example.curefitfeed.Model.EatFeedPOJO;
import com.example.curefitfeed.Model.EatVpImages;
import com.example.curefitfeed.Model.FoodItem;
import com.example.curefitfeed.Model.HeaderItem;
import com.example.curefitfeed.Model.MindFeed;
import com.example.curefitfeed.Model.MindFeedPOJO;
import com.example.curefitfeed.Model.MindMonthlySubscriptionItem;
import com.example.curefitfeed.Model.MindUnlimitedMembershipItem;
import com.example.curefitfeed.Model.MindVpImages;
import com.example.curefitfeed.Model.MindWorkoutItem;
import com.example.curefitfeed.Model.TrainerItem;
import com.example.curefitfeed.Model.WhyCultFitItem;
import com.example.curefitfeed.Model.WhyMindFitItem;
import com.example.curefitfeed.RetrofitClient.ImagesRetrofitClient;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UnsplashImageRepository {

    private static UnsplashImageRepository unsplashImageRepository;
    private UnsplashImageAPI unsplashImageAPI;
    private static InputStreamHelper helper;

    public static UnsplashImageRepository getInstance(InputStreamHelper mHelper) {
        helper = mHelper;
        if (unsplashImageRepository == null) {
            unsplashImageRepository = new UnsplashImageRepository();
        }
        return unsplashImageRepository;
    }

    public UnsplashImageRepository() {
        unsplashImageAPI = ImagesRetrofitClient.getClient().create(UnsplashImageAPI.class);
    }

    /*public MutableLiveData<List<UnsplashImagePOJO>> getImages() {
        MutableLiveData<List<UnsplashImagePOJO>> listMutableLiveData = new MutableLiveData<>();
        unsplashImageAPI.getImages(30, "5fd3a755d249d4c1c820303c1d420f6ebc37d646fb5bcb8040c5b257865f3776")
                .enqueue(new Callback<List<UnsplashImagePOJO>>() {
                    @Override
                    public void onResponse(Call<List<UnsplashImagePOJO>> call, Response<List<UnsplashImagePOJO>> response) {
                        if (response.body() != null) {
                            for (int i = 0; i < response.body().size(); i++) {
                                System.out.println(response.body().get(i).getUrls().getFull());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<List<UnsplashImagePOJO>> call, Throwable t) {

                    }
                });

        return listMutableLiveData;
    }*/

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public ArrayList<CustomListItem> getEatFeed() {

        ArrayList<CustomListItem> mList = new ArrayList<>(10);
        List<EatFeed> eatFeed = new ArrayList<>();
        EatFeedPOJO eatFeedPOJO = getEatFeedPOJO();
        eatFeed = eatFeedPOJO.getEatFeed();
        for (EatFeed feedItem : eatFeed) {
            if (feedItem.getType().equalsIgnoreCase("foodItem")) {
                mList.add(new FoodItem(feedItem.getFood()));
            } else if (feedItem.getType().equalsIgnoreCase("header")) {
                mList.add(new HeaderItem(feedItem.getNavItem()));
            }
        }
        return mList;
    }

    private EatFeedPOJO getEatFeedPOJO() {
        return new Gson().fromJson(inputStreamtoString(helper.getInputStream("eat_feed.json")), EatFeedPOJO.class);
    }


    public ArrayList<CustomListItem> getMindFeed() {
        ArrayList<CustomListItem> mList = new ArrayList<>(10);
        List<MindFeed> mindFeed = new ArrayList<>();
        MindFeedPOJO mindFeedPOJO = new Gson().fromJson(inputStreamtoString(helper.getInputStream("mind_feed.json")), MindFeedPOJO.class);
        mindFeed = mindFeedPOJO.getMindFeed();
        for (MindFeed feedItem : mindFeed) {
            if (feedItem.getType().equalsIgnoreCase("whymindfit_header")) {
                mList.add(new WhyMindFitItem(feedItem.getHeaderInfo1(), feedItem.getWhymindfitDetails()));
            } else if (feedItem.getType().equalsIgnoreCase("mindunlimitedmembership_header")) {
                mList.add(new MindUnlimitedMembershipItem(feedItem.getHeaderInfo1(), feedItem.getHeaderInfo2(),
                        feedItem.getUnlimitedmembershipDetails()));
            } else if (feedItem.getType().equalsIgnoreCase("mindmonthlysubscription_header")) {
                mList.add(new MindMonthlySubscriptionItem(feedItem.getImageUrl(), feedItem.getInfo(),
                        feedItem.getFirstMonth(), feedItem.getSecondMonthOnwards()));
            } else if (feedItem.getType().equalsIgnoreCase("mindworkout_header")) {
                mList.add(new MindWorkoutItem(feedItem.getHeaderInfo1(), feedItem.getWorkoutDetails()));
            }
        }
        return mList;
    }

    public ArrayList<CustomListItem> getCultFeed() {
        ArrayList<CustomListItem> mList = new ArrayList<>(10);
        List<CultFeed> cultFeed = new ArrayList<>();
        CultFeedPOJO cultFeedPOJO = new Gson().fromJson(inputStreamtoString(helper.getInputStream("cult_feed.json")), CultFeedPOJO.class);
        cultFeed = cultFeedPOJO.getCultFeed();
        for (CultFeed feedItem : cultFeed) {
            if (feedItem.getType().equalsIgnoreCase("cultunlimitedmembership_header")) {
                mList.add(new CultUnlimitedMembershipItem(feedItem.getHeaderInfo1(), feedItem.getHeaderInfo2(),
                        feedItem.getHeaderInfo3(), feedItem.getCultunlimitedmembershipDetails()));

            } else if (feedItem.getType().equalsIgnoreCase("cultmonthlysubscription_header")) {
                mList.add(new CultMonthlySubscriptionItem(feedItem.getImageUrl(), feedItem.getInfo(),
                        feedItem.getFirstMonth(), feedItem.getSecondMonthOnwards()));

            } else if (feedItem.getType().equalsIgnoreCase("cultselectmembership_header")) {
                mList.add(new CultSelectMembershipItem(feedItem.getHeaderInfo1(), feedItem.getHeaderInfo2(), feedItem.getHeaderInfo3(),
                        feedItem.getHeaderInfo4(), feedItem.getCultselectmembershipDetails()));

            } else if (feedItem.getType().equalsIgnoreCase("whycultfit_header")) {
                mList.add(new WhyCultFitItem(feedItem.getHeaderInfo1(), feedItem.getWhycultfitDetails()));

            } else if (feedItem.getType().equalsIgnoreCase("cultworkout_header")) {
                mList.add(new CultWorkoutItem(feedItem.getHeaderInfo1(), feedItem.getCultworkoutDetails()));

            } else if (feedItem.getType().equalsIgnoreCase("trainer_header")) {
                mList.add(new TrainerItem(feedItem.getHeaderInfo1(), feedItem.getTrainerDetails()));
            }
        }
        return mList;
    }

    public MutableLiveData<EatVpImages> getEatVpImages(){
        MutableLiveData<EatVpImages> eatVpImagesMutableLiveData = new MutableLiveData<>();
        unsplashImageAPI.getEatVpImages().enqueue(new Callback<EatVpImages>() {
            @Override
            public void onResponse(Call<EatVpImages> call, Response<EatVpImages> response) {
                if(response.body() != null){
                    Log.d("Dataa",response.body().getEatVpImages().toString());
                    eatVpImagesMutableLiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<EatVpImages> call, Throwable t) {
                t.printStackTrace();
            }
        });
        return eatVpImagesMutableLiveData;
    }

    public MutableLiveData<MindVpImages> getMindVpImages(){
        MutableLiveData<MindVpImages> mindVpImagesMutableLiveData = new MutableLiveData<>();
        unsplashImageAPI.getMindVpImages().enqueue(new Callback<MindVpImages>() {
            @Override
            public void onResponse(Call<MindVpImages> call, Response<MindVpImages> response) {
                if(response.body() != null){
                    mindVpImagesMutableLiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<MindVpImages> call, Throwable t) {
                t.printStackTrace();
            }
        });

        return mindVpImagesMutableLiveData;
    }

    public MutableLiveData<CultVpImages> getCultVpImages(){
        MutableLiveData<CultVpImages> cultVpImagesMutableLiveData = new MutableLiveData<>();
        unsplashImageAPI.getCultVpImages().enqueue(new Callback<CultVpImages>() {
            @Override
            public void onResponse(Call<CultVpImages> call, Response<CultVpImages> response) {
                if(response.body() != null){
                    cultVpImagesMutableLiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<CultVpImages> call, Throwable t) {
                    t.printStackTrace();
            }
        });

        return cultVpImagesMutableLiveData;
    }


    public String inputStreamtoString(InputStream inputStream) {
        try {
            if (inputStream != null) {
                byte[] bytes = new byte[inputStream.available()];
                inputStream.read(bytes);
                inputStream.close();
                return new String(bytes, StandardCharsets.UTF_8);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
