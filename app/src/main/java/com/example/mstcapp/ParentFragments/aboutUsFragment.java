package com.example.mstcapp.ParentFragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.mstcapp.adapters.aboutPagerAdapter;
import com.example.mstcapp.R;
import com.example.mstcapp.aboutFragment.boardFragment;
import com.example.mstcapp.aboutFragment.infoFragment;
import com.google.android.material.tabs.TabLayout;

public class aboutUsFragment extends Fragment {

    private View mstcSubFragment;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Button mstc_insta;
    private Button mstc_linkedin;
    private Button mstc_facebook;
    private Button mstc_medium;
    private LinearLayout container;

    public aboutUsFragment() {
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mstc_insta=view.findViewById(R.id.button_instagram);
        mstc_linkedin=view.findViewById(R.id.button_linkedin);
        mstc_facebook=view.findViewById(R.id.button_facebook);
        mstc_medium=view.findViewById(R.id.button_medium);
        container = view.findViewById(R.id.fragment_container);

        mstc_insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData((Uri.parse("https://www.instagram.com/mstcvit/")));
                startActivity(intent);
            }
        });

        mstc_linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData((Uri.parse("https://www.linkedin.com/company/micvitvellore/")));
                startActivity(intent);
            }
        });

        mstc_facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData((Uri.parse("https://www.facebook.com/mstcvit/")));
                startActivity(intent);
            }
        });

        mstc_medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData((Uri.parse("https://medium.com/student-technical-community-vit-vellore")));
                startActivity(intent);
            }
        });

        //replaceFragment(new infoFragment());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mstcSubFragment=inflater.inflate(R.layout.fragment_mstc,container,false);
        viewPager=mstcSubFragment.findViewById(R.id.viewPager);
        tabLayout=mstcSubFragment.findViewById(R.id.tabLayout);

        return mstcSubFragment;
    }

    //CALLING ON ACTIVITY CREATE METHOD

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition(), false);
             /*   if (tab.getPosition() == 0) {
                    replaceFragment(new infoFragment());
                } else if (tab.getPosition() == 1) {
                    replaceFragment(new boardFragment());
                }*/
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

                }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

   /* private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, new boardFragment());

        transaction.commit();
    }*/


    private void setUpViewPager(ViewPager viewPager) {
        //ADDING FRAGMENTS
        aboutPagerAdapter adapter=new aboutPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new infoFragment(),"Info");
        adapter.addFragment(new boardFragment(),"Board");

        //ADAPTER SETUP
        viewPager.setAdapter(adapter);
    }
}
