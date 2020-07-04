package com.example.mstcapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends Activity {

    private EditText mUserEmail, mUserPassword;
    private Button mUserLogin;
    TextView mForgotPassword;
    private FirebaseAuth mAuth;
    private int clickcount=0;
    boolean nav_login=false;
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setStatusBarColor(Color.BLACK);

        //INITIALIZING VIEWS
        mUserEmail = findViewById(R.id.loginEmail);
        mUserPassword = findViewById(R.id.loginPassword);
        mUserLogin = findViewById(R.id.btn_Login);
        mForgotPassword = findViewById(R.id.forgotPassword);

        mAuth = FirebaseAuth.getInstance();

        if (mAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

            mUserLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //CHECKING FIELDS
                    if(clickcount==0){
                        String email = mUserEmail.getText().toString().trim();
                        String password = mUserPassword.getText().toString().trim();

                        if (TextUtils.isEmpty(email)) {
                            mUserEmail.setError("Email is Required.");
                            return;
                        }

                        if (TextUtils.isEmpty(password)) {
                            mUserPassword.setError("Password is Required.");
                            return;
                        }

                        if (password.length() < 6) {
                            mUserPassword.setError("Password Must be >= 6 Characters");
                            return;
                        }

                        //REGISTERING USER ON FIREBASE

                        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    nav_login=true;
                                    Toast.makeText(LoginActivity.this, "Login Successful.", Toast.LENGTH_SHORT).show();
                                    Intent i= new Intent(getApplicationContext(),MainActivity.class);
                                    i.putExtra("NAV_CHECK",true);
                                    startActivity(i);
                                    Log.i("Check2",nav_login+"");
                                    finish();

                                } else {
                                    Toast.makeText(LoginActivity.this, "Unable to Login" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                        clickcount=1;
                    }
                    else if(clickcount==1){
                        mUserLogin.setEnabled(false);
                    }


                }
            });

        mForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),forgotPasswordActivity.class));
            }
        });
    }
}
