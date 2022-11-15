package com.example.skytel_mobileapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class FAQ extends AppCompatActivity {

    ActionBarDrawerToggle actionBarDrawerToggle;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    //array to add technical support questions
    String[] technicalSupport = new String[] {"technicalSupportOne", "technicalSupportTwo", "technicalSupportThree"};

    //array to add upgrade information questions
    String[] upgradeInfo = new String[] {"upgradeInfoOne", "upgradeInfoTwo", "upgradeInfoThree"};

    //array to add data bundles questions
    String[] dataBundles = new String[] {"dataBundlesOne", "dataBundlesTwo", "dataBundlesThree"};

    //array to add recharge account questions
    String[] rechargeAccount = new String[] {"rechargeAccountOne", "rechargeAccountTwo", "rechargeAccountThree"};

    //array to add general support questions
    String[] generalSupport = new String[] {"generalSupportOne", "generalSupportTwo", "generalSupportThree"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        //calling the adapter for technical support dropdown method (Farrell, 2016)
        setTechnicalSupport();

        //calling the adapter for upgrade information dropdown method (Farrell, 2016)
        setUpgradeInfo();

        //calling the adapter for data bundles dropdown method (Farrell, 2016)
        setDataBundles();

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

        //adapter for technical support questions
        Spinner techsupport = (Spinner) findViewById(R.id.techicalsupport);   //find spinner by the id

        //array adapter created to get information from the string array in the string view
        ArrayAdapter<String> myAdapt = new ArrayAdapter<String>(FAQ.this,
                android.R.layout.simple_list_item_1, technicalSupport);   //finding the array and layout of the dropdown menu

        myAdapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); //making the adapter a dropdown
        techsupport.setAdapter(myAdapt);   //setting the spinner to the adapter

    }

    //drop down method for upgrade information
    public void setUpgradeInfo() {
        /*
            adapter made to push data (in the array string ) from the strings view to the
            activity_main view so all options display on UI adapted and modified by Android Drop Down List Tutorial (2016).
            Link: https://www.youtube.com/watch?v=urQp7KsQhW8
         */

        //adapter for upgrade information questions
        Spinner upgradeinfo = (Spinner) findViewById(R.id.upgradeInfo);   //find spinner by the id

        //array adapter created to get information from the string array in the string view
        ArrayAdapter<String> myAdapt = new ArrayAdapter<String>(FAQ.this,
                android.R.layout.simple_list_item_1, upgradeInfo);   //finding the array and layout of the dropdown menu

        myAdapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); //making the adapter a dropdown
        upgradeinfo.setAdapter(myAdapt);   //setting the spinner to the adapter
    }

    //drop down method for data bundle FAQ
    public void setDataBundles() {
        /*
            adapter made to push data (in the array string ) from the strings view to the
            activity_main view so all options display on UI adapted and modified by Android Drop Down List Tutorial (2016).
            Link: https://www.youtube.com/watch?v=urQp7KsQhW8
         */

        //adapter for data bundle information questions
        Spinner databun = (Spinner) findViewById(R.id.databundles);   //find spinner by the id

        //array adapter created to get information from the string array in the string view
        ArrayAdapter<String> myAdapt = new ArrayAdapter<String>(FAQ.this,
                android.R.layout.simple_list_item_1, dataBundles);   //finding the array and layout of the dropdown menu

        myAdapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); //making the adapter a dropdown
        databun.setAdapter(myAdapt);   //setting the spinner to the adapter
    }

    //drop down method for recharge account FAQ
    public void setRechargeAccount() {
        /*
            adapter made to push data (in the array string ) from the strings view to the
            activity_main view so all options display on UI adapted and modified by Android Drop Down List Tutorial (2016).
            Link: https://www.youtube.com/watch?v=urQp7KsQhW8
         */

        //adapter for recharge account information questions
        Spinner rechaAcc = (Spinner) findViewById(R.id.rechargeAccount);   //find spinner by the id

        //array adapter created to get information from the string array in the string view
        ArrayAdapter<String> myAdapt = new ArrayAdapter<String>(FAQ.this,
                android.R.layout.simple_list_item_1, rechargeAccount);   //finding the array and layout of the dropdown menu

        myAdapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); //making the adapter a dropdown
        rechaAcc.setAdapter(myAdapt);   //setting the spinner to the adapter
    }

    //drop down method for general support
    public void setGeneralSupport() {
        /*
            adapter made to push data (in the array string ) from the strings view to the
            activity_main view so all options display on UI adapted and modified by Android Drop Down List Tutorial (2016).
            Link: https://www.youtube.com/watch?v=urQp7KsQhW8
         */

        //adapter for recharge account information questions
        Spinner genSup = (Spinner) findViewById(R.id.generalSupport);   //find spinner by the id

        //array adapter created to get information from the string array in the string view
        ArrayAdapter<String> myAdapt = new ArrayAdapter<String>(FAQ.this,
                android.R.layout.simple_list_item_1, generalSupport);   //finding the array and layout of the dropdown menu

        myAdapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); //making the adapter a dropdown
        genSup.setAdapter(myAdapt);   //setting the spinner to the adapter
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
            //Go to shopping list page (The IIE, 2022)
            Intent shopList = new Intent(Intent.ACTION_VIEW);
            shopList.setData(Uri.parse("https://www.mtn.co.za/home/coverage/"));
            startActivity(shopList);
        }
        //code modified by How to Get link in navigation Drawer in android studio 2020 (2020)
        //Link: https://www.youtube.com/watch?v=mMkUekK_wB8
        else if (id == R.id.specfications_nav) {
            //Go to Graph page
            Intent graphPage = new Intent(Intent.ACTION_VIEW);
            graphPage.setData(Uri.parse("https://www.gsmarena.com/"));
            startActivity(graphPage);
        }
        else if (id == R.id.aboutus_nav) {
            //Go to Graph page
            Intent graphPage = new Intent(this, AboutUs.class);
            startActivity(graphPage);
        }
        else if (id == R.id.contactus_nav) {
            //Go to Graph page
            Intent graphPage = new Intent(this, ContactUs.class);
            startActivity(graphPage);
        }
        else if (id == R.id.faq_nav) {
            //Go to Graph page
            Intent graphPage = new Intent(this, FAQ.class);
            startActivity(graphPage);
        }
        else if (id == R.id.querymessager_nav) {
            //Go to Graph page
            Intent graphPage = new Intent(this, MessageSystem.class);
            startActivity(graphPage);
        }


        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}