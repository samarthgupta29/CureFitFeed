package com.example.curefitfeed.View;

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
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.curefitfeed.Adapter.EatViewPagerAdapter;
import com.example.curefitfeed.Adapter.EatAdapter;
import com.example.curefitfeed.Adapter.MindViewPagerAdapter;
import com.example.curefitfeed.Model.MindVpImage;
import com.example.curefitfeed.Model.MindVpImages;
import com.example.curefitfeed.R;
import com.example.curefitfeed.Repository.InputStreamHelper;
import com.example.curefitfeed.ViewModel.UnsplashImageViewModel;

import java.io.IOException;
import java.io.InputStream;
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
    int[] images = {R.drawable.pic, R.drawable.pic2};
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
        unsplashImageViewModel.init(new InputStreamHelper() {

            @Override
            public InputStream getInputStream(String file) {
                try {
                    if (getActivity() != null) {
                        return getActivity().getAssets().open(file);
                    } else {
                        return null;
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mind_fragment, null);
        mindRv = view.findViewById(R.id.mindRv);
        mindRv.setHasFixedSize(true);
        viewPager = view.findViewById(R.id.mindVp);
        unsplashImageViewModel.getMindVpImages().observe(getViewLifecycleOwner(), new Observer<MindVpImages>() {
            @Override
            public void onChanged(MindVpImages mindVpImages) {
                mindVpImagesList.addAll(mindVpImages.getMindVpImages());
                mindViewPagerAdapter = new MindViewPagerAdapter(getContext(), mindVpImagesList);
                viewPager.setAdapter(mindViewPagerAdapter);
            }
        });
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == (mindVpImagesList.size() + 1) - 1) { // 3 is the number of images
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
            }
        };

        timer = new Timer(); // This will create a new Thread
        timer.schedule(new TimerTask() { // task to be scheduled
            @Override
            public void run() {
                handler.post(Update);
            }
        }, DELAY_MS, PERIOD_MS);

        layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        mindRv.setLayoutManager(layoutManager);
        eatAdapter = new EatAdapter(getActivity(), unsplashImageViewModel.getMindFeed());
        mindRv.setAdapter(eatAdapter);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //System.out.println(unsplashImageViewModel.getMindFeed());
    }
}
