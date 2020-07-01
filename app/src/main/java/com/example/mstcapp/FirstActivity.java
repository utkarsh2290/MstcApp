package com.example.mstcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class FirstActivity extends AppCompatActivity {

    public static final String SHARED_PREFS ="sharedprefs";

    private Button btn_nonStc,btn_Stc_member;
    Boolean check=false;
    private LinearLayout btn_layout;
    private RelativeLayout relativeLayout;
    private Handler mhandler= new Handler();
    FirebaseAuth firebaseAuth_initial;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Intent intent= getIntent();
        boolean check = intent.getBooleanExtra("check",false);
        if(check){
            onBackPressed();
        }

        firebaseAuth_initial=FirebaseAuth.getInstance();
        if(firebaseAuth_initial.getCurrentUser()!=null){
            startActivity(new Intent(FirstActivity.this,MainActivity.class));
            finish();
        }

        SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        final SharedPreferences.Editor editor=sharedPreferences.edit();
        if(sharedPreferences.getBoolean(SHARED_PREFS,false)==true){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }

        //INITIALIZING VIEWS
        btn_nonStc=findViewById(R.id.nonStcMember);
        btn_Stc_member=findViewById(R.id.stcMember);
        btn_layout=findViewById(R.id.btn_holder);
        relativeLayout=findViewById(R.id.layout_holder);
        relativeLayout.setVisibility(View.GONE);
        btn_layout.setVisibility(View.GONE);
        mhandler.postDelayed(mLayoutRunnable,750);

        btn_Stc_member.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FirstActivity.this,LoginActivity.class));

            }
        });

        btn_nonStc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putBoolean(SHARED_PREFS,true).apply();
                startActivity(new Intent(FirstActivity.this,MainActivity.class));
                finish();
            }
        });
    }


    //MAKING BUTTONS INVISIBLE FOR 3 SEC
    private Runnable mLayoutRunnable = new Runnable() {
        @Override
        public void run() {
            relativeLayout.setVisibility(View.VISIBLE);
            mhandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    btn_layout.setVisibility(View.VISIBLE);
                }
            }, 2000);
        }
    };
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}
