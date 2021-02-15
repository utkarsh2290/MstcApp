package com.example.mstcapp.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class viewpagerResAdapter extends FragmentStatePagerAdapter {

    //comments
    private final List<Fragment> fragmentList=new ArrayList<>();
    private final List<String> listTitles=new ArrayList<>();
    public viewpagerResAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return listTitles.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listTitles.get(position);
    }
    public void addFragment(Fragment fragment,String title){
        fragmentList.add(fragment);
        listTitles.add(title);
    }
}
