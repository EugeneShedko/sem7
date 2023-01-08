package com.example.lab5.Models;

import java.io.Serializable;
import java.time.DayOfWeek;

public class ItemTimetable implements Serializable {

    public ItemTimetable(DayOfWeek dayOfWeek, int numberWeek, int numberAuditory, int korpus, String time, int teacher){
        this.dayOfWeek = dayOfWeek;
        this.numberWeek = numberWeek;
        this.numberAuditory = numberAuditory;
        this.korpus = korpus;
        this.startTime = time;
        this.teacherId = teacher;

    }

    public ItemTimetable(){}

    public int Id = 0;
    public DayOfWeek dayOfWeek;
    public int numberWeek;
    public int numberAuditory;
    public int korpus;
    public String startTime;
    public String endTime;
    public int teacherId;
    public String nameLesson;
    public boolean isStaticClass; //сделать метод переноса на другую дату и этот параметр устанавливается на фолс и удаляется занятие, после прошествия этой даты
    // и сделать проверку переносится ли занятие на постоянной основе или нет

    public DayOfWeek setDayOfWeek(int numDayOfWeek){
        dayOfWeek = DayOfWeek.of(numDayOfWeek);
        return dayOfWeek;
    }

}
