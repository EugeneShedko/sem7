package com.example.lab5.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.lab5.Models.ItemTimetable;
import com.example.lab5.Models.TeacherList;
import com.example.lab5.R;

import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

public class LessonsAdapter extends ArrayAdapter<ItemTimetable> {
    private LayoutInflater inflater;
    private int layout;
    private List<ItemTimetable> timetable;
    private TeacherList  teacherList;

    public LessonsAdapter(Context context, int resource, List<ItemTimetable> timetablein) {
        super(context, resource, timetablein);
        this.timetable = timetablein;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
        teacherList = new TeacherList(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder viewHolder;
        if(convertView==null){
            convertView = inflater.inflate(this.layout, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final ItemTimetable itemTimetable = timetable.get(position);

        viewHolder.auditory.setText(Integer.toString(itemTimetable.numberAuditory));
        viewHolder.nameLesson.setText(itemTimetable.nameLesson);
        viewHolder.korpus.setText(Integer.toString(itemTimetable.korpus));
        viewHolder.time.setText(itemTimetable.startTime + " : " + itemTimetable.endTime);
        viewHolder.teacher.setText(teacherList.getTeacherId(itemTimetable.teacherId).GetSurnameWithInitials());
        viewHolder.dayOfweek.setText(itemTimetable.dayOfWeek.getDisplayName(TextStyle.FULL, new Locale("ru", "RU")));
        viewHolder.numOfWeek.setText(Integer.toString(itemTimetable.numberWeek));

        return convertView;
    }
    private class ViewHolder {
        //final Button removeButton;
        final TextView nameLesson, auditory, korpus, time, teacher, dayOfweek, numOfWeek;

        ViewHolder(View view){
            //removeButton = view.findViewById(R.id.removeButton);
            nameLesson = view.findViewById(R.id.nameLessonlist);
            auditory = view.findViewById(R.id.auditoryIdlist);
            korpus = view.findViewById(R.id.korpusIdlist);
            time = view.findViewById(R.id.timeIdlist);
            teacher = view.findViewById(R.id.teacherIdlist);
            dayOfweek = view.findViewById(R.id.dayOfWeeekIdlist);
            numOfWeek = view.findViewById(R.id.listnumWeek);
            //removeButton = view.findViewById(R.id.removeButtonList);

        }
    }
}
