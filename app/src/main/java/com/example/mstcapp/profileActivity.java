package com.example.mstcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

public class profileActivity extends AppCompatActivity {

    ImageView userProfilePicture;
    EditText userName,userEmail,userRegNo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        userProfilePicture=findViewById(R.id.profilePicture);
        userName=findViewById(R.id.userName);
        userEmail=findViewById(R.id.userEmail);
        userRegNo=findViewById(R.id.userRegNo);


    }
}
