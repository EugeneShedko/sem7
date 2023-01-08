package com.example.lab5.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.lab5.ChangeLessonActivity;
import com.example.lab5.MainActivity;
import com.example.lab5.Models.ItemTimetable;
import com.example.lab5.Models.TeacherList;
import com.example.lab5.R;

public class Fragment_change_select_lesson extends Fragment implements View.OnClickListener {

    private OnFragmentSelectLessonListener onFragmentSelectLessonListener;
    public interface OnFragmentSelectLessonListener {
        void onSaveSelectData(ItemTimetable data);
        ItemTimetable getSelectItemTimeTable();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            onFragmentSelectLessonListener = (OnFragmentSelectLessonListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " должен реализовывать интерфейс OnFragmentInteractionListener");
        }
    }


    View view;
    TeacherList teacherList;

    ItemTimetable itemTimetable;

    Spinner techersSpiner, dayOfWeek, numWeek;
    EditText lesson, AuditoryNumber, KorpusNumber;
    EditText startTimePicker, endTimePicker;
    Button saveChange;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_lesson, container, false);

        techersSpiner = view.findViewById(R.id.teacherChange);
        dayOfWeek = view.findViewById(R.id.dayOfWeekIdChange);
        numWeek = view.findViewById(R.id.numWeekIdChange);
        lesson = view.findViewById(R.id.lessonNameChange);
        AuditoryNumber = view.findViewById(R.id.auditoryChange);
        KorpusNumber = view.findViewById(R.id.KorpusChange);
        startTimePicker = view.findViewById(R.id.startTimeChange);
        endTimePicker = view.findViewById(R.id.EndTimeChange);
        saveChange = view.findViewById(R.id.saveChange);

        saveChange.setOnClickListener((View.OnClickListener) this);
        itemTimetable = onFragmentSelectLessonListener.getSelectItemTimeTable();
        if(itemTimetable != null)
            setSelectedItem(itemTimetable);
        return view;

    }

    // обновление
    public void setSelectedItem(ItemTimetable selectedItem) {
        SetSpinnerTeacher(techersSpiner);
        itemTimetable = selectedItem;
        AuditoryNumber.setText(Integer.toString(itemTimetable.numberAuditory));
        lesson.setText(itemTimetable.nameLesson);
        KorpusNumber.setText(Integer.toString(itemTimetable.korpus));
        startTimePicker.setText(itemTimetable.startTime);
        endTimePicker.setText(itemTimetable.endTime);
        techersSpiner.setSelection(itemTimetable.teacherId);
        dayOfWeek.setSelection(itemTimetable.dayOfWeek.getValue() - 1);
        numWeek.setSelection(itemTimetable.numberWeek - 1);

        saveChange.setClickable(true);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.saveChange:
                SaveLesson();
                break;
        }
    }

    private void SaveLesson(){
        if(itemTimetable!= null){
            itemTimetable.startTime.format("HH:mm");
            itemTimetable.endTime.format("HH:mm");
            itemTimetable.startTime = startTimePicker.getText().toString();
            itemTimetable.endTime = endTimePicker.getText().toString();
            itemTimetable.teacherId = techersSpiner.getSelectedItemPosition();
            itemTimetable.setDayOfWeek(dayOfWeek.getSelectedItemPosition() + 1);
            itemTimetable.korpus =  Integer.parseInt(KorpusNumber.getText().toString());
            itemTimetable.numberAuditory =  Integer.parseInt(AuditoryNumber.getText().toString());
            itemTimetable.numberWeek = numWeek.getSelectedItemPosition() + 1;
            itemTimetable.nameLesson = lesson.getText().toString();

            onFragmentSelectLessonListener.onSaveSelectData(itemTimetable);
            saveChange.setClickable(false);
        }
        else{
            
        }
    }

    void SetSpinnerTeacher(Spinner teachers){
        teacherList = new TeacherList(getContext());
        String[] teacherArray = teacherList.GetListSurnameWithInitials();
        ArrayAdapter<String> adapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, teacherArray);
        // Определяем разметку для использования при выборе элемента
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        teachers.setAdapter(adapter);
    }

    public void onDestroy(){
        super.onDestroy();
        teacherList.closeDatabase();

    }
}
