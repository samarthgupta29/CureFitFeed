package com.example.curefitfeed.Adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.curefitfeed.Model.WhymindfitDetail;
import com.example.curefitfeed.R;

import java.util.ArrayList;
import java.util.List;

public class WhyMindFitDetailArrayListAdapter extends RecyclerView.Adapter<WhyMindFitDetailArrayListAdapter.WhyMindFitDetailArrayListViewHolder> {

    private Context context;
    private List<WhymindfitDetail> whymindfitDetailArrayList;

    public WhyMindFitDetailArrayListAdapter(Context context, List<WhymindfitDetail> whymindfitDetailArrayList) {
        this.context = context;
        this.whymindfitDetailArrayList = whymindfitDetailArrayList;
    }


    @NonNull
    @Override
    public WhyMindFitDetailArrayListAdapter.WhyMindFitDetailArrayListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.whymindfit_card_item,parent,false);
        return new WhyMindFitDetailArrayListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WhyMindFitDetailArrayListAdapter.WhyMindFitDetailArrayListViewHolder holder, int position) {
        WhymindfitDetail whymindfitDetail = whymindfitDetailArrayList.get(position);
        holder.cardHeadingTv.setText(whymindfitDetail.getHeading());
        holder.cardSubheadingTv.setText(whymindfitDetail.getInfo());
    }

    @Override
    public int getItemCount() {
        return whymindfitDetailArrayList.size();
    }

    public class WhyMindFitDetailArrayListViewHolder extends RecyclerView.ViewHolder {

        private TextView cardHeadingTv,cardSubheadingTv;

        public WhyMindFitDetailArrayListViewHolder(View view) {
            super(view);
            cardHeadingTv = view.findViewById(R.id.cardHeadingTv);
            cardSubheadingTv=view.findViewById(R.id.cardSubheadingTv);
        }
    }
}
