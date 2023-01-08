package com.example.lab5;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.lab5.Fragments.Fragment_change_select_lesson;
import com.example.lab5.Fragments.Fragment_list_lessons;
import com.example.lab5.Models.ItemTimetable;
import com.example.lab5.Models.TeacherList;
import com.example.lab5.Models.Timetable;

public class ChangeLessonActivity extends AppCompatActivity implements Fragment_change_select_lesson.OnFragmentSelectLessonListener {

    FragmentManager fragmentManager = getSupportFragmentManager();
    Fragment_change_select_lesson fragment_change_select_lesson;
    private Timetable timetable;
    private ItemTimetable itemTimetable;

    protected void onCreate(Bundle savedInstanceState) {
        savedInstanceState = getIntent().getExtras();
        super.onCreate(savedInstanceState);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

            finish();

            return;
        }

        setContentView(R.layout.activity_edit_lesson);
        timetable = new Timetable(this);
        Bundle arguments = getIntent().getExtras();
        int idSelectItem = (int)arguments.get("idSelectItem");
        itemTimetable = timetable.getLessonId(idSelectItem);

        fragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.container_change_select_lesson, Fragment_change_select_lesson.class,
                        arguments)
                .commit();

        //fragment_change_select_lesson = (Fragment_change_select_lesson) getSupportFragmentManager()
        //        .findFragmentById(R.id.fragmentSelectLesson);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public ItemTimetable getSelectItemTimeTable() {
        return itemTimetable;
    }

    @Override
    public void onSaveSelectData(ItemTimetable data) {
        timetable.updateLesson(data);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_back, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.buttonUpMenu:
                this.finish();
                return true;


        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        int count = fragmentManager.getBackStackEntryCount();
        if (count == 0) {
            super.onBackPressed();
            //additional code
        } else {
            fragmentManager.popBackStack();
        }

    }



}
