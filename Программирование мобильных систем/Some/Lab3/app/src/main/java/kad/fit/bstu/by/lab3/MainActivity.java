package kad.fit.bstu.by.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private final String[] types ={"Седан","Универсал","Хэтчбек","Кроссовер","Купе","Пикап","Кабриолет"};
    EditText carBrandEditText, carModelEditText;
    Button toBirthdayActivityButton;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bundle = getIntent().getBundleExtra("car");
        if (bundle == null) {
            bundle = new Bundle();
        }

        carBrandEditText = findViewById(R.id.carBrandEditText);
        carModelEditText = findViewById(R.id.carModelEditText);
        Spinner spinner = findViewById(R.id.spinner);

        carBrandEditText.setText(bundle.getString("carBrand", ""));
        carModelEditText.setText(bundle.getString("carModel", ""));

        toBirthdayActivityButton = findViewById(R.id.toBirthdayActivityButton);

        

        // Создаем адаптер ArrayAdapter с помощью массива строк и стандартной разметки элемета spinner
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, types);
        // Определяем разметку для использования при выборе элемента
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        for (int i=0;i<types.length;i++)
        {
            if(Objects.equals(types[i], bundle.getString("typeBody", "")))
            {
                spinner.setSelection(i);
                break;
            }
        }

        toBirthdayActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BirthdayActivity.class);
                bundle.putString("carBrand", carBrandEditText.getText().toString());
                bundle.putString("carModel", carModelEditText.getText().toString());
                bundle.putString("typeBody", spinner.getSelectedItem().toString());
                intent.putExtra("car", bundle);
                startActivity(intent);
            }
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
}