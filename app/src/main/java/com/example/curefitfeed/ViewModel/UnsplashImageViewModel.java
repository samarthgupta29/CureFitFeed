package com.example.curefitfeed.ViewModel;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.curefitfeed.Model.CultVpImages;
import com.example.curefitfeed.Model.CustomListItem;
import com.example.curefitfeed.Model.EatVpImages;
import com.example.curefitfeed.Model.MindVpImages;
import com.example.curefitfeed.Model.UnsplashImagePOJO;
import com.example.curefitfeed.Model.UnsplashImageResult;
import com.example.curefitfeed.Repository.InputStreamHelper;
import com.example.curefitfeed.Repository.UnsplashImageRepository;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class UnsplashImageViewModel extends ViewModel {

    private MutableLiveData<List<UnsplashImagePOJO>> unsplashImagePOJOMutableLiveData;
    private UnsplashImageRepository unsplashImageRepository;
    private ArrayList<CustomListItem> listItems;
    private MutableLiveData<EatVpImages> eatVpImagesMutableLiveData;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void init(InputStreamHelper inputStreamHelper) {
        if (unsplashImagePOJOMutableLiveData != null || eatVpImagesMutableLiveData != null) {
            return;
        }
        unsplashImageRepository = UnsplashImageRepository.getInstance(inputStreamHelper);
        //unsplashImagePOJOMutableLiveData = unsplashImageRepository.getImages();
        //eatVpImagesMutableLiveData = unsplashImageRepository.getEatVpImages();
    }

    public LiveData<List<UnsplashImagePOJO>> getUnsplashImageRepository() {
        return unsplashImagePOJOMutableLiveData;
    }
    public LiveData<EatVpImages> getEatVpImages(){
        return unsplashImageRepository.getEatVpImages();
    }
    public LiveData<MindVpImages> getMindVpImages(){
        return unsplashImageRepository.getMindVpImages();
    }
    public LiveData<CultVpImages> getCultVpImages(){
        return unsplashImageRepository.getCultVpImages();
    }

    public List<CustomListItem> getEatFeed(){
        return unsplashImageRepository.getEatFeed();
    }

    public List<CustomListItem> getMindFeed(){
        return unsplashImageRepository.getMindFeed();
    }

    public List<CustomListItem> getCultFeed(){
        return unsplashImageRepository.getCultFeed();
    }

}
