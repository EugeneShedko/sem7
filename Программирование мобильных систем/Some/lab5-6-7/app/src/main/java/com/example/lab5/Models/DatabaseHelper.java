package com.example.lab5.Models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "GoodsFinder.db";
    public static final int DATABASE_VERSION = 1;

    Context baseContext;
    public DatabaseHelper(@Nullable Context baseContext){
        super(baseContext, DATABASE_NAME, null, DATABASE_VERSION);
        this.baseContext = baseContext;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTableTeachers = "CREATE TABLE IF NOT EXISTS Teachers (Id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, firstName TEXT, lastName TEXT, patronymic TEXT, pathImage TEXT)";
        String createTableLessons = "CREATE TABLE IF NOT EXISTS Lessons (Id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, dayOfWeek INTEGER, "
        + "numberWeek INTEGER, numberAuditory INTEGER, korpus, startTime TEXT, endTime TEXT, teacherId INTEGER, nameLesson TEXT)";
        db.execSQL(createTableTeachers);
        db.execSQL(createTableLessons);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + "Teachers");
        db.execSQL("DROP TABLE IF EXISTS " + "Lessons");
        onCreate(db);
    }




}
