/*
    Date Created:       October 15, 2019
    Last time updated:  October 19, 2019

    Author: Alexandre Bobkov
    Company: Alexandre Comptabilite Specialise Ltee.

    Program purpose: To display key accounting information and financial overview.
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
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import android.view.View;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

public class MainActivity extends Activity {

    private AppBarConfiguration mAppBarConfiguration;

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
    public void submitBizInfo(View view) {    }
    public void launchnavMenu(View view) {
        Intent intent = new Intent(this, nav_menu.class);
        startActivity(intent);
    }
}
