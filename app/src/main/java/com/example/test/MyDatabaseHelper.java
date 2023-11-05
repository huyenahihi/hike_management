package com.example.test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "hiking.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_HIKING = "hiking";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_COUNTRY = "country";
    private static final String COLUMN_CITY = "city";
    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_HIKING_TIME = "hiking_time";
    private static final String COLUMN_LENGTH = "length";
    private static final String COLUMN_LEVEL = "level";
    private static final String COLUMN_DESCRIPTION = "description";
    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_HIKING + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_COUNTRY + " TEXT,"
                + COLUMN_CITY + " TEXT,"
                + COLUMN_DATE + " TEXT,"
                + COLUMN_HIKING_TIME + " TEXT,"
                + COLUMN_LENGTH + " REAL,"
                + COLUMN_LEVEL + " TEXT,"
                + COLUMN_DESCRIPTION + " TEXT"
                + ")";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HIKING);
        onCreate(db);
    }

    void addHikking(String name, String country, String city, String date, String time, String length, String level, String description) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAME, name);
        cv.put(COLUMN_COUNTRY, country);
        cv.put(COLUMN_CITY, city);
        cv.put(COLUMN_DATE, date);
        cv.put(COLUMN_HIKING_TIME, time);
        cv.put(COLUMN_LENGTH, length);
        cv.put(COLUMN_LEVEL, level);
        cv.put(COLUMN_DESCRIPTION, description);
        long result = db.insert(TABLE_HIKING, null, cv);
        if(result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Insert Successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllData() {
        String query = "SELECT * FROM " + TABLE_HIKING;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db !=null) {
            cursor = db.rawQuery(query, null);
        }
        return  cursor;
    }
}
