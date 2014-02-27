package com.example.scrabble;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */

EditText edit;
TextView text;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    View my_row = findViewById(R.id.textView10);

        }