package com.example.curefitfeed.viewmodel;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.curefitfeed.model.CultVpImages;
import com.example.curefitfeed.model.CustomListItem;
import com.example.curefitfeed.model.EatVpImages;
import com.example.curefitfeed.model.MindVpImages;
import com.example.curefitfeed.model.UnsplashImagePOJO;
import com.example.curefitfeed.repository.InputStreamHelper;
import com.example.curefitfeed.repository.UnsplashImageRepository;

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
    }

    public LiveData<List<UnsplashImagePOJO>> getUnsplashImageRepository() {
        return unsplashImagePOJOMutableLiveData;
    }

    public LiveData<EatVpImages> getEatVpImages() {
        return unsplashImageRepository.getEatVpImages();
    }

    public LiveData<MindVpImages> getMindVpImages() {
        return unsplashImageRepository.getMindVpImages();
    }

    public LiveData<CultVpImages> getCultVpImages() {
        return unsplashImageRepository.getCultVpImages();
    }

    public List<CustomListItem> getEatFeed() {
        return unsplashImageRepository.getEatFeed();
    }

    public List<CustomListItem> getMindFeed() {
        return unsplashImageRepository.getMindFeed();
    }

    public List<CustomListItem> getCultFeed() {
        return unsplashImageRepository.getCultFeed();
    }

}
