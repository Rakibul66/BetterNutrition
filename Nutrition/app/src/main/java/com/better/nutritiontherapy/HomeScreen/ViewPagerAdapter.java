package com.better.nutritiontherapy.HomeScreen;


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;


public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        final Fragment[] fragment = {null};

        if (position == 0) {
            fragment[0] = new Fragment_More();
        } else if (position == 1) {
            fragment[0] = new Fragment_blog();
        }


        return fragment[0];
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        if (position == 0) {
            return "পুষ্টি তথ্য";
        } else if (position == 1) {
            return "ব্লগ";}
            return null;
        }


    }