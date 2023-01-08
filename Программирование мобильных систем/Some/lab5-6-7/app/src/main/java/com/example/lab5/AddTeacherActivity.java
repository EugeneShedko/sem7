package com.example.lab5;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab5.Models.Image;
import com.example.lab5.Models.Teacher;
import com.example.lab5.Models.TeacherList;
import android.view.View.OnClickListener;
import java.io.IOException;

public class AddTeacherActivity extends AppCompatActivity implements OnClickListener {
    ImageView IVPreviewImage;
    Teacher teacher;
    Button addTeacher;

    int SELECT_PICTURE = 200 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super .onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_teacher);
        teacher = new Teacher();

        this.IVPreviewImage = findViewById(R.id.IVPreviewImage);
        this.addTeacher = findViewById(R.id.addTeacherId);

        addTeacher.setOnClickListener((View.OnClickListener) this);

        //Видимо здесь устанавливается листенер, но что за он
        IVPreviewImage.setOnClickListener((View.OnClickListener) this);

        getSupportActionBar().setTitle("Add Teacher");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    void imageChooser() throws IOException {

        Intent i = new Intent();
        i.setType( "image/*" );
        i.setAction(Intent.ACTION_GET_CONTENT);

        startActivityForResult(Intent.createChooser(i, "Select Picture" ), SELECT_PICTURE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addTeacherId:
                this.teacher.firstName = ((EditText)findViewById(R.id.firstNameId)).getText().toString();
                this.teacher.lastName = ((EditText)findViewById(R.id.lastNameId)).getText().toString();
                this.teacher.patronymic = ((EditText)findViewById(R.id.PatronymicId)).getText().toString();

                Bitmap bitmap = ((BitmapDrawable)IVPreviewImage.getDrawable()).getBitmap();
                try {
                    this.teacher.pathImage = Image.getInstance().saveToInternalStorage(bitmap, this, teacher.GetSurnameWithInitials());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                TeacherList teacherList = new TeacherList(this);
                teacherList.AddTeacher(teacher);
                teacherList.closeDatabase();
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.IVPreviewImage:
                try {
                    imageChooser();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    //Когда ввызывается данный метод
    public void onActivityResult( int requestCode, int resultCode, Intent data) {
        super .onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {

            if (requestCode == SELECT_PICTURE) {

                Uri selectedImageUri = data.getData();
                if ( null != selectedImageUri) {

                    IVPreviewImage.setImageURI(selectedImageUri);
                }
            }
        }
    }

}
