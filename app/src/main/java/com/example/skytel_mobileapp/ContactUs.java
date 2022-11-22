package com.example.skytel_mobileapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;
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


    ActionBarDrawerToggle actionBarDrawerToggle;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

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


        //navigation bar setup
        // drawer layout instance to toggle the menu icon to open (The IIE, 2022)
        //drawer and back button to close drawer (geeksforgeeks.org, 2022).
        drawerLayout = findViewById(R.id.drawer_Layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        //Instantiating burgerNavigationView and binding it to view (Pulak, 2017).
        navigationView = findViewById(R.id.nav_view);

        //Setting navigation item listener (Pulak, 2017).
        navigationView.setNavigationItemSelectedListener(this::onNavigationItemSelected);

        // pass the Open and Close toggle for the drawer layout listener (The IIE, 2022)
        // to toggle the button (geeksforgeeks.org, 2022).
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // to make the Navigation drawer icon always appear on the action bar (geeksforgeeks.org, 2022).
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    //Method to handle the OnCLicked events within the burger menu (Pulak, 2017)
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here (The IIE, 2022)
        int id = item.getItemId();

        if (id == R.id.yellotrader_nav) {
            //Go to dashboard (The IIE, 2022)
            Intent dashB = new Intent(this, YelloPageDisplay.class);
            startActivity(dashB);
        }
        //code modified by How to Get link in navigation Drawer in android studio 2020 (2020)
        //Link: https://www.youtube.com/watch?v=mMkUekK_wB8
        else if (id == R.id.coveragemap_nav) {
            //Go to Coverage map (The IIE, 2022)
            Intent CoverMap = new Intent(Intent.ACTION_VIEW);
            CoverMap.setData(Uri.parse("https://www.mtn.co.za/home/coverage/"));
            startActivity(CoverMap);
        }
        //code modified by How to Get link in navigation Drawer in android studio 2020 (2020)
        //Link: https://www.youtube.com/watch?v=mMkUekK_wB8
        else if (id == R.id.specfications_nav) {
            //Go to specifications page
            Intent Specs = new Intent(Intent.ACTION_VIEW);
            Specs.setData(Uri.parse("https://www.gsmarena.com/"));
            startActivity(Specs);
        }
        else if (id == R.id.aboutus_nav) {
            //Go to AboutUs page
            Intent about = new Intent(this, AboutUs.class);
            startActivity(about);
        }
        else if (id == R.id.contactus_nav) {
            //Go to ContactUs page
            Intent contact = new Intent(this, ContactUs.class);
            startActivity(contact);
        }
        else if (id == R.id.faq_nav) {
            //Go to FAQ page
            Intent faq = new Intent(this, FAQ.class);
            startActivity(faq);
        }
        else if (id == R.id.querymessager_nav) {
            //Go to messages page
            Intent msg = new Intent(this, MessageSystem.class);
            startActivity(msg);
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
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