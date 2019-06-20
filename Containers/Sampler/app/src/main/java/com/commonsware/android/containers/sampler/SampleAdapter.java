package com.commonsware.android.containers.sampler;


import android.app.Activity;
import android.content.res.TypedArray;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

class SampleAdapter extends FragmentPagerAdapter {
        private int[] layoutIDs;
        private String[] layoutTitles;
        Activity activity;

        SampleAdapter(Activity activity, FragmentManager mgr) {
            super(mgr);
            this.activity = activity;
            layoutIDs = getLayoutsArray();
            layoutTitles = activity.getResources().getStringArray(R.array.titles);
        }

        @Override
        public int getCount() {
            return (layoutTitles.length);
        }

        @Override
        public Fragment getItem(int index) {
            return LayoutFragment.newInstance(layoutIDs[index]);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return (layoutTitles[position]);
        }

        int[] getLayoutsArray() {
            TypedArray typedArray =
                    activity.getResources().obtainTypedArray(R.array.layouts);
            int n = typedArray.length();
            int[] result = new int[n];

            for (int i = 0; i < n; i++) {
                result[i] = typedArray.getResourceId(i, -1);
            }
            typedArray.recycle();
            return (result);
        }
    }
