package com.example.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {
    EditText etITem;
    Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        etITem = findViewById(R.id.etITem);
        btnSave = findViewById(R.id.btnSave);

        getSupportActionBar().setTitle("Edit item");

        etITem.setText(getIntent().getStringExtra(MainActivity.KEY_ITEM_TEXT));

        // WHen the user is done editing they click the save button
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // create an intent which will contain the results
                Intent intent = new Intent();
                // pass the dta (results of editing)
                intent.putExtra(MainActivity.KEY_ITEM_TEXT,etITem.getText().toString());
                intent.putExtra(MainActivity.KEY_ITEM_POSITION,getIntent().getExtras().getInt(MainActivity.KEY_ITEM_POSITION));
                // set the result of the intent
                setResult(RESULT_OK,intent);
                // finish activity, close the screen and go back
                finish();
            }
        });
    }
}