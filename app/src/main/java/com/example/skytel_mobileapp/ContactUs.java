package com.example.skytel_mobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class ContactUs extends AppCompatActivity {

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

    }
}