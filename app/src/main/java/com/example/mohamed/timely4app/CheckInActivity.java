package com.example.mohamed.timely4app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by mohamed on 4/1/17.
 */

public class CheckInActivity extends AppCompatActivity {
    ViewPager viewPager2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkin);
        viewPager2 = (ViewPager) findViewById(R.id.viewPager);
        CustomViewPager2 customViewPager2 = new CustomViewPager2(getSupportFragmentManager());
        viewPager2.setAdapter(customViewPager2);

    }

    public class CustomViewPager2 extends FragmentStatePagerAdapter {

        public CustomViewPager2(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment f = null;
            if (position == 0){
                f = new PairFragment();
            }
            else if(position == 1){
                f = new ledControl();
            }

            return f;
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
