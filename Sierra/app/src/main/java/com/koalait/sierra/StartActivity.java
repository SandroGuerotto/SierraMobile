package com.koalait.sierra;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.koalait.sierra.login.LoginActivity;

public class StartActivity extends AppCompatActivity {

    private static final String TAG = "StartActivity";
    public static final int GOTO_MAIN = 3;
    public static final boolean debug = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (debug){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            this.finish();
        }else {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivityForResult(intent, GOTO_MAIN);
        }

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
