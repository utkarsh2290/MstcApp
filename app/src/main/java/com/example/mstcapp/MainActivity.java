package com.example.mstcapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.mstcapp.navbarFragments.exclusiveFragment;
import com.example.mstcapp.navbarFragments.feedFragment;
import com.example.mstcapp.navbarFragments.resourcesFragment;
import com.example.mstcapp.navbarFragments.onlineFootprintFragment;

import com.example.mstcapp.navbarFragments.aboutUsFragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.mikhaellopez.circularimageview.CircularImageView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView,bottomNavigationView_ex;
    TextView appbar_title;
    AppBarLayout appBarLayout_main;
    ImageButton stc_logo;
    FirebaseAuth firebaseAuth;

    FirebaseUser user;
    StorageReference storeRef;
    String mail;
    String uEmail;
    boolean nav_check=false;
    CircularImageView profilePic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setStatusBarColor(Color.WHITE);

        stc_logo=findViewById(R.id.stclogo_appbar);
        profilePic=findViewById(R.id.profilePic);
        appBarLayout_main=findViewById(R.id.appbar_layout);
        appbar_title=findViewById(R.id.appbar_title);
        bottomNavigationView = findViewById(R.id.navigation_bottom);
        bottomNavigationView_ex=findViewById(R.id.navigation_bottom);

        profilePic.setVisibility(View.INVISIBLE);
        Intent intent=getIntent();
        nav_check=intent.getBooleanExtra("NAV_CHECK",false);
        Log.i("CHECK"," "+nav_check);

        firebaseAuth=FirebaseAuth.getInstance();
        if(nav_check==true){
            bottomNavigationView_ex.inflateMenu(R.menu.bottom_navbar_five);
            bottomNavigationView_ex.setOnNavigationItemSelectedListener(navigationItemSelectedListener_ex);
            user=firebaseAuth.getCurrentUser();
            mail=user.getEmail();
            uEmail=mail.replace('.','_');
            storeRef= FirebaseStorage.getInstance().getReference().child("Profile Pictures").child(uEmail);
            storeRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {

                    stc_logo.setVisibility(View.INVISIBLE);
                    profilePic.setVisibility(View.VISIBLE);
                    Glide.with(getApplicationContext()).load(uri).into(profilePic);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(MainActivity.this, "Unable to download picture.", Toast.LENGTH_SHORT).show();
                }
            });
        }
        else
        {
            bottomNavigationView.inflateMenu(R.menu.bottom_navbar);
            bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
            stc_logo.setEnabled(false);
        }
        profilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),profileActivity.class));
            }
        });



        //IF NO BUTTON IS SELECTED, FEED WILL BE SHOWN
        // for the nav bar to have filled icon at the start
        if (savedInstanceState == null) {
            Menu menu=bottomNavigationView.getMenu();
            menu.findItem(R.id.nav_home).setIcon(R.drawable.ic_home);
            appbar_title.setText("HOME");
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new feedFragment()).commit();
        }
        stc_logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),profileActivity.class));
            }
        });
    }


    //navbar for non mstc users
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull final MenuItem item) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
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
                                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                            new feedFragment()).addToBackStack(null).commit();
                                    break;
                                case R.id.nav_resources:
                                    item.setIcon(R.drawable.ic_resources);
                                    appbar_title.setText("RESOURCES");
                                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                            new resourcesFragment()).addToBackStack(null).commit();

                                    break;
                                case R.id.nav_archive:
                                    item.setIcon(R.drawable.ic_highlights);
                                    appbar_title.setText("HIGHLIGHTS");
                                    appBarLayout_main.setElevation(0);
                                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                            new onlineFootprintFragment()).addToBackStack(null).commit();

                                    break;
                                case R.id.nav_info:
                                    appbar_title.setText("INFORMATION");
                                    item.setIcon(R.drawable.ic_info);
                                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                            new aboutUsFragment()).addToBackStack(null).commit();

                                    break;
                            }
                        }
                    },200);
                    return true;
                }
            };
    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener_ex=
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull final MenuItem item) {
                   new Handler().postDelayed(new Runnable() {
                       @Override
                       public void run() {
                           Menu menu=bottomNavigationView.getMenu();
                           menu.findItem(R.id.nav_home).setIcon(R.drawable.ic_home_unfilled);
                           menu.findItem(R.id.nav_resources).setIcon(R.drawable.ic_resources__unfilled);
                           menu.findItem(R.id.nav_archive).setIcon(R.drawable.ic_highlights_unfilled);
                           menu.findItem(R.id.nav_info).setIcon(R.drawable.ic_info_unfilled);
                           menu.findItem(R.id.nav_exclusive).setIcon(R.drawable.ic_mstc_exclusive_unfilled);

                           Fragment selectedFragment = null;
                           switch (item.getItemId()) {
                               case R.id.nav_home:
                                   item.setIcon(R.drawable.ic_home);
                                   getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                           new feedFragment()).addToBackStack(null).commit();
                                   appbar_title.setText("HOME");
                                   break;
                               case R.id.nav_resources:
                                   item.setIcon(R.drawable.ic_resources);
                                   getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                           new resourcesFragment()).addToBackStack(null).commit();
                                   appbar_title.setText("RESOURCES");
                                   break;
                               case R.id.nav_archive:
                                   item.setIcon(R.drawable.ic_highlights);
                                   appBarLayout_main.setElevation(0);
                                   getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                           new onlineFootprintFragment()).addToBackStack(null).commit();
                                   appbar_title.setText("HIGHLIGHTS");
                                   break;
                               case R.id.nav_exclusive:
                                   item.setIcon(R.drawable.ic_mstc_exclusive);
                                   appBarLayout_main.setElevation(0);
                                   getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                           new exclusiveFragment()).addToBackStack(null).commit();
                                   appbar_title.setText("DETAILS");
                                   break;
                               case R.id.nav_info:
                                   item.setIcon(R.drawable.ic_info);
                                   getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                           new aboutUsFragment()).addToBackStack(null).commit();
                                   appbar_title.setText("INFORMATION");
                                   break;
                           }
                       }
                   },100);
                    return true;
                }
            };

}
