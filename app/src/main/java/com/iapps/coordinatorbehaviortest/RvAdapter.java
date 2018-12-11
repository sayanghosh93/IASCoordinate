package com.iapps.coordinatorbehaviortest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder> {
    private Context context;
    private int size;
    private SwipeHelper helper;
    private List<String> list;

    public interface SwipeHelper{
        void onSwipe(int position);
    }

    public RvAdapter(Context context, List<String> list, SwipeHelper helper) {
        this.context = context;
        this.list = list;
        this.helper = helper;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        viewHolder.tv.setText(String.format(Locale.US, "%d%s%s", i+1,". ",context.getResources().getString(R.string.lorem_mid)));


//        SwipeDismissBehavior<CardView> swipe = new SwipeDismissBehavior<>();
//        swipe.setSwipeDirection(SwipeDismissBehavior.SWIPE_DIRECTION_START_TO_END);
//        final int temp = i;
//        swipe.setListener(new SwipeDismissBehavior.OnDismissListener() {
//            @Override
//            public void onDismiss(View view) {
//                helper.onSwipe(temp);
//            }
//
//            @Override
//            public void onDragStateChanged(int i) {
//
//            }
//        });
//
//        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) viewHolder.rootCv.getLayoutParams();
//        params.setBehavior(swipe);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        CardView rootCv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
            rootCv = itemView.findViewById(R.id.rootCv);

        }
    }
}
