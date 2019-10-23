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
        saved_info  = getSharedPreferences(PREFS_NAME, 0);
        biz_op_name = saved_info.getString("biz_oper_name", biz_op_name);
        str_rev     = saved_info.getString("oper_rev", str_rev);
        str_coss    = saved_info.getString("coss", str_coss);
        str_oe      = saved_info.getString("oe", str_oe);
        str_intexp  = saved_info.getString("intexp", str_intexp);
        str_inctax  = saved_info.getString("inctax", str_inctax);

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

    // Save data entered by user.
    public void submitBizInfo(View view) {
        TextView label = (TextView) findViewById(R.id.biz_operating_name);
        EditText name       = (EditText) findViewById(R.id.biz_operating_name);
        EditText np         = (EditText) findViewById(R.id.val_np);
        EditText text_ni    = (EditText) findViewById(R.id.val_ni);
        EditText text_ebit  = (EditText) findViewById(R.id.val_ebit);
        EditText text_ebt   = (EditText) findViewById(R.id.val_ebt);

        // Get values entered by the user
        // Revenues
        if (rev.length() != 0)
            oper_rev = Float.parseFloat(rev.getText().toString());
        // Cost of Services Sold
        if (coss.length() != 0)
            dc = Float.parseFloat(coss.getText().toString());
        // Operating Expenses
        if (exp.length() != 0)
            oper_exp = Float.parseFloat(exp.getText().toString());
        // EBIT
        if (text_ebit.length() != 0)
            ebit = Float.parseFloat(text_ebit.getText().toString());
        // Interest Expense
        if (intexp.length() != 0)
            int_exp = Float.parseFloat(intexp.getText().toString());
        // EBT
        if (text_ebt.length() != 0)
            ebt = Float.parseFloat(text_ebt.getText().toString());
        // Taxes
        if (inctax.length() != 0)
            taxes = Float.parseFloat(inctax.getText().toString());
        // Perform calculations
        profit = oper_rev - dc;                     // Calculate Net Profit
        np.setText(Float.toString(profit));         // Display calculated value
        ebit = profit - oper_exp;                   // Calculate EBIT
        text_ebit.setText(Float.toString(ebit));    // Display calculated value
        ebt = ebit - int_exp;                       // Calculate EBT
        text_ebt.setText(Float.toString(ebt));      // Display calculated value
        net_income = ebt - taxes;                       // Calculate Net Income
        text_ni.setText(Float.toString(net_income));    // Display calculated value

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
    }
}
