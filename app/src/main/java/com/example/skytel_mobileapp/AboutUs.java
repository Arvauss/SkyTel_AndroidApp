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

public class AboutUs extends AppCompatActivity {

    ActionBarDrawerToggle actionBarDrawerToggle;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

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
    }
}