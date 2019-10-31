package com.example.ayahtaskmnger.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.ayahtaskmnger.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class MyFragmentsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};//3naween
    private final Context mContext;
    //1
    private AlltasksFragment alltasksFragment;
    private HistoryFragment historyFragment;
    private RemovedFragment removedFragment;

    public MyFragmentsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
        //2
        alltasksFragment=new AlltasksFragment();
        historyFragment=new HistoryFragment();
        removedFragment=new RemovedFragment();

    }

    @Override
    public Fragment getItem(int position)//rakm al tap(fragment)
    {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        /*
     (  arja3 alfragment )
         */

        if (position==0)
            return alltasksFragment;

        if (position==1)
            return historyFragment;

        if (position==2)
            return removedFragment;
        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 2;
    }
}