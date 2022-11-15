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
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class YelloPageDisplay extends AppCompatActivity {

    ActionBarDrawerToggle actionBarDrawerToggle;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yello_page_display);

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