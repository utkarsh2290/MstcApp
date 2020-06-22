package com.example.mstcapp.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class onlineFootprintPagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> fragmentList2=new ArrayList<>();
    private final List<String>fragmentListTitles2=new ArrayList<>();

    public onlineFootprintPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return  fragmentList2.get(position);
    }

    @Override
    public int getCount() {
        return  fragmentListTitles2.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentListTitles2.get(position);
    }

    public void addFragment(Fragment fragment, String Title){
        fragmentList2.add(fragment);
        fragmentListTitles2.add(Title);
    }
}
