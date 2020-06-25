package com.example.mstcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    private Button btn_nonStc,btn_Stc_member;
    private LinearLayout btn_layout;
    private RelativeLayout relativeLayout;
    private Handler mhandler= new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

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
                startActivity(new Intent(FirstActivity.this,MainActivity.class));
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

}
