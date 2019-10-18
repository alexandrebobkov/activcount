package com.example.activcount;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;
import android.os.Bundle;

public class biz_info extends AppCompatActivity {

    private Button btn_submit;
    private SharedPreferences saved_info;
    private EditText operating_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biz_info);

        btn_submit = (Button) findViewById(R.id.btn_submit);
        operating_name = (EditText) findViewById(R.id.biz_operating_name);
        saved_info = getSharedPreferences("biz_operating_name", MODE_PRIVATE);
        //btn_submit.setOnClickListener(submitButtonListener);

        TextView textElement = (TextView) findViewById(R.id.biz_operating_name);
        String modifiedText;
        modifiedText = textElement.getText().toString();
        modifiedText = modifiedText + "Ltd.";
        textElement.setText(modifiedText);
    }

    public void submitBizInfo(View view) {
        TextView label = (TextView) findViewById(R.id.biz_operating_name);
        EditText name = (EditText) findViewById(R.id.biz_operating_name);

        saved_info = getSharedPreferences("prefID", MODE_PRIVATE);
        SharedPreferences.Editor editor = saved_info.edit();
        editor.putString("nameKey", name.getText().toString());
        editor.apply();

        // change the status message
        EditText oper_name = (EditText) findViewById(R.id.biz_operating_name);  // define which object we refer to
        String business_name = oper_name.getText().toString();                  // define variable and get its value
        TextView status = (TextView) findViewById(R.id.submit_status);          // define which object we refer to
        status.setText(business_name + ": Submitted");                          // set the status message
    }
/*
    private void makeTag(String tag) {
        String or = saved_info.getString(tag,null);
        SharedPreferences.Editor preferencesEdior = operating_name.edit();
        preferencesEdior.putString(tag,null);
        preferencesEdior.commit();
    }
    public View.OnClickListener submitButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(operating_name.getText().length()>0) {
                makeTag(operating_name.getText().toString());
                ((InputMethodManager)getSystemService(Content.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(operating_name.getWindowToken(),0);
            }
        }
    };*/
}
