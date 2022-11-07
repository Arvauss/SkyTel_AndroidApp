package com.example.skytel_mobileapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import android.widget.Toast;

import com.example.skytel_mobileapp.Models.ContactUsModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ContactUs extends AppCompatActivity {
    TextView tv1, tv2, tv3, tv4;
    ArrayList<ContactUsModel> cmList = new ArrayList<>();
    DatabaseReference dbRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        //LINK FOR LEGAL
        ((TextView) findViewById(R.id.legalLink)).setMovementMethod(LinkMovementMethod.getInstance());
        ((TextView) findViewById(R.id.legalLink)).setText(Html.fromHtml(getResources().getString(R.string.LEGAL)));

        //LINK FOR PRIVACY POLICY
        ((TextView) findViewById(R.id.privacypolicylink)).setMovementMethod(LinkMovementMethod.getInstance());
        ((TextView) findViewById(R.id.privacypolicylink)).setText(Html.fromHtml(getResources().getString(R.string.PRIVACY_POLICY)));

        //LINK FOR T'S AND C'S
        ((TextView) findViewById(R.id.tcandcslink)).setMovementMethod(LinkMovementMethod.getInstance());
        ((TextView) findViewById(R.id.tcandcslink)).setText(Html.fromHtml(getResources().getString(R.string.TC)));

        InitUI();

    }

    private void InitUI() {
        tv1 = (TextView) findViewById(R.id.textinfo1);
        tv2 = (TextView) findViewById(R.id.textinfo2);
        tv3 = (TextView) findViewById(R.id.textinfo3);
        tv4 = (TextView) findViewById(R.id.textinfo4);

        dbRef = FirebaseDatabase.getInstance().getReference().child("ContactUs");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snap: snapshot.getChildren()) {
                    cmList.add(snap.getValue(ContactUsModel.class));
                }
                if (cmList.size() == 4){
                    tv1.setText("Contact: " + cmList.get(0).getTitle() + "\nContact Number: " + cmList.get(0).getContactNum());
                    tv2.setText("Contact: " + cmList.get(1).getTitle() + "\nContact Number: " + cmList.get(1).getContactNum());
                    tv3.setText("Contact: " + cmList.get(2).getTitle() + "\nContact Number: " + cmList.get(2).getContactNum());
                    tv4.setText("Contact: " + cmList.get(3).getTitle() + "\nContact Number: " + cmList.get(3).getContactNum());
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}