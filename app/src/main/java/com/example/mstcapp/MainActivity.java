package com.example.mstcapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.mstcapp.navbar.archiveFragment;
import com.example.mstcapp.navbar.feedFragment;
import com.example.mstcapp.navbar.mstcFragment;
import com.example.mstcapp.navbar.resourcesFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    TextView appbar_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appbar_title=findViewById(R.id.appbar_title);
        bottomNavigationView = findViewById(R.id.navigation_bottom);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        // for the nav bar to have filled icon at the start
        if (savedInstanceState == null) {
            Menu menu=bottomNavigationView.getMenu();
            menu.findItem(R.id.nav_home).setIcon(R.drawable.ic_home);
            appbar_title.setText("HOME");
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new feedFragment()).commit();
        }
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
                            selectedFragment = new archiveFragment();
                            break;
                        case R.id.nav_info:
                            appbar_title.setText("INFORMATION");
                            item.setIcon(R.drawable.ic_profile1);
                            selectedFragment = new mstcFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();
                    return true;
                }
            };
}
