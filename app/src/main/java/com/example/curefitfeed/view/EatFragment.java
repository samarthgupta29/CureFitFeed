package com.example.curefitfeed.view;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.curefitfeed.adapter.EatAdapter;
import com.example.curefitfeed.adapter.EatViewPagerAdapter;
import com.example.curefitfeed.model.EatVpImage;
import com.example.curefitfeed.R;
import com.example.curefitfeed.viewmodel.UnsplashImageViewModel;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class EatFragment extends Fragment {

    private RecyclerView eatRv;
    private EatAdapter eatAdapter;
    private LinearLayoutManager linearLayoutManager;
    private UnsplashImageViewModel unsplashImageViewModel;
    private ViewPager viewPager;
    private EatViewPagerAdapter eatViewPagerAdapter;
    int currentPage = 0;
    Timer timer;
    final long DELAY_MS = 100;//delay in milliseconds before task is to be executed
    final long PERIOD_MS = 3000;
    List<EatVpImage> eatVpImageList = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        unsplashImageViewModel = ViewModelProviders.of(getActivity()).get(UnsplashImageViewModel.class);
        unsplashImageViewModel.init(file -> {
            try {
                if (getActivity() != null) {
                    return inputStreamtoString(getActivity().getAssets().open(file));
                } else {
                    return null;
                }

            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        });
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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.eat_fragment, null);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUp(view);
    }

    private void viewPagerDelay() {
        final Handler handler = new Handler();
        final Runnable Update = () -> {
            if (currentPage == (eatVpImageList.size())) {
                currentPage = 0;
            }
            viewPager.setCurrentItem(currentPage++, true);
        };

        timer = new Timer(); // This will create a new Thread
        timer.schedule(new TimerTask() { // task to be scheduled
            @Override
            public void run() {
                handler.post(Update);
            }
        }, DELAY_MS, PERIOD_MS);
    }

    private void setUp(View view) {
        eatRv = view.findViewById(R.id.eatFragmentRv);
        viewPager = view.findViewById(R.id.eatVp);
        unsplashImageViewModel.getEatVpImages().observe(getViewLifecycleOwner(), eatVpImages -> {
            eatVpImageList.addAll(eatVpImages.getEatVpImages());
            eatViewPagerAdapter = new EatViewPagerAdapter(getContext(), eatVpImageList);
            viewPager.setAdapter(eatViewPagerAdapter);
        });
        viewPagerDelay();
        eatRv.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        eatRv.setLayoutManager(linearLayoutManager);
        eatAdapter = new EatAdapter(getActivity(), unsplashImageViewModel.getEatFeed());
        eatRv.setAdapter(eatAdapter);
    }
}
