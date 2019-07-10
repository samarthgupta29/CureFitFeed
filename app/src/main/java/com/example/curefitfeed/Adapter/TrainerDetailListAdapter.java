package com.example.curefitfeed.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.curefitfeed.Model.TrainerDetail;
import com.example.curefitfeed.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

class TrainerDetailListAdapter extends RecyclerView.Adapter<TrainerDetailListAdapter.TrainerDetailListViewHolder> {

    private Context context;
    private List<TrainerDetail> detailList;

    public TrainerDetailListAdapter(Context context, List<TrainerDetail> detailList) {
        this.context = context;
        this.detailList = detailList;
    }


    @NonNull
    @Override
    public TrainerDetailListAdapter.TrainerDetailListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.trainer_card_item, parent, false);
        return new TrainerDetailListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrainerDetailListAdapter.TrainerDetailListViewHolder holder, int position) {
        TrainerDetail trainerDetail = detailList.get(position);
        Glide.with(context).load(trainerDetail.getImageUrl()).centerCrop().into(holder.circleImageView);
        holder.trainerNameTv.setText(trainerDetail.getTrainerName());
    }

    @Override
    public int getItemCount() {
        return detailList.size();
    }

    public class TrainerDetailListViewHolder extends RecyclerView.ViewHolder {

        private CircleImageView circleImageView;
        private TextView trainerNameTv;

        public TrainerDetailListViewHolder(@NonNull View itemView) {
            super(itemView);

            circleImageView = itemView.findViewById(R.id.circleImageView);
            trainerNameTv = itemView.findViewById(R.id.trainerNameTv);
        }
    }
}
