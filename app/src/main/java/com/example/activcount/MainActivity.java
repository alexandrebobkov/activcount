/*
    Author: Alexandre Bobkov
    Company: Alexandre Comptabilite Specialise Ltee.
    Program purpose: To display key accounting information and financiel overview.
*/

package com.example.activcount;
import android.content.Intent;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

//public class MainActivity extends AppCompatActivity {
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
        Define onClick Actions
     */
    // Button MORE on main screen
    public void launchActivity(View view) {
        // open AttachDoc if called launchActivity event
        Intent intent = new Intent(this, AttachDoc.class);
        startActivity(intent);
    }

    // To launch AboutApp screen
    public void launchAboutApp(View view) {
        // open AboutApp if called launchMain event
        Intent intent = new Intent(this, AboutApp.class);
        startActivity(intent);
    }

    // To launch Business Info screen
    public void launchBizInfo(View view) {
        // open BusinessInfo if called launchMain event
        Intent intent = new Intent(this, biz_info.class);
        startActivity(intent);
    }
    public void submitBizInfo(View view) {

    }
}
