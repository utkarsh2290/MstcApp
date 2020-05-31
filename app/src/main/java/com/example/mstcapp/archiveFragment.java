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

public class archiveFragment extends Fragment {


    View onlineSubFragment;
    TabLayout tabLayout2;
    ViewPager viewPager2;

    public archiveFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        onlineSubFragment=inflater.inflate(R.layout.fragment_archive,container,false);

        viewPager2=onlineSubFragment.findViewById(R.id.viewPager2);
        tabLayout2=onlineSubFragment.findViewById(R.id.tabLayout2);

        return onlineSubFragment;

    }

    //CALLING ON ACTIVITY CREATE METHOD

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setUpViewPager(viewPager2);
        tabLayout2.setupWithViewPager(viewPager2);

        tabLayout2.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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
        viewArchivePagerAdapter adapter=new viewArchivePagerAdapter(getChildFragmentManager());
        adapter.addFragment(new eventsFragments(),"Events");
        adapter.addFragment(new projectFragment(),"Projects");
        adapter.addFragment(new githubFragment()
                ,"Github Project");

        //ADAPTER SETUP
        viewPager2.setAdapter(adapter);
    }
}
