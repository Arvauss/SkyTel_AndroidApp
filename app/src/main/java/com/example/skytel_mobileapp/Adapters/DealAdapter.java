package com.example.skytel_mobileapp.Adapters;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.skytel_mobileapp.Models.Deal;
import com.example.skytel_mobileapp.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class DealAdapter extends RecyclerView.Adapter<DealAdapter.ViewHolder> {
    private final Context context;
    private final ArrayList<Deal> dealArrList;

    public DealAdapter(Context context, ArrayList<Deal> dealList){
        this.context = context;
        this.dealArrList = dealList;
    }

    @NonNull
    @Override
    public DealAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.frontcover_cardview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DealAdapter.ViewHolder holder, int position) {
        Deal deal = dealArrList.get(position);
        holder.cardTitle.setText(deal.getDealTitle());
        holder.cardDesc.setText(deal.getDealDesc());

        if (deal.getDealPermURL() != null){
            Picasso.get().load(deal.getDealPermURL()).resize(150 , 120).centerCrop().into(holder.cardPerm);}
        if (deal.getDealAddURL() != null){
            Picasso.get().load(deal.getDealAddURL()).resize(200, 80).centerCrop().into(holder.cardAdd);
        }
    }

    @Override
    public int getItemCount() {
        return dealArrList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView cardPerm;
        private final ImageView cardAdd;
        private final TextView cardTitle;
        private final TextView cardDesc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardPerm = (ImageView) itemView.findViewById(R.id.ImagePerm);
            cardAdd = (ImageView) itemView.findViewById(R.id.ImageAdd);
            cardTitle = itemView.findViewById(R.id.frontcovtitle);
            cardDesc = itemView.findViewById(R.id.frontcovdesc);
        }
    }
}
