package com.example.lab5;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab5.Models.ItemTimetable;
import com.example.lab5.Models.TeacherList;
import com.example.lab5.Models.Timetable;

public class AddLessonActivity extends AppCompatActivity implements OnClickListener{
    Spinner techersSpiner, dayOfWeek, numWeek;
    EditText lesson, AuditoryNumber, KorpusNumber;
    TimePicker startTimePicker, endTimePicker;
    Button addLesson;
    TeacherList teacherList;
    Timetable timeTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lesson);

        techersSpiner = findViewById(R.id.TeacherListId);
        lesson = findViewById(R.id.lesson);
        AuditoryNumber = findViewById(R.id.AuditoryNumber);
        KorpusNumber = findViewById(R.id.KorpusNumber);
        dayOfWeek = findViewById(R.id.dayOfWeekId);
        numWeek = findViewById(R.id.numWeekId);
        startTimePicker = findViewById(R.id.timeStartId);
        endTimePicker = findViewById(R.id.timeEndId);
        addLesson = (Button)findViewById(R.id.AddLessonId);

        startTimePicker.setIs24HourView(true);
        endTimePicker.setIs24HourView(true);

        addLesson.setOnClickListener((View.OnClickListener) this);
        startTimePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                int hours = startTimePicker.getHour() + 1;
                int minutes = startTimePicker.getMinute() + 20;
                if(minutes >= 60)
                {
                    minutes -= 60;
                    hours += 1;
                    hours = hours >= 24 ? hours - 24 : hours;
                }

              endTimePicker.setHour(hours);
              endTimePicker.setMinute(minutes);
            }
        });

        SetSpinnerTeacher(techersSpiner);
        timeTable = new Timetable(this);
        getSupportActionBar().setTitle("Add Lesson");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.AddLessonId:
                AddLesson();
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void AddLesson(){
        ItemTimetable itemTimetable = new ItemTimetable();
        itemTimetable.startTime.format("HH:mm");
        itemTimetable.endTime.format("HH:mm");
        itemTimetable.startTime = startTimePicker.getHour() + ":" + startTimePicker.getMinute();
        itemTimetable.endTime = endTimePicker.getHour() + ":" + endTimePicker.getMinute();
        itemTimetable.teacherId = techersSpiner.getSelectedItemPosition();
        itemTimetable.setDayOfWeek(dayOfWeek.getSelectedItemPosition() + 1);
        itemTimetable.korpus =  Integer.parseInt(KorpusNumber.getText().toString());
        itemTimetable.numberAuditory =  Integer.parseInt(AuditoryNumber.getText().toString());
        itemTimetable.numberWeek = numWeek.getSelectedItemPosition() + 1;
        itemTimetable.nameLesson = lesson.getText().toString();

        timeTable.AddLesson(itemTimetable);

    }

    void SetSpinnerTeacher(Spinner teachers){
        teacherList = new TeacherList(this);
        String[] teacherArray = teacherList.GetListSurnameWithInitials();
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, teacherArray);
        // Определяем разметку для использования при выборе элемента
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        teachers.setAdapter(adapter);
    }

    public void onDestroy(){
        super.onDestroy();
        timeTable.closeDatabase();
        teacherList.closeDatabase();
    }
}
