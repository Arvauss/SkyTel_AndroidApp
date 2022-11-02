package com.example.skytel_mobileapp.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.skytel_mobileapp.Models.Deal;
import com.example.skytel_mobileapp.R;

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
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull DealAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView cardPerm;
        private final ImageView cardAdd;
        private final TextView cardTitle;
        private final TextView cardDesc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardPerm = itemView.findViewById(R.id.ImagePerm);
            cardAdd = itemView.findViewById(R.id.ImageAdd);
            cardTitle = itemView.findViewById(R.id.frontcovtitle);
            cardDesc = itemView.findViewById(R.id.frontcovdesc);
        }
    }
}
