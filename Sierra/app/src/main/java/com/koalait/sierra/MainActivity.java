package com.koalait.sierra;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar.OnMenuItemClickListener;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.koalait.sierra.ListAdapter.NotificationListAdapter;
import com.koalait.sierra.fragments.DashboardFragment;
import com.koalait.sierra.fragments.MyHomeworkFragment;
import com.koalait.sierra.fragments.MyMarksFragment;
import com.koalait.sierra.fragments.NewsFragment;
import com.koalait.sierra.fragments.ScheduleFragment;
import com.koalait.sierra.fragments.SettingsFragment;
import com.koalait.sierra.model.Model;

import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    public final Context context = this;
    @InjectView(R.id.notification)
    Button btn_resetPw;
    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
            = item -> {
                Fragment fragment = null;

                switch (item.getItemId()) {
                    case R.id.navigation_dashboard:
                        fragment = new DashboardFragment();
                        break;
                    case R.id.navigation_mywork:
                        fragment = new MyHomeworkFragment();
                        break;
                    case R.id.navigation_news:
                        fragment = new NewsFragment();
                        break;
                    case R.id.navigation_schedule:
                        fragment = new ScheduleFragment();
                        break;
                    case R.id.navigation_mymarks:
                        fragment = new MyMarksFragment();
                        break;
                }
                if (fragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(
                            R.id.fragmentContainer, fragment)
                            .commit();
                    Log.println(Log.DEBUG, TAG, "click " + item.getTitle());
                    return true;
                } else {
                    return false;
                }
            };

    private OnMenuItemClickListener toolbarListener = item -> {
        Log.println(Log.ERROR, TAG, "click");
        Fragment fragment = null;
        switch (item.getItemId()) {
            case R.id.settings:
                fragment = new SettingsFragment();
                break;
            case R.id.notification:
                showNotificaton();
//                Toast.makeText(context, "Noch nicht unterstützt", Toast.LENGTH_SHORT).show();
                break;
        }
        if (fragment != null){
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.fragmentContainer, fragment)
                    .commit();
            Log.println(Log.DEBUG, TAG, "click " + item.getTitle());
            return true;
        }else{
            return false;
        }
    };
    // Menu icons are inflated just as they were with actionbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        //get navigation
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        // set first display on dashboard
        navigation.setSelectedItemId(R.id.navigation_dashboard);

        // Find the toolbar view inside the activity layout
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        setSupportActionBar(toolbar);
        // set action listener
        toolbar.setOnMenuItemClickListener(toolbarListener);

        Model model = Model.getInstance(this.context);
        model.setNextLesson(getString(R.string.nextLesson, "Deutsch", 250));
        return;
    }

    private void showNotificaton() {
        int popupHeight = 1200;

        // Inflate the popup_layout.xml
        LayoutInflater layoutInflater = (LayoutInflater) this.context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = layoutInflater.inflate(R.layout.popup_notification, null);
        //define layout color
        layout.setBackgroundResource(R.color.white);

        // Creating the PopupWindow
        PopupWindow popup = new PopupWindow(context);


        popup.setWidth(LinearLayout.LayoutParams.WRAP_CONTENT);
        popup.setHeight(popupHeight);
        popup.setFocusable(true);
        popup.setBackgroundDrawable(null);

        // Some offset to align the popup a bit to the right, and a bit down, relative to button's position.
        int OFFSET_X = 50;
        int OFFSET_Y = 320;

        NotificationListAdapter adapter = new NotificationListAdapter(context, android.R.layout.simple_list_item_1, Model.getInstance().notify);
        ListView lv_marks = (ListView) layout.findViewById(R.id.list_notification);
        lv_marks.setAdapter(adapter);

        popup.setContentView(layout);
        // Displaying the popup at the specified location, + offsets.
        popup.showAtLocation(layout, Gravity.NO_GRAVITY, OFFSET_X, OFFSET_Y);
    }
}
