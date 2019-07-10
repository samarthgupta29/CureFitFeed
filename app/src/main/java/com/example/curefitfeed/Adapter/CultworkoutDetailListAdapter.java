package com.example.curefitfeed.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.curefitfeed.Model.CultworkoutDetail;
import com.example.curefitfeed.R;

import java.util.List;

public class CultworkoutDetailListAdapter extends RecyclerView.Adapter<CultworkoutDetailListAdapter.CultworkoutDetailListViewHolder> {

    private Context context;
    private List<CultworkoutDetail> detailList;

    public CultworkoutDetailListAdapter(Context context, List<CultworkoutDetail> detailList) {
        this.context = context;
        this.detailList = detailList;
    }

    @NonNull
    @Override
    public CultworkoutDetailListAdapter.CultworkoutDetailListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.workout_card_item,parent,false);
        return new CultworkoutDetailListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CultworkoutDetailListAdapter.CultworkoutDetailListViewHolder holder, int position) {
        CultworkoutDetail cultworkoutDetail = detailList.get(position);
        Glide.with(context).load(cultworkoutDetail.getImageUrl()).centerCrop().into(holder.workoutIv);
    }

    @Override
    public int getItemCount() {
        return detailList.size();
    }

    public class CultworkoutDetailListViewHolder extends RecyclerView.ViewHolder {

        private ImageView workoutIv;

        public CultworkoutDetailListViewHolder(@NonNull View itemView) {
            super(itemView);
            workoutIv = itemView.findViewById(R.id.workoutIv);
        }
    }
}
