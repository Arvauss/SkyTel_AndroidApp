package com.example.skytel_mobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class FAQ extends AppCompatActivity {

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
}