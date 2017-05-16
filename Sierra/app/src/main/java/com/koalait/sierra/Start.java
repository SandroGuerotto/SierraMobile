package com.koalait.sierra;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class Start extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_dashboard:
//                    mTextMessage.setText(R.string.title_dashboard);
                    fragment = new DashboardFragment();
                    break;
//                    return true;
//                case R.id.navigation_home:
//                    mTextMessage.setText(R.string.title_home);
//                    return true;
                case R.id.navigation_mywork:
//                    mTextMessage.setText(R.string.title_mywork);
                    fragment = new MyHomeworkFragment();
                    break;
//                    return true;
                case R.id.navigation_news:
//                    mTextMessage.setText(R.string.title_news);
                    fragment = new NewsFragment();
                    break;
//                    return true;
                case R.id.navigation_schedule:
//                    mTextMessage.setText(R.string.title_schedule);
                    fragment = new ScheduleFragment();
                    break;
//                    return true;
                case R.id.navigation_settings:
//                    mTextMessage.setText(R.string.title_settings);
                    fragment = new SettingsFragment();
                    break;

//                    return true;
//                case R.id.navigation_notifications:
//                    mTextMessage.setText(R.string.title_notifications);
//                    return true;

            }
            if (fragment != null){
                getSupportFragmentManager().beginTransaction().replace(
                        R.id.fragmentContainer, fragment)
                        .commit();
                return true;
            }else{
                return false;
            }


        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        //get navigation
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        // set first display on dashboard
        navigation.setSelectedItemId(R.id.navigation_dashboard);
    }

}