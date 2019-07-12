package com.example.curefitfeed.repository;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.MutableLiveData;

import com.example.curefitfeed.apihelper.UnsplashImageAPI;
import com.example.curefitfeed.model.CultFeed;
import com.example.curefitfeed.model.CultFeedPOJO;
import com.example.curefitfeed.model.CultMonthlySubscriptionItem;
import com.example.curefitfeed.model.CultSelectMembershipItem;
import com.example.curefitfeed.model.CultUnlimitedMembershipItem;
import com.example.curefitfeed.model.CultVpImages;
import com.example.curefitfeed.model.CultWorkoutItem;
import com.example.curefitfeed.model.CustomListItem;
import com.example.curefitfeed.model.EatFeed;
import com.example.curefitfeed.model.EatFeedPOJO;
import com.example.curefitfeed.model.EatVpImages;
import com.example.curefitfeed.model.FoodDetail;
import com.example.curefitfeed.model.FoodItem;
import com.example.curefitfeed.model.HeaderItem;
import com.example.curefitfeed.model.MindFeed;
import com.example.curefitfeed.model.MindFeedPOJO;
import com.example.curefitfeed.model.MindMonthlySubscriptionItem;
import com.example.curefitfeed.model.MindUnlimitedMembershipItem;
import com.example.curefitfeed.model.MindVpImages;
import com.example.curefitfeed.model.MindWorkoutItem;
import com.example.curefitfeed.model.TrainerItem;
import com.example.curefitfeed.model.WhyCultFitItem;
import com.example.curefitfeed.model.WhyMindFitItem;
import com.example.curefitfeed.retrofitclient.ImagesRetrofitClient;
import com.google.gson.Gson;

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
        return new Gson().fromJson(helper.getInputStream("eat_feed.json"), EatFeedPOJO.class);
    }

    public ArrayList<CustomListItem> getMindFeed() {
        ArrayList<CustomListItem> mList = new ArrayList<>(10);
        List<MindFeed> mindFeed = new ArrayList<>();
        MindFeedPOJO mindFeedPOJO = new Gson().fromJson(helper.getInputStream("mind_feed.json"), MindFeedPOJO.class);
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
        CultFeedPOJO cultFeedPOJO = new Gson().fromJson(helper.getInputStream("cult_feed.json"), CultFeedPOJO.class);
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

    public MutableLiveData<EatVpImages> getEatVpImages() {
        MutableLiveData<EatVpImages> eatVpImagesMutableLiveData = new MutableLiveData<>();
        unsplashImageAPI.getEatVpImages().enqueue(new Callback<EatVpImages>() {
            @Override
            public void onResponse(Call<EatVpImages> call, Response<EatVpImages> response) {
                if (response.body() != null) {
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

    public MutableLiveData<MindVpImages> getMindVpImages() {
        MutableLiveData<MindVpImages> mindVpImagesMutableLiveData = new MutableLiveData<>();
        unsplashImageAPI.getMindVpImages().enqueue(new Callback<MindVpImages>() {
            @Override
            public void onResponse(Call<MindVpImages> call, Response<MindVpImages> response) {
                if (response.body() != null) {
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

    public MutableLiveData<CultVpImages> getCultVpImages() {
        MutableLiveData<CultVpImages> cultVpImagesMutableLiveData = new MutableLiveData<>();
        unsplashImageAPI.getCultVpImages().enqueue(new Callback<CultVpImages>() {
            @Override
            public void onResponse(Call<CultVpImages> call, Response<CultVpImages> response) {
                if (response.body() != null) {
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

    public MutableLiveData<List<FoodDetail>> getFoodDetail(){
        MutableLiveData<List<FoodDetail>> listMutableLiveData = new MutableLiveData<>();
        unsplashImageAPI.getFoodDetail().enqueue(new Callback<List<FoodDetail>>() {
            @Override
            public void onResponse(Call<List<FoodDetail>> call, Response<List<FoodDetail>> response) {
                if(response.body() != null){
                    Log.d("DATA",response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<List<FoodDetail>> call, Throwable t) {
                t.printStackTrace();
            }
        });

        return listMutableLiveData;
    }

}
