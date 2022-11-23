package com.example.skytel_mobileapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.skytel_mobileapp.Models.FAQModel;
import com.example.skytel_mobileapp.R;

import java.util.ArrayList;

public class FAQAdapter extends RecyclerView.Adapter<FAQAdapter.ViewHolder> {
    private final Context context;
    private final ArrayList<FAQModel> faqArrList;

    public FAQAdapter(Context context, ArrayList<FAQModel> faqArrList){
        this.context = context;
        this.faqArrList = faqArrList;

    }

    @NonNull
    @Override
    public FAQAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.faq_listitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FAQAdapter.ViewHolder holder, int position) {
        FAQModel faq = faqArrList.get(position);

        holder.faqQ.setText(faq.getQuestion());
        holder.faqA.setText(faq.getAnswer());
    }

    @Override
    public int getItemCount() {
        return faqArrList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView faqQ;
        private final TextView faqA;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            faqQ = itemView.findViewById(R.id.faq_listitem_q);
            faqA = itemView.findViewById(R.id.faq_listitem_a);
        }
    }
}
