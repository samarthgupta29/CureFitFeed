package com.example.curefitfeed.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.curefitfeed.Model.WorkoutDetail;
import com.example.curefitfeed.R;

import java.util.ArrayList;
import java.util.List;

public class WorkoutDetailArrayListAdapter extends RecyclerView.Adapter<WorkoutDetailArrayListAdapter.WorkoutDetailArrayListViewHolder> {

    private Context context;
    private List<WorkoutDetail> detailArrayList;

    public WorkoutDetailArrayListAdapter(Context context, List<WorkoutDetail> detailArrayList) {
        this.context = context;
        this.detailArrayList = detailArrayList;
    }

    @NonNull
    @Override
    public WorkoutDetailArrayListAdapter.WorkoutDetailArrayListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.workout_card_item,parent,false);
        return new WorkoutDetailArrayListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutDetailArrayListAdapter.WorkoutDetailArrayListViewHolder holder, int position) {
        WorkoutDetail workoutDetail = detailArrayList.get(position);
        Glide.with(context).load(workoutDetail.getImageUrl()).centerCrop().into(holder.workoutIv);
    }

    @Override
    public int getItemCount() {
        return detailArrayList.size();
    }

    public class WorkoutDetailArrayListViewHolder extends RecyclerView.ViewHolder {

        private ImageView workoutIv;

        public WorkoutDetailArrayListViewHolder(@NonNull View itemView) {
            super(itemView);
            workoutIv = itemView.findViewById(R.id.workoutIv);
        }
    }
}
