package com.example.activcount.ui.preferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.activcount.R;
import com.example.activcount.ui.preferences.PreferencesViewModel;

public class BusinessPreferences extends AppCompatActivity {

    public SharedPreferences saved_info, s_rev;
    public static final String PREFS_NAME = "activcountVars";

    // Persistent variables
    public String biz_op_name, str_rev, str_coss, str_oe, str_intexp, str_inctax, str_status;
    int bus_num;            // Business number
    float oper_rev, dc, profit, oper_exp, int_exp, ebit, ebt, taxes, net_income;
    // UI items
    private Button btn_submit;
    private EditText operating_name, rev, coss, exp, intexp, inctax;
    //public TextView status;

    public void init()
    {

        // Load business operating name from preferences file.
        //saved_info  = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        /*biz_op_name = saved_info.getString("biz_oper_name", biz_op_name);
        str_rev     = saved_info.getString("oper_rev", str_rev);
        str_coss    = saved_info.getString("coss", str_coss);
        str_oe      = saved_info.getString("oe", str_oe);
        str_intexp  = saved_info.getString("intexp", str_intexp);
        str_inctax  = saved_info.getString("inctax", str_inctax);*/

        str_status      = "Limited";


    }

    public void setStatus(TextView status, String msg)
    {
        status.setText(msg);
    }
}