package com.example.scrabble;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */

    Button mButton;
    EditText mEdit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

    mButton = (Button)findViewById(R.id.button);
    mEdit   = (EditText)findViewById(R.id.textView10);

    mButton.setOnClickListener(
            new View.OnClickListener()
    {
        public void onClick(View view)
        {
            Log.v("EditText", mEdit.getText().toString());
        }
    });
}}