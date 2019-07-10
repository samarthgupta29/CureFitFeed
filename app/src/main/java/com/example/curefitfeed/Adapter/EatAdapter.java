package com.example.curefitfeed.Adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.bumptech.glide.Glide;
import com.example.curefitfeed.Model.CultMonthlySubscriptionItem;
import com.example.curefitfeed.Model.CultSelectMembershipItem;
import com.example.curefitfeed.Model.CultUnlimitedMembershipItem;
import com.example.curefitfeed.Model.CultWorkoutItem;
import com.example.curefitfeed.Model.CultselectmembershipDetail;
import com.example.curefitfeed.Model.CultunlimitedmembershipDetail;
import com.example.curefitfeed.Model.CultworkoutDetail;
import com.example.curefitfeed.Model.CustomListItem;
import com.example.curefitfeed.Model.FoodItem;
import com.example.curefitfeed.Model.HeaderItem;
import com.example.curefitfeed.Model.MindMonthlySubscriptionItem;
import com.example.curefitfeed.Model.MindUnlimitedMembershipItem;
import com.example.curefitfeed.Model.MindWorkoutItem;
import com.example.curefitfeed.Model.TrainerDetail;
import com.example.curefitfeed.Model.TrainerItem;
import com.example.curefitfeed.Model.UnlimitedmembershipDetail;
import com.example.curefitfeed.Model.WhyCultFitItem;
import com.example.curefitfeed.Model.WhyMindFitItem;
import com.example.curefitfeed.Model.WhycultfitDetail;
import com.example.curefitfeed.Model.WhymindfitDetail;
import com.example.curefitfeed.Model.WorkoutDetail;
import com.example.curefitfeed.R;

import java.util.List;

public class EatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private List<CustomListItem> listItems;
    private Context context;

    public EatAdapter(Activity context, List<CustomListItem> listItems) {
        this.context = context;
        this.listItems = listItems;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case CustomListItem.TYPE_FOOD:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.eat_item, parent, false);
                viewHolder = new EatViewHolder(view);
                break;
            case CustomListItem.TYPE_HEADER:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.heading_item, parent, false);
                viewHolder = new HeadingViewHolder(view);
                break;
            case CustomListItem.TYPE_WHYMINDFIT:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.whymindfeed_item, parent, false);
                viewHolder = new WhyMindFitViewHolder(view);
                break;
            case CustomListItem.TYPE_UNLIMITEDMEMBERSHIP:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mind_unlimited_membership_item, parent, false);
                viewHolder = new MindUnlimitedMemberViewHolder(view);
                break;
            case CustomListItem.TYPE_MONTHLYSUB:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.monthly_sub_item, parent, false);
                viewHolder = new MonthlySubViewHolder(view);
                break;
            case CustomListItem.TYPE_GRID:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.workout_item, parent, false);
                viewHolder = new WorkoutViewHolder(view);
                break;
            case CustomListItem.TYPE_TRAINERS:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.trainer_item, parent, false);
                viewHolder = new TrainerViewHolder(view);
                break;
            /*case CustomListItem.TYPE_GRID_FEED:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_feed_item, parent, false);
                viewHolder = new GridFeedViewHolder(view);
                break;*/
            //case CustomListItem.TYPE_FOOD:
            //break;
            //case CustomListItem.TYPE_FOOD:
            //break;

        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CustomListItem customListItem = listItems.get(position);
        if (customListItem instanceof FoodItem) {
            EatViewHolder eatViewHolder = (EatViewHolder) holder;
            eatViewHolder.bind(((FoodItem) customListItem));

        } else if (customListItem instanceof HeaderItem) {
            HeadingViewHolder headingViewHolder = (HeadingViewHolder) holder;
            headingViewHolder.headingTv.setText(((HeaderItem) customListItem).getNavItem().getName());

        } else if (customListItem instanceof WhyMindFitItem) {
            List<WhymindfitDetail> whymindfitDetailArrayList = ((WhyMindFitItem) customListItem).getDetailList();
            WhyMindFitViewHolder whyMindFitViewHolder = (WhyMindFitViewHolder) holder;
            whyMindFitViewHolder.headingTv.setText(whyMindFitViewHolder.itemView.getContext().getString(R.string.why_mindfit));
            WhyMindFitDetailArrayListAdapter whyMindFitDetailArrayListAdapter = new WhyMindFitDetailArrayListAdapter(context, whymindfitDetailArrayList);
            whyMindFitViewHolder.mindfitCardRv.setHasFixedSize(true);
            whyMindFitViewHolder.mindfitCardRv.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
            whyMindFitViewHolder.mindfitCardRv.setAdapter(whyMindFitDetailArrayListAdapter);

        } else if (customListItem instanceof MindUnlimitedMembershipItem) {
            List<UnlimitedmembershipDetail> unlimitedmembershipDetailArrayList = ((MindUnlimitedMembershipItem) customListItem).getDetailList();
            MindUnlimitedMemberViewHolder mindUnlimitedMemberViewHolder = (MindUnlimitedMemberViewHolder) holder;
            mindUnlimitedMemberViewHolder.mindunlimitedmembershipTv.setText(mindUnlimitedMemberViewHolder.itemView.getContext().getString(R.string.mind_unlimited_membership));
            mindUnlimitedMemberViewHolder.subHeading1Tv.setText(((MindUnlimitedMembershipItem) customListItem).getHeaderInfo_1());
            mindUnlimitedMemberViewHolder.subHeading2Tv.setText(((MindUnlimitedMembershipItem) customListItem).getHeaderInfo_2());
            UnlimitedMembershipDetailArrayListAdapter unlimitedMembershipDetailArrayListAdapter = new UnlimitedMembershipDetailArrayListAdapter(context, unlimitedmembershipDetailArrayList);
            mindUnlimitedMemberViewHolder.mindunlimitedRv.setHasFixedSize(true);
            mindUnlimitedMemberViewHolder.mindunlimitedRv.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
            mindUnlimitedMemberViewHolder.mindunlimitedRv.setAdapter(unlimitedMembershipDetailArrayListAdapter);

        } else if (customListItem instanceof MindMonthlySubscriptionItem) {
            MonthlySubViewHolder monthlySubViewHolder = (MonthlySubViewHolder) holder;
            Glide.with(context).load(((MindMonthlySubscriptionItem) customListItem).getImageUrl()).centerCrop().into(monthlySubViewHolder.imageView2);
            monthlySubViewHolder.textView3.setText(((MindMonthlySubscriptionItem) customListItem).getInfo());
            monthlySubViewHolder.textView8.setText(monthlySubViewHolder.itemView.getContext().getString(R.string.first_month));
            monthlySubViewHolder.textView9.setText(monthlySubViewHolder.itemView.getContext().getString(R.string.second_month));
            monthlySubViewHolder.textView10.setText(monthlySubViewHolder.itemView.getContext().getString(R.string.rupee)+" "+((MindMonthlySubscriptionItem) customListItem).getFirstMonth());
            monthlySubViewHolder.textView11.setText(monthlySubViewHolder.itemView.getContext().getString(R.string.rupee)+" "+((MindMonthlySubscriptionItem) customListItem).getSecondMonthOnwards());

        } else if (customListItem instanceof MindWorkoutItem) {
            List<WorkoutDetail> workoutDetailArrayList = ((MindWorkoutItem) customListItem).getDetailList();
            WorkoutViewHolder workoutViewHolder = (WorkoutViewHolder) holder;
            workoutViewHolder.workoutSubHeadingTv.setText(((MindWorkoutItem) customListItem).getHeaderInfo_1());
            WorkoutDetailArrayListAdapter workoutDetailArrayListAdapter = new WorkoutDetailArrayListAdapter(context, workoutDetailArrayList);
            workoutViewHolder.workoutGridRv.setHasFixedSize(true);
            workoutViewHolder.workoutGridRv.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL));
            workoutViewHolder.workoutGridRv.setAdapter(workoutDetailArrayListAdapter);

        } else if (customListItem instanceof CultUnlimitedMembershipItem) {
            MindUnlimitedMemberViewHolder mindUnlimitedMemberViewHolder = (MindUnlimitedMemberViewHolder) holder;
            List<CultunlimitedmembershipDetail> cultunlimitedmembershipDetailArrayList = ((CultUnlimitedMembershipItem) customListItem).getDetailList();
            mindUnlimitedMemberViewHolder.mindunlimitedmembershipTv.setText(mindUnlimitedMemberViewHolder.itemView.getContext().getString(R.string.cult_unlimited));
            mindUnlimitedMemberViewHolder.subHeading1Tv.setText(((CultUnlimitedMembershipItem) customListItem).getHeaderInfo1());
            mindUnlimitedMemberViewHolder.subHeading2Tv.setText(((CultUnlimitedMembershipItem) customListItem).getHeaderInfo2());
            CultunlimitedmembershipDetailArrayListAdapter cultunlimitedmembershipDetailArrayListAdapter = new CultunlimitedmembershipDetailArrayListAdapter(context, cultunlimitedmembershipDetailArrayList);
            mindUnlimitedMemberViewHolder.mindunlimitedRv.setHasFixedSize(true);
            mindUnlimitedMemberViewHolder.mindunlimitedRv.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
            mindUnlimitedMemberViewHolder.mindunlimitedRv.setAdapter(cultunlimitedmembershipDetailArrayListAdapter);

        } else if (customListItem instanceof CultMonthlySubscriptionItem) {
            MonthlySubViewHolder monthlySubViewHolder = (MonthlySubViewHolder) holder;
            Glide.with(context).load(((CultMonthlySubscriptionItem) customListItem).getImageUrl()).centerCrop().into(monthlySubViewHolder.imageView2);
            monthlySubViewHolder.textView3.setText(((CultMonthlySubscriptionItem) customListItem).getInfo());
            monthlySubViewHolder.textView10.setText(monthlySubViewHolder.itemView.getContext().getString(R.string.rupee)+" "+((CultMonthlySubscriptionItem) customListItem).getFirstMonth());
            monthlySubViewHolder.textView11.setText(monthlySubViewHolder.itemView.getContext().getString(R.string.rupee)+" "+((CultMonthlySubscriptionItem) customListItem).getSecondMonthOnwards());
            monthlySubViewHolder.textView8.setText(monthlySubViewHolder.itemView.getContext().getString(R.string.first_month));
            monthlySubViewHolder.textView9.setText(monthlySubViewHolder.itemView.getContext().getString(R.string.second_month));

        } else if (customListItem instanceof CultSelectMembershipItem) {
            List<CultselectmembershipDetail> cultselectmembershipDetailArrayList = ((CultSelectMembershipItem) customListItem).getDetailList();
            MindUnlimitedMemberViewHolder mindUnlimitedMemberViewHolder = (MindUnlimitedMemberViewHolder) holder;
            mindUnlimitedMemberViewHolder.subHeading1Tv.setText(((CultSelectMembershipItem) customListItem).getHeaderInfo1());
            mindUnlimitedMemberViewHolder.subHeading2Tv.setText(((CultSelectMembershipItem) customListItem).getHeaderInfo2());
            mindUnlimitedMemberViewHolder.mindunlimitedmembershipTv.setText(mindUnlimitedMemberViewHolder.itemView.getContext().getString(R.string.cult_select));
            CultSelectMembershipDetailArrayListAdapter cultSelectMembershipDetailArrayListAdapter = new CultSelectMembershipDetailArrayListAdapter(context, cultselectmembershipDetailArrayList);
            mindUnlimitedMemberViewHolder.mindunlimitedRv.setHasFixedSize(true);
            mindUnlimitedMemberViewHolder.mindunlimitedRv.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
            mindUnlimitedMemberViewHolder.mindunlimitedRv.setAdapter(cultSelectMembershipDetailArrayListAdapter);

        } else if (customListItem instanceof WhyCultFitItem) {
            List<WhycultfitDetail> detailArrayList = ((WhyCultFitItem) customListItem).getDetailList();
            WhyMindFitViewHolder whyMindFitViewHolder = (WhyMindFitViewHolder) holder;
            whyMindFitViewHolder.headingTv.setText(whyMindFitViewHolder.itemView.getContext().getString(R.string.why_cultfit));
            whyMindFitViewHolder.subHeadingTv.setText(((WhyCultFitItem) customListItem).getHeaderInfo1());
            WhyCultfitListAdapter whyCultfitListAdapter = new WhyCultfitListAdapter(context, detailArrayList);
            whyMindFitViewHolder.mindfitCardRv.setHasFixedSize(true);
            whyMindFitViewHolder.mindfitCardRv.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
            whyMindFitViewHolder.mindfitCardRv.setAdapter(whyCultfitListAdapter);

        } else if (customListItem instanceof CultWorkoutItem) {
            List<CultworkoutDetail> detailList = ((CultWorkoutItem) customListItem).getDetailList();
            WorkoutViewHolder workoutViewHolder = (WorkoutViewHolder) holder;
            workoutViewHolder.workoutSubHeadingTv.setText(((CultWorkoutItem) customListItem).getHeaderInfo1());
            CultworkoutDetailListAdapter cultworkoutDetailListAdapter = new CultworkoutDetailListAdapter(context, detailList);
            workoutViewHolder.workoutGridRv.setHasFixedSize(true);
            workoutViewHolder.workoutGridRv.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL));
            workoutViewHolder.workoutGridRv.setAdapter(cultworkoutDetailListAdapter);

        } else if (customListItem instanceof TrainerItem) {
            List<TrainerDetail> detailList = ((TrainerItem) customListItem).getDetailList();
            TrainerViewHolder trainerViewHolder = (TrainerViewHolder) holder;
            trainerViewHolder.ourTrainerTv.setText(trainerViewHolder.itemView.getContext().getString(R.string.trainer));
            trainerViewHolder.trainerSubheadTv.setText(((TrainerItem) customListItem).getHeaderInfo1());
            TrainerDetailListAdapter trainerDetailListAdapter = new TrainerDetailListAdapter(context, detailList);
            trainerViewHolder.trainerRv.setHasFixedSize(true);
            trainerViewHolder.trainerRv.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
            trainerViewHolder.trainerRv.setAdapter(trainerDetailListAdapter);
        }

    }


    @Override
    public int getItemViewType(int position) {
        return listItems.get(position).getType();
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }


    public class EatViewHolder extends RecyclerView.ViewHolder {

        private ImageView dishIv;
        private TextView dishTitleTv, calTv, fitcashTv, priceTv, dietTypeTv, actualPriceTv;
        private Button addBtn;

        public EatViewHolder(@NonNull View itemView) {
            super(itemView);
            dishIv = itemView.findViewById(R.id.dishIv);
            dishTitleTv = itemView.findViewById(R.id.dishTitleTv);
            calTv = itemView.findViewById(R.id.calTv);
            fitcashTv = itemView.findViewById(R.id.fitcashTv);
            priceTv = itemView.findViewById(R.id.priceTv);
            dietTypeTv = itemView.findViewById(R.id.dietTypeTv);
            actualPriceTv = itemView.findViewById(R.id.actualPriceTv);
            addBtn = itemView.findViewById(R.id.addBtn);
        }

        public void bind(FoodItem customListItem) {
            dishTitleTv.setText(customListItem.getFood().getDishTitle());
            calTv.setText(customListItem.getFood().getCalorieCount());
            dietTypeTv.setText(customListItem.getFood().getDietType());
            fitcashTv.setText(itemView.getContext().getString(R.string.upto) + " " + customListItem.getFood().getFitcashAmount() + " " +
                    itemView.getContext().getString(R.string.fitcash));
            priceTv.setText(itemView.getContext().getString(R.string.rupee) + customListItem.getFood().getDiscountedPrice());
            actualPriceTv.setPaintFlags(actualPriceTv.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            actualPriceTv.setText(itemView.getContext().getString(R.string.rupee) + customListItem.getFood().getActualPrice());
            Glide.with(context).load(customListItem.getFood().getImageUrl()).centerCrop().into(dishIv);
        }
    }

    private class HeadingViewHolder extends RecyclerView.ViewHolder {

        private TextView headingTv;

        public HeadingViewHolder(View view) {
            super(view);
            headingTv = view.findViewById(R.id.headingTv);
        }
    }

    private class HorizontalFeedViewHolder extends RecyclerView.ViewHolder {
        public HorizontalFeedViewHolder(View view) {
            super(view);
        }
    }

    private class GridFeedViewHolder extends RecyclerView.ViewHolder {
        public GridFeedViewHolder(View view) {
            super(view);
        }
    }

    private class WhyMindFitViewHolder extends RecyclerView.ViewHolder {

        private TextView headingTv, subHeadingTv;
        private RecyclerView mindfitCardRv;

        public WhyMindFitViewHolder(View view) {
            super(view);
            headingTv = view.findViewById(R.id.textView);
            subHeadingTv = view.findViewById(R.id.textView2);
            mindfitCardRv = view.findViewById(R.id.mindfitCardRv);
        }
    }

    private class MindUnlimitedMemberViewHolder extends RecyclerView.ViewHolder {

        private TextView mindunlimitedmembershipTv, subHeading1Tv, subHeading2Tv;
        private RecyclerView mindunlimitedRv;

        public MindUnlimitedMemberViewHolder(View view) {
            super(view);

            mindunlimitedmembershipTv = view.findViewById(R.id.mindunlimitedmembershipTv);
            subHeading1Tv = view.findViewById(R.id.subHeading1Tv);
            subHeading2Tv = view.findViewById(R.id.subHeading2Tv);
            mindunlimitedRv = view.findViewById(R.id.mindunlimitedRv);
        }
    }

    private class MonthlySubViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView2;
        private TextView textView3, textView8, textView9, textView10, textView11;

        public MonthlySubViewHolder(View view) {
            super(view);
            imageView2 = view.findViewById(R.id.imageView2);
            textView3 = view.findViewById(R.id.textView3);
            textView8 = view.findViewById(R.id.textView8);
            textView9 = view.findViewById(R.id.textView9);
            textView10 = view.findViewById(R.id.textView10);
            textView11 = view.findViewById(R.id.textView11);
        }
    }

    private class WorkoutViewHolder extends RecyclerView.ViewHolder {

        private TextView workoutTv, workoutSubHeadingTv;
        private RecyclerView workoutGridRv;

        public WorkoutViewHolder(View view) {
            super(view);

            workoutTv = view.findViewById(R.id.workoutTv);
            workoutSubHeadingTv = view.findViewById(R.id.workoutSubHeadingTv);
            workoutGridRv = view.findViewById(R.id.workoutGridRv);
        }
    }

    private class TrainerViewHolder extends RecyclerView.ViewHolder {

        private TextView ourTrainerTv, trainerSubheadTv;
        private RecyclerView trainerRv;

        public TrainerViewHolder(View view) {
            super(view);
            ourTrainerTv = view.findViewById(R.id.ourTrainerTv);
            trainerSubheadTv = view.findViewById(R.id.trainerSubheadTv);
            trainerRv = view.findViewById(R.id.trainerRv);
        }
    }



    /*public void setData(List<UnsplashImagePOJO> data) {
        unsplashImagePOJOList.clear();
        unsplashImagePOJOList.addAll(data);
        this.unsplashImagePOJOList = data;
        notifyDataSetChanged();
    }*/

    /*public void getScrollToItemPos(NavItem obj){
        //
    }*/
}
