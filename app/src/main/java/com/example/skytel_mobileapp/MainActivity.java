package com.example.skytel_mobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.skytel_mobileapp.Adapters.DealAdapter;
import com.example.skytel_mobileapp.Models.Deal;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Deal> arrDealList = new ArrayList<Deal>();
    RecyclerView dealRV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitDeals();
    }

    //Temp... TODO: adjust to read from database
    public void InitDeals(){
        arrDealList.add(new Deal("Title 1", "Desc 1", null, null));
        arrDealList.add(new Deal("Title 2", "Desc 2", null, null));
        arrDealList.add(new Deal("Title 3", "Desc 3", null, null));

        InitRecycler();
    }

    public void InitRecycler(){
        dealRV = findViewById(R.id.cardviewfrontcov);
        DealAdapter adap = new DealAdapter(this, arrDealList);
        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        dealRV.setAdapter(adap);
        dealRV.setLayoutManager(llm);
    }
}