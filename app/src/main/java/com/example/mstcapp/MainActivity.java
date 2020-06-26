package com.example.mstcapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Button;

import com.example.mstcapp.navbar.feedFragment;
import com.example.mstcapp.navbar.resourcesFragment;
import com.example.mstcapp.ParentFragments.onlineFootprintFragment;

import com.example.mstcapp.ParentFragments.aboutUsFragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    TextView appbar_title;
    ImageButton stc_logo;
    private Button login,logout;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appbar_title=findViewById(R.id.appbar_title);
        bottomNavigationView = findViewById(R.id.navigation_bottom);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        stc_logo=findViewById(R.id.stclogo_appbar);

        firebaseAuth=FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser()!=null){

        }

        //IF NO BUTTON IS SELECTED, FEED WILL BE SHOWN
        // for the nav bar to have filled icon at the start
        if (savedInstanceState == null) {
            Menu menu=bottomNavigationView.getMenu();
            menu.findItem(R.id.nav_home).setIcon(R.drawable.ic_home);
            appbar_title.setText("HOME");
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new feedFragment()).commit();
        }


        //TAKING MSTC USERS ONTO PROFILE PAGE
        stc_logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),profileActivity.class));
                finish();
            }
        });
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Menu menu=bottomNavigationView.getMenu();
                    menu.findItem(R.id.nav_home).setIcon(R.drawable.ic_home_unfilled);
                    menu.findItem(R.id.nav_resources).setIcon(R.drawable.ic_resources__unfilled);
                    menu.findItem(R.id.nav_archive).setIcon(R.drawable.ic_highlights_unfilled);
                    menu.findItem(R.id.nav_info).setIcon(R.drawable.ic_info_unfilled);

                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            item.setIcon(R.drawable.ic_home);
                            appbar_title.setText("HOME");
                            selectedFragment = new feedFragment();
                            break;
                        case R.id.nav_resources:
                            item.setIcon(R.drawable.ic_resources);
                            appbar_title.setText("RESOURCES");
                            selectedFragment = new resourcesFragment();
                            break;
                        case R.id.nav_archive:
                            item.setIcon(R.drawable.ic_highlights);
                            appbar_title.setText("HIGHLIGHTS");
                            selectedFragment = new onlineFootprintFragment();
                            break;
                        case R.id.nav_info:
                            appbar_title.setText("INFORMATION");
                            item.setIcon(R.drawable.ic_profile1);
                            selectedFragment = new aboutUsFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();
                    return true;
                }
            };
}