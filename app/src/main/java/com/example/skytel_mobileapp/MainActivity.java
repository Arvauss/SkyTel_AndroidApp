package com.example.skytel_mobileapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.skytel_mobileapp.Adapters.DealAdapter;
import com.example.skytel_mobileapp.Models.Deal;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Deal> arrDealList = new ArrayList<Deal>();
    RecyclerView dealRV;
    private DatabaseReference dbRef;
    private FirebaseStorage fbStorage;
    private StorageReference storRef;
 //   private FirebaseAuth Auth;
   // private FirebaseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbRef = FirebaseDatabase.getInstance().getReference();




        InitDeals();
    }

    //Temp... TODO: adjust to read from database
    public void InitDeals(){

        DatabaseReference dealsRef = dbRef.child("Deals");

        dealsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                arrDealList.clear();
                for (DataSnapshot snap: snapshot.getChildren()) {
                    Deal d = snap.getValue(Deal.class);
                    arrDealList.add(d);
                }
                InitRecycler();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void InitRecycler(){
        dealRV = findViewById(R.id.cardviewfrontcov);
        DealAdapter adap = new DealAdapter(this, arrDealList);
        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        dealRV.setAdapter(adap);
        dealRV.setLayoutManager(llm);
    }
}