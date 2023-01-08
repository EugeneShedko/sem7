package com.example.lab5.Fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.lab5.Adapters.LessonsAdapter;
import com.example.lab5.Models.ItemTimetable;
import com.example.lab5.Models.Timetable;
import com.example.lab5.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Fragment_list_lessons extends Fragment {
    int selectLessonId;
    Timetable timetable;
    ListView lessonsList;
    List<ItemTimetable> sortTimeTable;

    View view;

    public Fragment_list_lessons(){
        super(R.layout.fragment_list_lessons);
    }

    public interface OnFragmentListLessonListener {
        void onSendData(int position, Timetable timetable);
    }

    private OnFragmentListLessonListener fragmentSendDataListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            fragmentSendDataListener = (OnFragmentListLessonListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " должен реализовывать интерфейс OnFragmentInteractionListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");

        view = inflater.inflate( R.layout.fragment_list_lessons, container, false);
        Bundle extras = getActivity().getIntent().getExtras();
        if (extras != null)
            selectLessonId = extras.getInt("idSelectItem");
        else
            selectLessonId = 0;

        lessonsList = view.findViewById(R.id.productList);
        timetable = new Timetable(getContext());
        sortTimeTable = timetable.getListLessons();
        setListLessons(sortTimeTable);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    private void setListLessons(List<ItemTimetable> itemsWeek) {

        LessonsAdapter adapter = new LessonsAdapter(getContext(), R.layout.item_list, itemsWeek);
        lessonsList.setAdapter(adapter);
        registerForContextMenu(lessonsList);
        lessonsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                // по позиции получаем выбранный элемент
                ItemTimetable selectedItem = itemsWeek.get(position);
                selectLessonId = selectedItem.Id;
                fragmentSendDataListener.onSendData(selectLessonId, timetable);
            }
        });
    }

    public void SortDefault(){
        sortTimeTable = new ArrayList<>(timetable.getListLessons());
        Collections.sort(sortTimeTable, new Comparator<ItemTimetable>() {
            public int compare(ItemTimetable o1, ItemTimetable o2) {
                return o1.dayOfWeek.getValue() < o2.dayOfWeek.getValue() ? -1 : (o1.dayOfWeek.getValue() > o2.dayOfWeek.getValue()) ? 1 : 0;
            }
        });
        setListLessons(sortTimeTable);
    }

    public void viewAllLessons(){
        setListLessons(timetable.getListLessons());
    }

    public void viewLessonsNumWeek(int num){
        setListLessons(timetable.getListLessonsNumWeek(num));
    }

    public void SaveDataList(){
       timetable.Save();
       setListLessons(sortTimeTable);
    }

    public ItemTimetable getFirstItem(){
        if (sortTimeTable != null && sortTimeTable.size() != 0)
            return sortTimeTable.get(0);
        return null;
    }

    //context menu
    public static final int IDM_OPEN = 101;
    public static final int IDM_REMOVE = 102;

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(Menu.NONE, IDM_OPEN, Menu.NONE, "Открыть");
        menu.add(Menu.NONE, IDM_REMOVE, Menu.NONE, "Удалить");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case IDM_OPEN:

                fragmentSendDataListener.onSendData(selectLessonId, timetable);
                break;
            case IDM_REMOVE:
                showDialog();

                break;
            default:
                return super.onContextItemSelected(item);
        }

        return true;
    }

    void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage("Are you sure?").setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();
    }

    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which) {
                case DialogInterface.BUTTON_POSITIVE:
                    ItemTimetable selectedItem = timetable.getLessonId(selectLessonId);
                    timetable.RemoveLesson(selectedItem);
                    break;

                case DialogInterface.BUTTON_NEGATIVE:
                    //No button clicked
                    break;
            }
        }
    };

String TAG = "fragmentList";
    //delete last
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("fragmentList", "onCreate");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView");
    }

    public void onDestroy(){
        super.onDestroy();
        timetable.closeDatabase();

    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach");
    }
}
