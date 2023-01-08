package com.example.lab5.Models;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class Timetable  {

    //public List<ItemTimetable> itemsWeek;
    DatabaseAdapter databaseAdapter;
    //JSONHelper<ItemTimetable> jsonHelper;
    static Context context;
    public Timetable(Context context){
        this.context = context;
        //jsonHelper = new JSONHelper<>();
        //Type typeClass = new TypeToken<List<ItemTimetable>>() {}.getType();
        //itemsWeek = jsonHelper.importFromJSON(this.context, "Timetable", typeClass);
        //if(itemsWeek == null)
            //itemsWeek = new ArrayList<>();

        databaseAdapter = new DatabaseAdapter(context);
        databaseAdapter.open();
    }


    public Timetable AddLesson(ItemTimetable itemWeek){
        //itemsWeek.add(itemWeek);
        databaseAdapter.addLesson(itemWeek);
        //Type typeClass = new TypeToken<List<ItemTimetable>>() {}.getType();
        //jsonHelper.exportToJSON(this.context, itemsWeek, "Timetable", typeClass);
        return this;
    }

    public Timetable RemoveLesson(ItemTimetable itemWeek){
        //itemsWeek.remove(itemWeek);
        //Type typeClass = new TypeToken<List<ItemTimetable>>() {}.getType();
        //jsonHelper.exportToJSON(this.context, itemsWeek, "Timetable", typeClass);
        databaseAdapter.deleteLesson(itemWeek.Id);
        return this;
    }

    public Timetable Save(){
        //Type typeClass = new TypeToken<List<ItemTimetable>>() {}.getType();
        //jsonHelper.exportToJSON(this.context, itemsWeek, "Timetable", typeClass);
        //тут мб быть будет код сохранения или коммита бд. короче что-то будет, а мб и нет. думал есть коммит какой в бд. Но Я не нашёл.
        return this;
    }

    public void updateLesson(ItemTimetable itemTimetable){
        databaseAdapter.updateLesson(itemTimetable);
    }

    public ItemTimetable getLessonId(int id){
        return databaseAdapter.getLessonId(id);
    }

    public List<ItemTimetable> getListLessons(){
        return databaseAdapter.getLessons();
    }

    public List<ItemTimetable> getListLessonsNumWeek(int numOfWeek){
        return databaseAdapter.getLessonsNumOfWeek(numOfWeek);
    }

    public void closeDatabase(){ databaseAdapter.close();}
}
