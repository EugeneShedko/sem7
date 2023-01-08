package kad.fit.bstu.by.lab3;

import androidx.appcompat.app.AppCompatActivity;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;


import java.util.Calendar;

public class BirthdayActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    Button backToMainActivityButton;
    Button toThirdActivityButton, selectDateButton;
    EditText placeOfAssemblyEditText;
    TextView dateOfAssemblyTextView;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday);
        bundle = getIntent().getBundleExtra("car");

        dateOfAssemblyTextView = findViewById(R.id.dateOfAssemblyTextView);
        placeOfAssemblyEditText = findViewById(R.id.placeOfAssemblyEditText);

        backToMainActivityButton = findViewById(R.id.BackToMainActivityButton);
        toThirdActivityButton = findViewById(R.id.toThirdActivityButton);
        selectDateButton = findViewById(R.id.selectDateButton);

        dateOfAssemblyTextView.setText(bundle.getString("dateOfAssembly",""));
        placeOfAssemblyEditText.setText(bundle.getString("placeOfAssembly",""));


        selectDateButton.setOnClickListener(view -> showDatePickerDialog());


        toThirdActivityButton.setOnClickListener(view -> {
            Intent intent= new Intent(getApplicationContext(), ThirdActivity.class);
            saveInfoInIntent(intent);
            startActivity(intent);
        });

        backToMainActivityButton.setOnClickListener(view -> {
            Intent intent= new Intent(getApplicationContext(), MainActivity.class);
            saveInfoInIntent(intent);
            startActivity(intent);

        });
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    private void showDatePickerDialog(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
      String date = dayOfMonth + "/" + month + "/" +year;
        dateOfAssemblyTextView.setText(date);
    }

    public void saveInfoInIntent(Intent intent) {
        bundle.putString("placeOfAssembly", placeOfAssemblyEditText.getText().toString());
        bundle.putString("dateOfAssembly", dateOfAssemblyTextView.getText().toString());
        intent.putExtra("car", bundle);
    }

}