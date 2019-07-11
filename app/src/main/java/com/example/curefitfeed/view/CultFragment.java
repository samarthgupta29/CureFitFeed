package com.example.curefitfeed.view;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.curefitfeed.adapter.CultViewPagerAdapter;
import com.example.curefitfeed.adapter.EatAdapter;
import com.example.curefitfeed.model.CultVpImage;
import com.example.curefitfeed.R;
import com.example.curefitfeed.viewmodel.UnsplashImageViewModel;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class CultFragment extends Fragment {

    private UnsplashImageViewModel unsplashImageViewModel;
    private RecyclerView cultRv;
    private EatAdapter eatAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ViewPager viewPager;
    private CultViewPagerAdapter cultViewPagerAdapter;
    private List<CultVpImage> imageList = new ArrayList<>();
    int currentPage = 0;
    Timer timer;
    final long DELAY_MS = 100;//delay in milliseconds before task is to be executed
    final long PERIOD_MS = 3000;

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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cult_fragment, null);
        return view;
    }

    private void viewPagerDelay() {
        final Handler handler = new Handler();
        final Runnable Update = () -> {
            if (currentPage == (imageList.size())) { // 3 is the number of images
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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUp(view);
    }

    private void setUp(View view) {
        cultRv = view.findViewById(R.id.cultFragmentRv);
        cultRv.setHasFixedSize(true);
        viewPager = view.findViewById(R.id.cultVp);
        unsplashImageViewModel.getCultVpImages().observe(getViewLifecycleOwner(), cultVpImages -> {
            imageList.addAll(cultVpImages.getCultVpImages());
            cultViewPagerAdapter = new CultViewPagerAdapter(getContext(), imageList);
            viewPager.setAdapter(cultViewPagerAdapter);
        });
        viewPagerDelay();
        layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        cultRv.setLayoutManager(layoutManager);
        eatAdapter = new EatAdapter(getActivity(), unsplashImageViewModel.getCultFeed());
        cultRv.setAdapter(eatAdapter);
    }
}
