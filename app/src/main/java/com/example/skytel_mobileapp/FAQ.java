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
import android.view.MenuItem;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.skytel_mobileapp.Models.FAQModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FAQ extends AppCompatActivity {

    ActionBarDrawerToggle actionBarDrawerToggle;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    DatabaseReference dbRef;

    TextView dataA, techA, upgradeA, rechargeA, generalA;

    ArrayList<FAQModel> techSupFAQs = new ArrayList<>();
    ArrayList<FAQModel> upgradeFAQs = new ArrayList<>();
    ArrayList<FAQModel> dataFAQs = new ArrayList<>();
    ArrayList<FAQModel> rechargeFAQs = new ArrayList<>();
    ArrayList<FAQModel> generalFAQs = new ArrayList<>();


    //array to add technical support questions
    ArrayList<String> technicalSupport = new ArrayList<>();

    //array to add upgrade information questions
    ArrayList<String> upgradeInfo = new ArrayList<>();

    //array to add data bundles questions
    ArrayList<String> dataBundles = new ArrayList<>();

    //array to add recharge account questions
    ArrayList<String> rechargeAccount = new ArrayList<>();

    //array to add general support questions
    ArrayList<String> generalSupport = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        dataA = findViewById(R.id.databundlesanswers);
        techA = findViewById(R.id.techsupportanswer);
        upgradeA = findViewById(R.id.upgradeInfoanswer);
        rechargeA = findViewById(R.id.rechargeAccountanswer);
        generalA = findViewById(R.id.generalSupportanswer);

        dbRef = FirebaseDatabase.getInstance().getReference().child("FAQ's");

        InitArrays();
    }

    private void InitArrays() {

        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ClearLists();
                for (DataSnapshot snap: snapshot.getChildren()) {

                    switch (snap.getKey()){
                        case "Data Bundles":
                            for (DataSnapshot data: snap.getChildren()) {
                                dataFAQs.add(data.getValue(FAQModel.class));
                                dataBundles.add(data.getValue(FAQModel.class).getQuestion());
                            }
                            break;
                        case "Technical Support":
                            for (DataSnapshot tech: snap.getChildren()) {
                                techSupFAQs.add(tech.getValue(FAQModel.class));
                                technicalSupport.add(tech.getValue(FAQModel.class).getQuestion());
                            }
                            break;
                        case "Upgrade Info":
                            for (DataSnapshot up: snap.getChildren()) {
                                upgradeFAQs.add(up.getValue(FAQModel.class));
                                upgradeInfo.add(up.getValue(FAQModel.class).getQuestion());
                            }
                            break;
                        case "General Support":
                            for (DataSnapshot gen: snap.getChildren()) {
                                generalFAQs.add(gen.getValue(FAQModel.class));
                                generalSupport.add(gen.getValue(FAQModel.class).getQuestion());
                            }
                            break;
                        case "Recharge Account":
                            for (DataSnapshot rec: snap.getChildren()) {
                                rechargeFAQs.add(rec.getValue(FAQModel.class));
                                rechargeAccount.add(rec.getValue(FAQModel.class).getQuestion());
                            }
                            break;
                    }

                }

                SetDropDownLists();


            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void ClearLists() {
        dataFAQs.clear();
        dataBundles.clear();
        techSupFAQs.clear();
        technicalSupport.clear();
        upgradeFAQs.clear();
        upgradeInfo.clear();
        generalSupport.clear();
        generalFAQs.clear();
        rechargeAccount.clear();
        rechargeFAQs.clear();
    }

    private void SetDropDownLists() {

        //calling the adapter for data bundles dropdown method (Farrell, 2016)
        setDataBundles();
        //calling the adapter for technical support dropdown method (Farrell, 2016)
        setTechnicalSupport();
        //calling the adapter for upgrade information dropdown method (Farrell, 2016)
        setUpgradeInfo();
        //calling the adapter for recharge account dropdown method (Farrell, 2016)
        setRechargeAccount();
        //calling the adapter for general support dropdown method (Farrell, 2016)
        setGeneralSupport();


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

    //drop down method for technical support
    public void setTechnicalSupport() {

        /*
            adapter made to push data (in the array string ) from the strings view to the
            activity_main view so all options display on UI adapted and modified by Android Drop Down List Tutorial (2016).
            Link: https://www.youtube.com/watch?v=urQp7KsQhW8
         */

        String[] tech = new String[]{technicalSupport.get(0), technicalSupport.get(1), technicalSupport.get(2) };

        //adapter for technical support questions
        Spinner techsupport = (Spinner) findViewById(R.id.techicalsupport);   //find spinner by the id

        //array adapter created to get information from the string array in the string view
        ArrayAdapter<String> myAdapt = new ArrayAdapter<String>(FAQ.this,
                android.R.layout.simple_list_item_1, tech);   //finding the array and layout of the dropdown menu

        myAdapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); //making the adapter a dropdown
        techsupport.setAdapter(myAdapt);   //setting the spinner to the adapter

        techsupport.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0: techA.setText(techSupFAQs.get(0).getAnswer());
                        break;
                    case 1: techA.setText(techSupFAQs.get(1).getAnswer());
                        break;
                    case 2: techA.setText(techSupFAQs.get(2).getAnswer());
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                techA.setText("Select a question");
            }
        });
    }

    //drop down method for upgrade information
    public void setUpgradeInfo() {
        /*
            adapter made to push data (in the array string ) from the strings view to the
            activity_main view so all options display on UI adapted and modified by Android Drop Down List Tutorial (2016).
            Link: https://www.youtube.com/watch?v=urQp7KsQhW8
         */

        String[] up =  new String[] {upgradeInfo.get(0), upgradeInfo.get(1), upgradeInfo.get(2)};

        //adapter for upgrade information questions
        Spinner upgradeinfo = (Spinner) findViewById(R.id.upgradeInfo);   //find spinner by the id

        //array adapter created to get information from the string array in the string view
        ArrayAdapter<String> myAdapt = new ArrayAdapter<String>(FAQ.this,
                android.R.layout.simple_list_item_1, up);   //finding the array and layout of the dropdown menu

        myAdapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); //making the adapter a dropdown
        upgradeinfo.setAdapter(myAdapt);   //setting the spinner to the adapter

        upgradeinfo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0: upgradeA.setText(upgradeFAQs.get(0).getAnswer());
                        break;
                    case 1: upgradeA.setText(upgradeFAQs.get(1).getAnswer());
                        break;
                    case 2: upgradeA.setText(upgradeFAQs.get(2).getAnswer());
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                upgradeA.setText("Select a question");
            }
        });
    }

    //drop down method for data bundle FAQ
    public void setDataBundles() {
        /*
            adapter made to push data (in the array string ) from the strings view to the
            activity_main view so all options display on UI adapted and modified by Android Drop Down List Tutorial (2016).
            Link: https://www.youtube.com/watch?v=urQp7KsQhW8
         */

        String[] db = new String[]{dataBundles.get(0), dataBundles.get(1), dataBundles.get(2) };

        //adapter for data bundle information questions
        Spinner databun = (Spinner) findViewById(R.id.databundles);   //find spinner by the id

        //array adapter created to get information from the string array in the string view
        ArrayAdapter<String> myAdapt = new ArrayAdapter<String>(FAQ.this,
                android.R.layout.simple_list_item_1, db);   //finding the array and layout of the dropdown menu

        myAdapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); //making the adapter a dropdown
        databun.setAdapter(myAdapt);   //setting the spinner to the adapter

        databun.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0: dataA.setText(dataFAQs.get(0).getAnswer());
                        break;
                    case 1: dataA.setText(dataFAQs.get(1).getAnswer());
                        break;
                    case 2: dataA.setText(dataFAQs.get(2).getAnswer());
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                dataA.setText("Select a question");
            }
        });
    }

    //drop down method for recharge account FAQ
    public void setRechargeAccount() {
        /*
            adapter made to push data (in the array string ) from the strings view to the
            activity_main view so all options display on UI adapted and modified by Android Drop Down List Tutorial (2016).
            Link: https://www.youtube.com/watch?v=urQp7KsQhW8
         */

        String[] rec = new String[] {rechargeAccount.get(0), rechargeAccount.get(1), rechargeAccount.get(2)};

        //adapter for recharge account information questions
        Spinner rechaAcc = (Spinner) findViewById(R.id.rechargeAccount);   //find spinner by the id

        //array adapter created to get information from the string array in the string view
        ArrayAdapter<String> myAdapt = new ArrayAdapter<String>(FAQ.this,
                android.R.layout.simple_list_item_1, rec);   //finding the array and layout of the dropdown menu

        myAdapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); //making the adapter a dropdown
        rechaAcc.setAdapter(myAdapt);   //setting the spinner to the adapter

        rechaAcc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0: rechargeA.setText(rechargeFAQs.get(0).getAnswer());
                        break;
                    case 1: rechargeA.setText(rechargeFAQs.get(1).getAnswer());
                        break;
                    case 2: rechargeA.setText(rechargeFAQs.get(2).getAnswer());
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                rechargeA.setText("Select a question");
            }
        });
    }

    //drop down method for general support
    public void setGeneralSupport() {
        /*
            adapter made to push data (in the array string ) from the strings view to the
            activity_main view so all options display on UI adapted and modified by Android Drop Down List Tutorial (2016).
            Link: https://www.youtube.com/watch?v=urQp7KsQhW8
         */

        String[] gen = new String[] {generalSupport.get(0), generalSupport.get(1), generalSupport.get(2)};

        //adapter for recharge account information questions
        Spinner genSup = (Spinner) findViewById(R.id.generalSupport);   //find spinner by the id

        //array adapter created to get information from the string array in the string view
        ArrayAdapter<String> myAdapt = new ArrayAdapter<String>(FAQ.this,
                android.R.layout.simple_list_item_1, gen);   //finding the array and layout of the dropdown menu

        myAdapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); //making the adapter a dropdown
        genSup.setAdapter(myAdapt);   //setting the spinner to the adapter

        genSup.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0: generalA.setText(generalFAQs.get(0).getAnswer());
                        break;
                    case 1: generalA.setText(generalFAQs.get(1).getAnswer());
                        break;
                    case 2: generalA.setText(generalFAQs.get(2).getAnswer());
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                generalA.setText("Select a question");
            }
        });
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
    }

}