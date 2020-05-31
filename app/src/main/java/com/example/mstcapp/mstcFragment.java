package com.example.mstcapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class mstcFragment extends Fragment {

    View mstcSubFragment;
    TabLayout tabLayout;
    ViewPager viewPager;

    public mstcFragment() {
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

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setUpViewPager(ViewPager viewPager) {
        //ADDING FRAGMENTS
        viewPagerAdapter adapter=new viewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new infoFragment(),"Info");
        adapter.addFragment(new boardFragment(),"Board");

        //ADAPTER SETUP
        viewPager.setAdapter(adapter);
    }
}
