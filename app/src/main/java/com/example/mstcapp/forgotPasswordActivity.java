package com.example.mstcapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;

public class forgotPasswordActivity extends AppCompatActivity {

    private EditText mResetEmail;
    private Button btn_reset;
    private FirebaseAuth mAuth;
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        mResetEmail=findViewById(R.id.resetEmail);
        btn_reset=findViewById(R.id.btn_reset);
        relativeLayout=findViewById(R.id.parentLayout);
        mAuth=FirebaseAuth.getInstance();

        if(mAuth.getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mResetEmail.getText().toString().trim();
                if(email!=null && !email.isEmpty()) {
                    mAuth.sendPasswordResetEmail(email).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @SuppressLint("ResourceAsColor")
                        @Override
                        public void onSuccess(Void aVoid) {
                            final Snackbar snackbar = Snackbar.make(relativeLayout, "Reset Link sent to your email!", Snackbar.LENGTH_INDEFINITE);
                            snackbar.setAction("Okay", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    snackbar.dismiss();
                                }
                            });
                            snackbar.setActionTextColor(Color.WHITE);
                            snackbar.show();

                        }

                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            final Snackbar snackbar = Snackbar.make(relativeLayout, "Unable to send reset link to your email", Snackbar.LENGTH_INDEFINITE);
                        }
                    });

                }
                else{
                    Toast.makeText(getApplicationContext(),"Email must be entered.",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}




