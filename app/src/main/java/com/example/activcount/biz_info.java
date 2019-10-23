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
    private SharedPreferences saved_info, s_rev;
    public static final String PREFS_NAME = "activcountVars";
    // Persistent variables
    String biz_op_name, str_rev, str_coss, str_oe, str_intexp, str_inctax;
    int bus_num;            // Business number
    float oper_rev, dc, profit, oper_exp, int_exp, ebit, ebt, taxes, net_income;

    // UI items
    private Button btn_submit;
    private EditText operating_name, rev, coss, exp, intexp, inctax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biz_info);

        btn_submit  =   (Button) findViewById(R.id.btn_submit);
        rev         =   (EditText) findViewById(R.id.val_rev);
        coss        =   (EditText) findViewById(R.id.val_coss);
        exp         =   (EditText) findViewById(R.id.val_oe);
        intexp      =   (EditText) findViewById(R.id.val_intexp);
        inctax      =   (EditText) findViewById(R.id.val_inctax);

        // Load business operating name from preferences file.
        saved_info = getSharedPreferences(PREFS_NAME, 0);
        //saved_info = getSharedPreferences(PREFS_NAME, 1);
        //s_rev = getSharedPreferences(PREFS_NAME, 1);
        biz_op_name = saved_info.getString("biz_oper_name", biz_op_name);
        str_rev = saved_info.getString("oper_rev", str_rev);
        str_coss = saved_info.getString("coss", str_coss);
        str_oe = saved_info.getString("oe", str_oe);
        str_intexp = saved_info.getString("intexp", str_intexp);
        str_inctax = saved_info.getString("inctax", str_inctax);

        // Display business operating name, if any, in textview.
        TextView textElement = (TextView) findViewById(R.id.biz_operating_name);
        if (biz_op_name == null)
            textElement.setText("enter Business Operating Name");
        else
            textElement.setText(""+biz_op_name);
        if (str_rev != null)
            rev.setText(str_rev);
        if (str_coss != null)
            coss.setText(str_coss);
        if (str_oe != null)
            exp.setText(str_oe);
        if (str_intexp != null)
            intexp.setText(str_intexp);
        if (str_inctax != null)
            inctax.setText(str_inctax);
    }

    public void submitBizInfo(View view) {
        TextView label = (TextView) findViewById(R.id.biz_operating_name);
        EditText name = (EditText) findViewById(R.id.biz_operating_name);

        if (rev.length() != 0)
            oper_rev = Float.parseFloat(rev.getText().toString());
        if (coss.length() != 0)
            dc = Float.parseFloat(coss.getText().toString());
        if (exp.length() != 0)
            oper_exp = Float.parseFloat(exp.getText().toString());
        EditText text_ebit = (EditText) findViewById(R.id.val_ebit);
        if (text_ebit.length() != 0)
            ebit = Float.parseFloat(text_ebit.getText().toString());

        if (intexp.length() != 0)
            int_exp = Float.parseFloat(intexp.getText().toString());
        EditText text_ebt = (EditText) findViewById(R.id.val_ebt);
        if (text_ebt.length() != 0)
            ebt = Float.parseFloat(text_ebt.getText().toString());

        if (inctax.length() != 0)
            taxes = Float.parseFloat(inctax.getText().toString());

        profit = oper_rev - dc;
        EditText np = (EditText) findViewById(R.id.val_np);
        np.setText(Float.toString(profit));

        ebit = profit - oper_exp;
        text_ebit.setText(Float.toString(ebit));

        ebt = ebit - int_exp;
        text_ebt.setText(Float.toString(ebt));

        net_income = ebt - taxes;
        EditText text_ni = (EditText) findViewById(R.id.val_ni);
        text_ni.setText(Float.toString(net_income));

        // Save values
        saved_info = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        SharedPreferences.Editor editor = saved_info.edit();

        editor.putString("biz_oper_name", name.getText().toString());
        editor.putString("oper_rev", Float.toString(oper_rev));
        editor.putString("coss", Float.toString(dc));
        editor.putString("oe", Float.toString(oper_exp));
        editor.putString("intexp", Float.toString(int_exp));
        editor.putString("inctax", Float.toString(taxes));
        editor.apply();

        //TextView status = (TextView) findViewById(R.id.submit_status);          // define which object we refer to
        //status.setText(business_name + ": Submitted");
    }
}
