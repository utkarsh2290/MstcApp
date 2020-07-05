package com.example.mstcapp.navbarFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.mstcapp.exclusiveFragments.fragmentAttendance;
import com.example.mstcapp.exclusiveFragments.fragmentMOM;
import com.example.mstcapp.exclusiveFragments.fragmentUpdates;
import com.example.mstcapp.R;
import com.example.mstcapp.adapters.ViewPagerExclusiveAdapter;
import com.google.android.material.tabs.TabLayout;

public class exclusiveFragment extends Fragment {
    TabLayout tabLayout_exclusive;
    ViewPager viewPager_exclusive;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_exclusive,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabLayout_exclusive=view.findViewById(R.id.tab_view_exclusives);
        viewPager_exclusive=view.findViewById(R.id.viewpager_exclusive);




        tabLayout_exclusive.setupWithViewPager(viewPager_exclusive);

        ViewPagerExclusiveAdapter adapter=new ViewPagerExclusiveAdapter(getChildFragmentManager());
        adapter.addFragment(new fragmentMOM(),"MOM");
        adapter.addFragment(new fragmentAttendance(),"Attendance");
        adapter.addFragment(new fragmentUpdates(),"Updates");

        viewPager_exclusive.setAdapter(adapter);


    }
}
