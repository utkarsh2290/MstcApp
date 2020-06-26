package com.example.mstcapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Button;

import com.example.mstcapp.navbar.exclusiveFragment;
import com.example.mstcapp.navbar.feedFragment;
import com.example.mstcapp.navbar.resourcesFragment;
import com.example.mstcapp.ParentFragments.onlineFootprintFragment;

import com.example.mstcapp.ParentFragments.aboutUsFragment;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    TextView appbar_title;
    AppBarLayout appBarLayout_main;

    private Button login,logout;
    FirebaseAuth firebaseAuth;
    public int x=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appBarLayout_main=findViewById(R.id.appbar_layout);
        appbar_title=findViewById(R.id.appbar_title);
        bottomNavigationView = findViewById(R.id.navigation_bottom);
        if(x==1){
            bottomNavigationView.inflateMenu(R.menu.bottom_navbar_five);
        }
        else
        {
            bottomNavigationView.inflateMenu(R.menu.bottom_navbar);
        }
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);


        //IF NO BUTTON IS SELECTED, FEED WILL BE SHOWN
        // for the nav bar to have filled icon at the start
        if (savedInstanceState == null) {
            Menu menu=bottomNavigationView.getMenu();
            menu.findItem(R.id.nav_home).setIcon(R.drawable.ic_home);
            appbar_title.setText("HOME");
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new feedFragment()).commit();
        }
    }



    //navbar for non mstc users
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
                        case R.id.nav_exclusive:
                            item.setIcon(R.drawable.ic_mstc_exclusive);
                            appbar_title.setText("DETAILS");
                            appBarLayout_main.setElevation(0);
                            selectedFragment=new exclusiveFragment();
                            break;
                        case R.id.nav_info:
                            appbar_title.setText("INFORMATION");
                            item.setIcon(R.drawable.ic_info);
                            selectedFragment = new aboutUsFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();
                    return true;
                }
            };
}
