package com.example.mstcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class profileActivity extends AppCompatActivity {

    ImageView userProfilePicture;
    EditText userName,userEmail,userRegNo;
    private Button btn_Logout;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        userProfilePicture=findViewById(R.id.profilePicture);
        userName=findViewById(R.id.userName);
        userEmail=findViewById(R.id.userEmail);
        userRegNo=findViewById(R.id.userRegNo);
        btn_Logout=findViewById(R.id.btn_logout);

        mAuth=FirebaseAuth.getInstance();

        btn_Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                finish();
            }
        });

    }
}
