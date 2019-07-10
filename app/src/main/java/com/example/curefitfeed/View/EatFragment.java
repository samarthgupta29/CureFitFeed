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
import com.example.curefitfeed.Model.EatVpImage;
import com.example.curefitfeed.Model.EatVpImages;
import com.example.curefitfeed.R;
import com.example.curefitfeed.Repository.InputStreamHelper;
import com.example.curefitfeed.ViewModel.UnsplashImageViewModel;

import java.io.IOException;
import java.io.InputStream;
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
    int[] images = {R.drawable.pic, R.drawable.pic2};
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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.eat_fragment, null);
        eatRv = view.findViewById(R.id.eatFragmentRv);
        viewPager = view.findViewById(R.id.eatVp);
        unsplashImageViewModel.getEatVpImages().observe(getViewLifecycleOwner(), new Observer<EatVpImages>() {
            @Override
            public void onChanged(EatVpImages eatVpImages) {
                eatVpImageList.addAll(eatVpImages.getEatVpImages());
                eatViewPagerAdapter = new EatViewPagerAdapter(getContext(), eatVpImageList);
                viewPager.setAdapter(eatViewPagerAdapter);
            }
        });
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == (eatVpImageList.size() + 1) - 1) { // 3 is the number of images
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

        eatRv.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        eatRv.setLayoutManager(linearLayoutManager);
        //eatRv.scrollToPosition(eatAdapter.geti);
        eatAdapter = new EatAdapter(getActivity(), unsplashImageViewModel.getEatFeed());
        eatRv.setAdapter(eatAdapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
