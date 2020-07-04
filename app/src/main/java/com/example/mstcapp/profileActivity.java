package com.example.mstcapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.mikhaellopez.circularimageview.CircularImageView;

public class profileActivity extends AppCompatActivity {

    private CircularImageView userProfilePicture;
    private EditText userName,userEmail,userRegNo,userDomain,userRoomNo,userPhoneNo;
    private Button btn_Logout;
    private FirebaseAuth mAuth;
    private DatabaseReference mRef;
    private ProgressBar mProgressCircular;
    private RelativeLayout relativeLayout;
    private FirebaseUser user;
    private StorageReference storeRef;
    private String mail;
    private String uEmail;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getWindow().setStatusBarColor(Color.WHITE);
        mProgressCircular=findViewById(R.id.progressBar);
        userProfilePicture=findViewById(R.id.profilePicture);
        userName=findViewById(R.id.userName);
        userEmail=findViewById(R.id.userEmail);
        userRegNo=findViewById(R.id.userRegNo);
        btn_Logout=findViewById(R.id.btn_logout);
        userRoomNo=findViewById(R.id.room_user);
        userDomain=findViewById(R.id.domain_user);
        userPhoneNo=findViewById(R.id.phone_user);
        relativeLayout=findViewById(R.id.rLayout);
        getWindow().setStatusBarColor(Color.WHITE);

        mAuth=FirebaseAuth.getInstance();
        user=mAuth.getCurrentUser();
        mail=user.getEmail();

        uEmail=mail.replace('.','_');

        storeRef= FirebaseStorage.getInstance().getReference().child("Profile Pictures").child(uEmail);

        storeRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(getApplicationContext()).load(uri).into(userProfilePicture);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(profileActivity.this, "Unable to download picture.", Toast.LENGTH_SHORT).show();
            }
        });

        mRef=FirebaseDatabase.getInstance().getReference("Users").child(uEmail);


        btn_Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                Intent intent =new Intent(getApplicationContext(),FirstActivity.class);
                intent.putExtra("Check",true);
                startActivity(intent);
                finish();
            }
        });

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String name=snapshot.child("userName").getValue().toString();
                userName.setText(name);
                String uMail=snapshot.child("userEmail").getValue().toString();
                userEmail.setText(uMail);
                String uRegNo=snapshot.child("userRegNo").getValue().toString();
                userRegNo.setText(uRegNo);
                String uRoomNo=snapshot.child("userRoom").getValue().toString();
                userRoomNo.setText(uRoomNo);
                String uPhone=snapshot.child("userPhone").getValue().toString();
                userPhoneNo.setText(uPhone);
                String uDomain=snapshot.child("userDomain").getValue().toString();
                userDomain.setText(uDomain);

                mProgressCircular.setVisibility(View.INVISIBLE);
                relativeLayout.setVisibility(View.VISIBLE);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                mProgressCircular.setVisibility(View.INVISIBLE);
            }
        });

    }
}
