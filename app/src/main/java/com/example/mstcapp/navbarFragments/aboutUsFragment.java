package com.example.mstcapp.navbarFragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.mstcapp.adapters.aboutPagerAdapter;
import com.example.mstcapp.R;
import com.example.mstcapp.aboutFragment.*;
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
        View firstTab = ((ViewGroup)    tabLayout.getChildAt(0)).getChildAt(0);
        View secondTab = ((ViewGroup) tabLayout.getChildAt(0)).getChildAt(1);
        tabLayout.setSelectedTabIndicatorHeight(0);
        firstTab.setSelected(true);
        secondTab.setSelected(false);

        firstTab.setBackground(getResources().getDrawable(R.drawable.tab_left_select));
        secondTab.setBackground(getResources().getDrawable(R.drawable.tab_right_unselect));
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
                int selectedTabPosition = tab.getPosition();
                tabLayout.setSelectedTabIndicatorHeight(0);

                View firstTab = ((ViewGroup)    tabLayout.getChildAt(0)).getChildAt(0);
                View secondTab = ((ViewGroup) tabLayout.getChildAt(0)).getChildAt(1);

                firstTab.setSelected(true);
                secondTab.setSelected(false);

                firstTab.setBackground(getResources().getDrawable(R.drawable.tab_left_select));
                secondTab.setBackground(getResources().getDrawable(R.drawable.tab_right_unselect));
                if (selectedTabPosition == 0)
                { // that means first tab
                    firstTab.setBackground(getResources().getDrawable(R.drawable.tab_left_select));
                    secondTab.setBackground(getResources().getDrawable(R.drawable.tab_right_unselect));


                } else if (selectedTabPosition == 1)
                { // that means it's a last tab

                    firstTab.setBackground(getResources().getDrawable(R.drawable.tab_left_unselect));
                    secondTab.setBackground(getResources().getDrawable(R.drawable.tab_right_select));


                }
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
