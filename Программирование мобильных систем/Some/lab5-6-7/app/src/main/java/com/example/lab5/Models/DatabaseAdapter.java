package com.example.lab5.Models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class DatabaseAdapter {
    private DatabaseHelper dbHelper;
    private SQLiteDatabase database;

    public DatabaseAdapter(Context context){
        dbHelper = new DatabaseHelper(context.getApplicationContext());
    }

    public DatabaseAdapter open(){
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        dbHelper.close();
    }

    public long addTeacher(Teacher teacher){

        ContentValues cv = new ContentValues();

        cv.put("firstName", teacher.firstName);
        cv.put("lastName", teacher.lastName);
        cv.put("patronymic", teacher.patronymic);
        cv.put("pathImage", teacher.pathImage);

        //database.execSQL("INSERT INTO Teachers (" + teacher.Id + ","+ teacher.firstName + ", "
        //        + teacher.lastName + ", "
        //        + teacher.patronymic + ", "
        //        + teacher.pathImage + ");");

        return  database.insert("Teachers", null, cv);
    }

    public List<Teacher> getTeachers(){

        List<Teacher> teacherList = new ArrayList<>();
        Cursor query = database.rawQuery("SELECT *FROM Teachers;", null);
        while(query.moveToNext()){
            Teacher newTeacher = new Teacher();
            newTeacher.Id = query.getInt(0);
            newTeacher.firstName = query.getString(1);
            newTeacher.lastName = query.getString(2);
            newTeacher.patronymic = query.getString(3);
            newTeacher.pathImage = query.getString(4);
            teacherList.add(newTeacher);
        }
        query.close();

        return teacherList;
    }

    public Teacher getTeacherId(int id){
        Teacher newTeacher = new Teacher();

        Cursor query = database.rawQuery("SELECT *FROM Teachers WHERE Id=" + id +  ";", null);

            if(query.moveToFirst()){

                newTeacher.Id = query.getInt(0);
                newTeacher.firstName = query.getString(1);
                newTeacher.lastName = query.getString(2);
                newTeacher.patronymic = query.getString(3);
                newTeacher.pathImage = query.getString(4);
            }
            query.close();

            return newTeacher;
        }

    public long addLesson(ItemTimetable itemTimetable){

        ContentValues cv = new ContentValues();

        cv.put("dayOfWeek", itemTimetable.dayOfWeek.getValue());
        cv.put("numberWeek", itemTimetable.numberWeek);
        cv.put("numberAuditory", itemTimetable.numberAuditory);
        cv.put("korpus", itemTimetable.korpus);
        cv.put("startTime", itemTimetable.startTime);
        cv.put("endTime", itemTimetable.endTime);
        cv.put("teacherId", itemTimetable.teacherId);
        cv.put("nameLesson", itemTimetable.nameLesson);

        return  database.insert("Lessons", null, cv);
    }

    public List<ItemTimetable> getLessons(){

        List<ItemTimetable> lessonList = new ArrayList<>();
        Cursor query = database.rawQuery("SELECT *FROM Lessons;", null);
        while(query.moveToNext()){
            ItemTimetable itemTimetable = new ItemTimetable();
            itemTimetable.Id = query.getInt(0);
            itemTimetable.dayOfWeek = DayOfWeek.of(query.getInt(1));
            itemTimetable.numberWeek = query.getInt(2);
            itemTimetable.numberAuditory = query.getInt(3);
            itemTimetable.korpus = query.getInt(4);
            itemTimetable.startTime = query.getString(5);
            itemTimetable.endTime = query.getString(6);
            itemTimetable.teacherId = query.getInt(7);
            itemTimetable.nameLesson = query.getString(8);
            lessonList.add(itemTimetable);
        }
        query.close();

        return lessonList;
    }

    public List<ItemTimetable> getLessonsNumOfWeek(int i){

        List<ItemTimetable> lessonList = new ArrayList<>();
        Cursor query = database.rawQuery("SELECT *FROM Lessons WHERE numberWeek=" + i +  ";", null);
        while(query.moveToNext()){
            ItemTimetable itemTimetable = new ItemTimetable();
            itemTimetable.Id = query.getInt(0);
            itemTimetable.dayOfWeek = DayOfWeek.of(query.getInt(1));
            itemTimetable.numberWeek = query.getInt(2);
            itemTimetable.numberAuditory = query.getInt(3);
            itemTimetable.korpus = query.getInt(4);
            itemTimetable.startTime = query.getString(5);
            itemTimetable.endTime = query.getString(6);
            itemTimetable.teacherId = query.getInt(7);
            itemTimetable.nameLesson = query.getString(8);
            lessonList.add(itemTimetable);
        }
        query.close();

        return lessonList;
    }

    public long deleteLesson(long lessonId){

        String whereClause = "Id = ?";
        String[] whereArgs = new String[]{String.valueOf(lessonId)};
        return database.delete("Lessons", whereClause, whereArgs);
    }

    public long updateLesson(ItemTimetable itemTimetable){

        String whereClause = "Id" + "=" + itemTimetable.Id;
        ContentValues cv = new ContentValues();
        cv.put("Id", itemTimetable.Id);
        cv.put("dayOfWeek", itemTimetable.dayOfWeek.getValue());
        cv.put("numberWeek", itemTimetable.numberWeek);
        cv.put("numberAuditory", itemTimetable.numberAuditory);
        cv.put("korpus", itemTimetable.korpus);
        cv.put("startTime", itemTimetable.startTime);
        cv.put("endTime", itemTimetable.endTime);
        cv.put("teacherId", itemTimetable.teacherId);
        cv.put("nameLesson", itemTimetable.nameLesson);

        return database.update("Lessons", cv, whereClause, null);
    }

    public ItemTimetable getLessonId(int i){
        ItemTimetable itemTimetable = new ItemTimetable();
        Cursor query = database.rawQuery("SELECT *FROM Lessons WHERE Id=" + i +  ";", null);
        if(query.moveToFirst()){
            itemTimetable.Id = query.getInt(0);
            itemTimetable.dayOfWeek = DayOfWeek.of(query.getInt(1));
            itemTimetable.numberWeek = query.getInt(2);
            itemTimetable.numberAuditory = query.getInt(3);
            itemTimetable.korpus = query.getInt(4);
            itemTimetable.startTime = query.getString(5);
            itemTimetable.endTime = query.getString(6);
            itemTimetable.teacherId = query.getInt(7);
            itemTimetable.nameLesson = query.getString(8);
        }
        query.close();

        return itemTimetable;
    }

}
