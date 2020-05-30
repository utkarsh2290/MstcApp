package com.example.mstcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class ResourcesAndroid extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources_android);

        Intent i =getIntent();
        String test= i.getStringExtra("test");

        Toast.makeText(getApplicationContext(),test+" On activity resrces",Toast.LENGTH_SHORT).show();
    }
}