/*
    Author: Alexandre Bobkov
    Company: Alexandre Comptabilite Specialise Ltee.
*/
package com.example.activcount;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;

public class biz_info extends AppCompatActivity {

    // Preferences variables
    private SharedPreferences saved_info;
    public static final String PREFS_NAME = "activcountVars";
    // Variables
    String biz_oper_name;   // Business operating name
    int bus_num;            // Business number
    float oper_rev, dc, profit, oper_exp, intexp, ebit, ebt, taxes, net_income;

    // UI items
    private Button btn_submit;
    private EditText operating_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biz_info);

        btn_submit = (Button) findViewById(R.id.btn_submit);
        operating_name = (EditText) findViewById(R.id.biz_operating_name);

        // Load business operating name from preferences file.
        saved_info = getSharedPreferences(PREFS_NAME, 0);
        biz_oper_name = saved_info.getString("biz_oper_name", biz_oper_name);

        // Display business operating name, if any, in textview.
        TextView textElement = (TextView) findViewById(R.id.biz_operating_name);
        if (biz_oper_name == null)
            textElement.setText("enter Business Operating Name");
        else
            textElement.setText(""+biz_oper_name);
    }

    public void submitBizInfo(View view) {
        TextView label = (TextView) findViewById(R.id.biz_operating_name);
        EditText name = (EditText) findViewById(R.id.biz_operating_name);

        EditText rev = (EditText) findViewById(R.id.val_rev);
        if (rev.length() != 0)
            oper_rev = Float.parseFloat(rev.getText().toString());
        EditText coss = (EditText) findViewById(R.id.val_coss);
        if (coss.length() != 0)
            dc = Float.parseFloat(coss.getText().toString());
        EditText exp = (EditText) findViewById(R.id.val_oe);
        if (exp.length() != 0)
            oper_exp = Float.parseFloat(exp.getText().toString());
        EditText text_ebit = (EditText) findViewById(R.id.val_ebit);
        if (text_ebit.length() != 0)
            ebit = Float.parseFloat(text_ebit.getText().toString());
        EditText text_intexp = (EditText) findViewById(R.id.val_intexp);
        if (text_intexp.length() != 0)
            intexp = Float.parseFloat(text_intexp.getText().toString());
        EditText text_ebt = (EditText) findViewById(R.id.val_ebt);
        if (text_ebt.length() != 0)
            ebt = Float.parseFloat(text_ebt.getText().toString());
        EditText text_taxes = (EditText) findViewById(R.id.val_inctax);
        if (text_taxes.length() != 0)
            taxes = Float.parseFloat(text_ebt.getText().toString());

        // change the status message
        EditText oper_name = (EditText) findViewById(R.id.biz_operating_name);  // define which object we refer to
        String business_name = oper_name.getText().toString();                  // define variable and get its value
        saved_info = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = saved_info.edit();
        editor.putString("biz_oper_name", name.getText().toString());
        editor.apply();
        //TextView status = (TextView) findViewById(R.id.submit_status);          // define which object we refer to
        //status.setText(business_name + ": Submitted");                          // set the status message

        profit = oper_rev - dc;
        EditText np = (EditText) findViewById(R.id.val_np);
        np.setText(Float.toString(profit));

        ebit = profit - oper_exp;
        text_ebit.setText(Float.toString(ebit));

        ebt = ebit - intexp;
        text_ebt.setText(Float.toString(ebt));

        net_income = ebt - taxes;
        EditText text_ni = (EditText) findViewById(R.id.val_ni);
        text_ni.setText(Float.toString(net_income));


    }
}
