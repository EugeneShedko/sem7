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
import com.example.lab5.Models.Timetable;

public class MainActivity extends AppCompatActivity implements Fragment_list_lessons.OnFragmentListLessonListener, Fragment_change_select_lesson.OnFragmentSelectLessonListener {

    Fragment_list_lessons fragment_list_lessons;
    Fragment_change_select_lesson fragment_change_select_lesson;
    FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.container, Fragment_list_lessons.class,
                        savedInstanceState)
                .commit();

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
                fragmentManager.beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.fragmentSelectLesson, Fragment_change_select_lesson.class,
                                null)
                        .commit();
            fragmentManager.popBackStack();
        }

        getSupportActionBar().setTitle("MainActivity");

    }

    @Override
    public void onSendData(int position, Timetable timetable) {
        ItemTimetable selectedItem = timetable.getLessonId(position);
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            Intent intent = new Intent(this, ChangeLessonActivity.class);

            int idSelectItem = selectedItem.Id;

            intent.putExtra("idSelectItem", idSelectItem);

            startActivity(intent);
        }
        else {
            fragment_list_lessons = (Fragment_list_lessons) getSupportFragmentManager()
                    .findFragmentById(R.id.container);
            if (fragment_list_lessons != null){
                fragment_change_select_lesson = (Fragment_change_select_lesson) getSupportFragmentManager()
                        .findFragmentById(R.id.fragmentSelectLesson);
                if(fragment_change_select_lesson != null)
                    fragment_change_select_lesson.setSelectedItem(selectedItem);
            }
        }
    }

    @Override
    public void onSaveSelectData(ItemTimetable selectedItem) {
        fragment_list_lessons = (Fragment_list_lessons) getSupportFragmentManager()
                .findFragmentById(R.id.container);
        if (fragment_list_lessons != null){
            fragment_list_lessons.SaveDataList();
            fragmentManager.popBackStack();
        }
    }

    @Override
    public ItemTimetable getSelectItemTimeTable() {
        ItemTimetable itemTimetable = null;
        fragment_list_lessons = (Fragment_list_lessons) getSupportFragmentManager()
                .findFragmentById(R.id.container);
        if (fragment_list_lessons != null)
            itemTimetable = fragment_list_lessons.getFirstItem();
        return itemTimetable;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_ops, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        fragment_list_lessons = (Fragment_list_lessons) getSupportFragmentManager()
                .findFragmentById(R.id.container);
        switch (item.getItemId()) {
            case R.id.addLessonMenu:
                intent = new Intent(this, AddLessonActivity.class);
                startActivity(intent);
                return true;
            case R.id.addTeacherMenu:
                intent = new Intent(this, AddTeacherActivity.class);
                startActivity(intent);
                return true;
                case R.id.SortMenu:
                    if (fragment_list_lessons != null)
                        fragment_list_lessons.SortDefault();
                return true;
            case R.id.FirstNumWeekMenu:
                if (fragment_list_lessons != null)
                    fragment_list_lessons.viewLessonsNumWeek(1);
                return true;
            case R.id.SecondNumWeekMenu:
                if (fragment_list_lessons != null)
                    fragment_list_lessons.viewLessonsNumWeek(2);
                return true;
            case R.id.AllLessonnsMenu:
                if (fragment_list_lessons != null)
                fragment_list_lessons.viewAllLessons();
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