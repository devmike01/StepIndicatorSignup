package com.jadebyte.devmike.signup;

import android.content.res.Resources;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.jadebyte.devmike.signup.customviews.StepIndicator;
import com.jadebyte.devmike.signup.fragments.PersonalAndContactFragment;
import com.jadebyte.devmike.signup.fragments.UploadFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    StepIndicator stepIndicator;
    private Button nextButton;
    private static final int NEXTBTN_ID =R.id.nextBtn;
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabLayout tabs = findViewById(R.id.sliding_tabs);
        stepIndicator = findViewById(R.id.step_indicator);
        nextButton = findViewById(NEXTBTN_ID);
        nextButton.setOnClickListener(this);

        //Set the pager with an adapter
        pager = (ViewPager)findViewById(R.id.pager);
        pager.setAdapter(new OpenAccountPagerAdapter(getSupportFragmentManager()));


        tabs.setSelectedTabIndicatorColor(Color.TRANSPARENT);
        //Bind the step indicator to the adapter
        tabs.setupWithViewPager(pager);
        stepIndicator.setupWithViewPager(pager);

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //Disable button if its the last page
                //enableBtn(position < pager.getCurrentItem());
            }

            @Override
            public void onPageSelected(int position) {
                //Disable button if its the last page

                enableBtn(position < stepIndicator.getStepsCount()-1);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void enableBtn(boolean isEnable){
        nextButton.setEnabled(isEnable);

        //Change color according to button state
        Resources res =getResources();
        nextButton.setTextColor(isEnable?res.getColor(android.R.color.white):res.getColor(android.R.color.darker_gray));
    }

    private class OpenAccountPagerAdapter extends FragmentStatePagerAdapter {
        String title[];
        public OpenAccountPagerAdapter(FragmentManager fm) {
            super(fm);
            title = new String[]{"Personal", "Contact", "Upload"};
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return PersonalAndContactFragment.newInstance(true);
                case 1:
                    return PersonalAndContactFragment.newInstance(false);
                case 2:
                    return new UploadFragment();
                default:
                    return null;
            }

        }


        @Override
        public CharSequence getPageTitle(int position){
            String mTitle =title[position];
            //Capitalize first letter of string
            return mTitle.substring(0,1).toUpperCase().concat(mTitle.substring(1, mTitle.length()).toLowerCase());
        }

        @Override
        public int getCount() {
            return stepIndicator.getStepsCount();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case NEXTBTN_ID:
                pager.setCurrentItem(pager.getCurrentItem() + 1);

                break;
        }
    }


}

