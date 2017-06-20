package com.koalait.sierra;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.koalait.sierra.login.LoginActivity;
import com.koalait.sierra.login.SaveSharedPreference;

public class StartActivity extends AppCompatActivity {

    public static final int GOTO_MAIN = 3;
    public static final boolean debug = true;
    private static final String TAG = "StartActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (SaveSharedPreference.getUserName(StartActivity.this).length() == 0) {
            // call Login Activity
            Intent intent = new Intent(this, LoginActivity.class);
            startActivityForResult(intent, GOTO_MAIN);
        } else {
            // Stay at the current activity.
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            this.finish();
        }

//        if (debug){
//            Intent intent = new Intent(this, MainActivity.class);
//            startActivity(intent);
//            this.finish();
//        }else {
//            Intent intent = new Intent(this, LoginActivity.class);
//            startActivityForResult(intent, GOTO_MAIN);
//        }

        return;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.println(Log.DEBUG, TAG, "onActivityResult Start");
        if (requestCode == GOTO_MAIN) {
            if (resultCode == RESULT_OK) {
                Intent intent = new Intent(this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                this.finish();
            }
        }
    }
}
