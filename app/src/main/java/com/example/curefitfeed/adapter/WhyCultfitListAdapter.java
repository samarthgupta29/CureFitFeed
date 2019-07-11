package com.example.curefitfeed.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.curefitfeed.model.WhycultfitDetail;
import com.example.curefitfeed.R;

import java.util.List;

public class WhyCultfitListAdapter extends RecyclerView.Adapter<WhyCultfitListAdapter.WhyCultfitListViewHolder> {

    private Context context;
    private List<WhycultfitDetail> detailList;

    public WhyCultfitListAdapter(Context context, List<WhycultfitDetail> detailList) {
        this.context = context;
        this.detailList = detailList;
    }

    @NonNull
    @Override
    public WhyCultfitListAdapter.WhyCultfitListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.whymindfit_card_item, parent, false);
        return new WhyCultfitListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WhyCultfitListAdapter.WhyCultfitListViewHolder holder, int position) {
        WhycultfitDetail whycultfitDetail = detailList.get(position);
        holder.cardHeadingTv.setText(whycultfitDetail.getHeading());
        holder.cardSubheadingTv.setText(whycultfitDetail.getInfo());
    }

    @Override
    public int getItemCount() {
        return detailList.size();
    }

    public class WhyCultfitListViewHolder extends RecyclerView.ViewHolder {

        private TextView cardHeadingTv, cardSubheadingTv;

        public WhyCultfitListViewHolder(@NonNull View itemView) {
            super(itemView);
            cardHeadingTv = itemView.findViewById(R.id.cardHeadingTv);
            cardSubheadingTv = itemView.findViewById(R.id.cardSubheadingTv);
        }
    }
}
