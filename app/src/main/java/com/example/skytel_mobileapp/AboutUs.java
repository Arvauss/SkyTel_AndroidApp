package com.example.skytel_mobileapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toolbar;
import android.widget.VideoView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.io.File;

public class AboutUs extends AppCompatActivity {

    ActionBarDrawerToggle actionBarDrawerToggle;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    DatabaseReference dbRef;
    StorageReference storRef;

    VideoView vidView;
    MediaController medC;
    ImageView img;
    TextView tvAbout;

    String vidUrl;
    String imgUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        vidView = findViewById(R.id.video);
        medC = new MediaController(AboutUs.this);
        img = findViewById(R.id.aboutusImg);
        tvAbout = findViewById(R.id.aboutuspic2);

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

        dbRef = FirebaseDatabase.getInstance().getReference();
        storRef = FirebaseStorage.getInstance().getReference("Media/");

        /*String path = getApplicationContext().getFilesDir().getAbsolutePath();
        File file = new File(path + "/YelloTrader-NovB-2022.pdf");*/

        /*UploadTask up = storRef.child("YelloTrader").putFile(Uri.fromFile(file));

        storRef.child("YelloTrader").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                dbRef.child("Media").child("YelloTrader").setValue(uri.toString());
            }
        });*/


        dbRef.child("Media").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot snap : snapshot.getChildren()){
                    if (snap.getKey().equals("AboutUsVideo"))
                        vidUrl = snap.getValue(String.class);

                    if (snap.getKey().equals("AboutUsPic"))
                        imgUrl = snap.getValue(String.class);
                    Log.d("123456", "onDataChange: " + vidUrl);
                }
                InitVideo();
                Picasso.get().load(imgUrl).resize(110,110).into(img);
                tvAbout.setText("SkyTel Mobile");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }

    public void InitVideo(){
        Uri vidUri = Uri.parse(vidUrl);

        vidView.setVideoURI(vidUri);



        medC.setAnchorView(vidView);

        medC.setMediaPlayer(vidView);

        vidView.setMediaController(medC);

        vidView.start();


        vidView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(0, 0);
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