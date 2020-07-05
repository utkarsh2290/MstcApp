package com.example.mstcapp.navbarFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.mstcapp.adapters.highlightsAdapter;
import com.example.mstcapp.R;
import com.example.mstcapp.highlightsFragment.eventsFragments;
import com.example.mstcapp.highlightsFragment.githubFragment;
import com.example.mstcapp.highlightsFragment.projectFragment;
import com.google.android.material.tabs.TabLayout;

public class highlightsFragment extends Fragment {


    View onlineSubFragment;
    TabLayout tabLayout2;
    ViewPager viewPager2;

    public highlightsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        onlineSubFragment=inflater.inflate(R.layout.fragment_highlight,container,false);

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
        highlightsAdapter adapter=new highlightsAdapter(getChildFragmentManager());
        adapter.addFragment(new eventsFragments(),"Events");
        adapter.addFragment(new projectFragment(),"Projects");
        adapter.addFragment(new githubFragment(),"Github");

        //ADAPTER SETUP
        viewPager2.setAdapter(adapter);
    }
}
