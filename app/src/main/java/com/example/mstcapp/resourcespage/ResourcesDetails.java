package com.example.mstcapp.resourcespage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.mstcapp.MainActivity;
import com.example.mstcapp.ParentFragments.aboutUsFragment;
import com.example.mstcapp.ParentFragments.onlineFootprintFragment;
import com.example.mstcapp.R;
import com.example.mstcapp.adapters.ViewpagerResAdapter;
import com.example.mstcapp.navbar.feedFragment;
import com.example.mstcapp.navbar.resourcesFragment;
import com.example.mstcapp.profileActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class ResourcesDetails extends AppCompatActivity {
    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;
    private TextView resappbar_title;
    ImageButton stc_logo;
    FirebaseUser user;
    StorageReference storeRef;
    FirebaseAuth firebaseAuth;
    String mail;
    String uEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources_details);
        resappbar_title=findViewById(R.id.resappbar_title);
        tabLayout=findViewById(R.id.tab_view_resources);
        viewPager=findViewById(R.id.viewpager_res);
        stc_logo=findViewById(R.id.stclogo_resappbar);

        firebaseAuth=FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser()!=null) {
            user = firebaseAuth.getCurrentUser();
            mail = user.getEmail();

            uEmail = mail.replace('.', '_');

            storeRef = FirebaseStorage.getInstance().getReference().child("Profile Pictures").child(uEmail);

            storeRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    Glide.with(getApplicationContext()).load(uri).into(stc_logo);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getApplicationContext(), "Unable to download picture.", Toast.LENGTH_SHORT).show();
                }
            });
            stc_logo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getApplicationContext(), profileActivity.class));
                }
            });
        }
        else {
            stc_logo.setEnabled(false);
        }

        //tab layout set up
        ViewpagerResAdapter adapter=new ViewpagerResAdapter(getSupportFragmentManager());
        adapter.addFragment(new roadmapFragment(),"Roadmap");
        adapter.addFragment(new resfolderFragment(),"Resources");
        adapter.addFragment(new articlelinksFragment(),"Articles");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

       //gets the intent recieved for  appbar title
        Intent i =getIntent();
        String test= i.getStringExtra("test");
        resappbar_title.setText(test);




    }
}