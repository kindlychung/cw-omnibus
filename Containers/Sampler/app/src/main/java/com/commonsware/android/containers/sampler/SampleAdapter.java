package com.commonsware.android.containers.sampler;


import android.app.Activity;
import android.content.res.TypedArray;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

class SampleAdapter extends FragmentPagerAdapter {
        private int[] layouts;
        private String[] titles;
        Activity activity;

        SampleAdapter(Activity activity, FragmentManager mgr) {
            super(mgr);
            this.activity = activity;
            layouts = getLayoutsArray();
            titles = activity.getResources().getStringArray(R.array.titles);
        }

        @Override
        public int getCount() {
            return (titles.length);
        }

        @Override
        public Fragment getItem(int position) {
            return LayoutFragment.newInstance(layouts[position]);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return (titles[position]);
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
