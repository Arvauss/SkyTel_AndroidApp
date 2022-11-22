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

// RecyclerView Adapter configuration (GeeksForGeeks, 2022) https://www.geeksforgeeks.org/cardview-using-recyclerview-in-android-with-example/
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
        holder.cardTitle.setText(deal.getTitle());
        holder.cardDesc.setText(deal.getDescription());

    }

    @Override
    public int getItemCount() {
        return dealArrList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView cardTitle;
        private final TextView cardDesc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardTitle = itemView.findViewById(R.id.frontcovtitle);
            cardDesc = itemView.findViewById(R.id.frontcovdesc);
        }
    }
}
