package com.example.mstcapp.resourcespage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mstcapp.R;
import com.example.mstcapp.adapters.ViewpagerResAdapter;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

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

        ViewpagerResAdapter adapter=new ViewpagerResAdapter(getSupportFragmentManager());
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