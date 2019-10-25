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

import org.w3c.dom.Text;

public class PreferencesFragment extends Fragment {

    private PreferencesViewModel preferencesViewModel;

    public BusinessPreferences busPref;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        busPref = new BusinessPreferences();
        busPref.init();
        //busPref.setStatus("Ltd.");

        preferencesViewModel = ViewModelProviders.of(this).get(PreferencesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_preferences, container, false);
        final TextView textView = root.findViewById(R.id.text_preferences);
        preferencesViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        final TextView status = root.findViewById(R.id.text_status);
        busPref.setStatus(status, "ok");
        /*preferencesViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                status.setText("Ltd.");
            }
        });*/



        return root;
    }
}