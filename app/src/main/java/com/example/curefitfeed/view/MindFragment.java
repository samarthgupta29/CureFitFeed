package com.example.curefitfeed.view;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
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
import com.example.curefitfeed.adapter.MindViewPagerAdapter;
import com.example.curefitfeed.model.MindVpImage;
import com.example.curefitfeed.R;
import com.example.curefitfeed.viewmodel.UnsplashImageViewModel;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MindFragment extends Fragment {
    private UnsplashImageViewModel unsplashImageViewModel;
    private RecyclerView mindRv;
    private EatAdapter eatAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ViewPager viewPager;
    private MindViewPagerAdapter mindViewPagerAdapter;
    private List<MindVpImage> mindVpImagesList = new ArrayList<>();
    int currentPage = 0;
    Timer timer;
    final long DELAY_MS = 100;//delay in milliseconds before task is to be executed
    final long PERIOD_MS = 3000;

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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mind_fragment, null);
        return view;
    }

    private void setUp(View view) {
        mindRv = view.findViewById(R.id.mindRv);
        mindRv.setHasFixedSize(true);
        viewPager = view.findViewById(R.id.mindVp);
        unsplashImageViewModel.getMindVpImages().observe(getViewLifecycleOwner(), mindVpImages -> {
            mindVpImagesList.addAll(mindVpImages.getMindVpImages());
            mindViewPagerAdapter = new MindViewPagerAdapter(getContext(), mindVpImagesList);
            viewPager.setAdapter(mindViewPagerAdapter);
        });
        viewPagerDelay();
        layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        mindRv.setLayoutManager(layoutManager);
        eatAdapter = new EatAdapter(getActivity(), unsplashImageViewModel.getMindFeed());
        mindRv.setAdapter(eatAdapter);
    }

    private void viewPagerDelay() {
        final Handler handler = new Handler();
        final Runnable Update = () -> {
            if (currentPage == (mindVpImagesList.size())) { // 3 is the number of images
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
        setUp(view);
        super.onViewCreated(view, savedInstanceState);
    }
}
