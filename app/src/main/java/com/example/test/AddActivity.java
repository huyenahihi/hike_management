package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText name, country, city, date, time, length, level, description;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        name = findViewById(R.id.editTextName);
        country = findViewById(R.id.editTextCountry);
        city = findViewById(R.id.editTextCity);
        date = findViewById(R.id.editTextDate);
        time = findViewById(R.id.editTextHikingTime);
        length = findViewById(R.id.editTextLength);
        level = findViewById(R.id.editTextLevel);
        description = findViewById(R.id.editTextDescription);
        add_button = findViewById(R.id.add_button);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseHelper myDb = new MyDatabaseHelper(AddActivity.this);
                myDb.addHikking(
                        name.getText().toString().trim(),
                        country.getText().toString().trim(),
                        city.getText().toString().trim(),
                        date.getText().toString().trim(),
                        time.getText().toString().trim(),
                        length.getText().toString().trim(),
                        level.getText().toString().trim(),
                        description.getText().toString().trim()
                        );
            }
        });
    }
}