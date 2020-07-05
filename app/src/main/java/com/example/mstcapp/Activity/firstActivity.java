package com.example.mstcapp.Activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.mstcapp.R;
import com.google.firebase.auth.FirebaseAuth;

public class firstActivity extends Activity {

    public static final String SHARED_PREFS ="sharedprefs";

    private Button btn_nonStc,btn_Stc_member;
    Boolean check=false;
    private LinearLayout btn_layout;
    private RelativeLayout relativeLayout;
    private Handler mhandler= new Handler();
    FirebaseAuth firebaseAuth_initial;
    boolean nav=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        getWindow().setStatusBarColor(Color.BLACK);
        Intent intent= getIntent();
        boolean check = intent.getBooleanExtra("check",false);
        if(check){
            onBackPressed();
        }

        firebaseAuth_initial=FirebaseAuth.getInstance();
        if(firebaseAuth_initial.getCurrentUser()!=null){
            Intent i= new Intent(getApplicationContext(), MainActivity.class);
            nav=true;
            i.putExtra("NAV_CHECK",nav);
            startActivity(i);
            Log.i("Check1",nav+"");
            finish();
        }

        SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        final SharedPreferences.Editor editor=sharedPreferences.edit();
        if(sharedPreferences.getBoolean(SHARED_PREFS,false)==true){
            Intent i= new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
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
                startActivity(new Intent(firstActivity.this, loginActivity.class));
                finish();

            }
        });

        btn_nonStc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putBoolean(SHARED_PREFS,true).apply();
                Intent i= new Intent(getApplicationContext(), MainActivity.class);
                i.putExtra("NAV",false);
                startActivity(i);
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
