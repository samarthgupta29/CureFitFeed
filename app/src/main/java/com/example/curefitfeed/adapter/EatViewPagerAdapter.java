package com.example.curefitfeed.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.curefitfeed.model.EatVpImage;
import com.example.curefitfeed.R;

import java.util.List;

public class EatViewPagerAdapter extends PagerAdapter {

    Context context;
    List<EatVpImage> imageList;
    LayoutInflater layoutInflater;


    public EatViewPagerAdapter(Context context, List<EatVpImage> imageList) {
        this.context = context;
        this.imageList = imageList;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return imageList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        EatVpImage eatVpImage = imageList.get(position);
        View itemView = layoutInflater.inflate(R.layout.eat_vp_item, container, false);
        ImageView imageView = itemView.findViewById(R.id.imageView3);
        Glide.with(context).load(eatVpImage.getImageUrl()).centerCrop().into(imageView);
        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout) object);
    }
}
