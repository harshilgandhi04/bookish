package com.example.android.book_hub;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by WittyStarLord on 04/04/17.
 */

public class CategoryAdapter extends FragmentPagerAdapter {
    private Context mContext;
    private int[] imageResId = {
            R.drawable.ic_one,
            R.drawable.ic_two,
            R.drawable.ic_three
    };


    /**
 * Create a new {@link CategoryAdapter} object.
 *
 * @param fm is the fragment manager that will keep each fragment's state in the adapter
 *           across swipes.
 */
public CategoryAdapter(Context context, FragmentManager fm) {

    super(fm);
    mContext=context;
    }

/**
 * Return the {@link Fragment} that should be displayed for the given page number.
 */
        @Override
        public Fragment getItem ( int position) {
            if (position == 0) {
                return new TrendingFragment();
            } else if (position == 1) {
                return new BestOfFragment();
            } else   {
                return new recommFragment();
            }

        }

/**
 * Return the total number of pages.
 */
        @Override
        public int getCount () {
        return 3;
    }

        @Override
        public CharSequence getPageTitle(int position) {
            if (position == 0) {
                return mContext.getString(R.string.category_Trending);
            } else if (position == 1) {
                return mContext.getString(R.string.category_BestOf);
            } else   {
                return mContext.getString(R.string.category_recomm);
            }
        }

    }

