package com.example.lab5.Models;

import android.content.Context;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TeacherList  {

    //public List<Teacher> teachers;
    //JSONHelper<Teacher> jsonHelper;
    static Context context;
    DatabaseAdapter databaseAdapter;
    public TeacherList(Context context){
        this.context = context;
        //jsonHelper = new JSONHelper<>();
        //Type typeClass = new TypeToken<List<Teacher>>() {}.getType();
        //teachers = new ArrayList<>(jsonHelper.importFromJSON(this.context, "teachers", typeClass));
        //if(teachers == null)
        //    teachers = new ArrayList<>();
        databaseAdapter = new DatabaseAdapter(context);
        databaseAdapter.open();
    }

    public void AddTeacher(Teacher newTeacher){
        long error = databaseAdapter.addTeacher(newTeacher);
        //teachers.add(newTeacher);
        //Type typeClass = new TypeToken<List<Teacher>>() {}.getType();
        //jsonHelper.exportToJSON(this.context, teachers, "teachers", typeClass);
    }

    public Teacher getTeacherId(int id){
        return databaseAdapter.getTeacherId(id);
    }

    public String[] GetListSurnameWithInitials(){
        List<Teacher> teacherList = databaseAdapter.getTeachers();
        if(teacherList == null || teacherList.size() == 0) return null;
        String[] surnameWithInitials = new String[teacherList.size()];
        for(int i = 0; i < teacherList.size(); i++){
            surnameWithInitials[i] = teacherList.get(i).GetSurnameWithInitials();
        }
        return surnameWithInitials;
    }

    public void closeDatabase(){ databaseAdapter.close();}

}
