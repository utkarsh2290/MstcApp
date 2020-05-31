package com.example.mstcapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import java.lang.invoke.ConstantCallSite;

public class ResourcesDetails extends AppCompatActivity {
    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources_details);


        textView=findViewById(R.id.title);
        tabLayout=findViewById(R.id.tab_view_resources);
        viewPager=findViewById(R.id.viewpager_res);

        ViewpagerResources adapter=new ViewpagerResources(getSupportFragmentManager());
        adapter.addFragment(new roadmapFragment(),"Roadmap");
        adapter.addFragment(new resfolderFragment(),"Resources");
        adapter.addFragment(new articlelinksFragment(),"Articles");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


        Intent i =getIntent();
        String test= i.getStringExtra("test");
        Toast.makeText(getApplicationContext(),test+"Resources",Toast.LENGTH_SHORT).show();
        textView.setText(test);



    }
}