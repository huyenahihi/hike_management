package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add_btn;

    MyDatabaseHelper myDB;
    ArrayList<String> hk_id, hk_name, hk_time, hk_length;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        add_btn = findViewById(R.id.add_btn);
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });

        myDB = new MyDatabaseHelper(MainActivity.this);
        hk_id = new ArrayList<>();
        hk_name = new ArrayList<>();
        hk_time = new ArrayList<>();
        hk_length = new ArrayList<>();

        storeDataInArrays();
        Log.d("hk_id", hk_id.toString());
        Log.d("hk_name", hk_id.toString());
        Log.d("hk_time", hk_time.toString());
        Log.d("hk_length", hk_length.toString());
        customAdapter = new CustomAdapter(MainActivity.this, hk_id, hk_name, hk_time, hk_length);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

    void storeDataInArrays() {
        Cursor cursor = myDB.readAllData();
        if(cursor.getCount() == 0 ) {
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                hk_id.add(cursor.getString(0));
                hk_name.add(cursor.getString(1));
                hk_time.add(cursor.getString(2));
                hk_length.add(cursor.getString(3));
            }
        }
    }
}