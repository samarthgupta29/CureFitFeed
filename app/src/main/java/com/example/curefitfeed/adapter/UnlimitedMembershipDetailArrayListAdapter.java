package com.example.curefitfeed.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.curefitfeed.model.UnlimitedmembershipDetail;
import com.example.curefitfeed.R;

import java.util.List;

public class UnlimitedMembershipDetailArrayListAdapter extends RecyclerView.Adapter<UnlimitedMembershipDetailArrayListAdapter.UnlimitedMembershipDetailArrayListViewHolder> {

    private Context context;
    private List<UnlimitedmembershipDetail> detailArrayList;

    public UnlimitedMembershipDetailArrayListAdapter(Context context, List<UnlimitedmembershipDetail> detailArrayList) {
        this.context = context;
        this.detailArrayList = detailArrayList;
    }

    @NonNull
    @Override
    public UnlimitedMembershipDetailArrayListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mind_unlimited_card_item, parent, false);
        return new UnlimitedMembershipDetailArrayListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UnlimitedMembershipDetailArrayListViewHolder holder, int position) {
        UnlimitedmembershipDetail unlimitedmembershipDetail = detailArrayList.get(position);
        holder.textView5.setText(holder.itemView.getContext().getString(R.string.rupee) + " " + unlimitedmembershipDetail.getPrice());
        holder.textView5.setPaintFlags(holder.textView5.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        holder.textView7.setText(holder.itemView.getContext().getString(R.string.rupee) + " " + unlimitedmembershipDetail.getOfferPrice());
        Glide.with(context).load(unlimitedmembershipDetail.getImageUrl()).centerCrop().into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return detailArrayList.size();
    }

    public class UnlimitedMembershipDetailArrayListViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textView4, textView5, textView6, textView7;

        public UnlimitedMembershipDetailArrayListViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView4 = itemView.findViewById(R.id.textView4);
            textView5 = itemView.findViewById(R.id.textView5);
            textView6 = itemView.findViewById(R.id.textView6);
            textView7 = itemView.findViewById(R.id.textView7);
        }
    }
}
