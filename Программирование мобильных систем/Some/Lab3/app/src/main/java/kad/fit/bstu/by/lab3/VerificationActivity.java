package kad.fit.bstu.by.lab3;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;

import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class VerificationActivity extends AppCompatActivity {
    private final String path = "car.json";
    Bundle bundle;
    File file;

    //region Initialization
    Button backToThirdActivityButton;
    Button confirmButton;
    Button openButton;
    TextView confirmCarBrandTextView, confirmCarModelTextView, confirmTypeBodyTextView,
            confirmPlaceOfAssemblyTextView, confirmDateOfAssemblyTextView, confirmCarMileageTextView,
            confirmEngineTypeTextView, confirmEngineVolumeTextView;

    private ArrayAdapter<Car> adapter;
    private List<Car> cars;
    ListView listView;
    Context context= this.context;

    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);
        bundle = getIntent().getBundleExtra("car");
        Intent intent2 = new Intent(this, CarInformationActivity.class);
        cars = JSONHelper.importFromJSON(this);
        if(cars==null){
            cars=new ArrayList<>();
        }

        listView = findViewById(R.id.outJson);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cars);
        listView.setAdapter(adapter);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Car carInformation = (Car) parent.getItemAtPosition(i);
                intent2.putExtra("carInformation", carInformation);
                startActivity(intent2);
            }
        };
        listView.setOnItemClickListener(itemClickListener);


        //region findViewById()
        confirmCarBrandTextView = findViewById(R.id.confirmCarBrandTextView);
        confirmCarModelTextView = findViewById(R.id.confirmCarModelTextView);
        confirmTypeBodyTextView = findViewById(R.id.confirmTypeBodyTextView);
        confirmPlaceOfAssemblyTextView = findViewById(R.id.confirmPlaceOfAssemblyTextView);
        confirmDateOfAssemblyTextView = findViewById(R.id.confirmDateOfAssemblyTextView);
        confirmCarMileageTextView = findViewById(R.id.confirmCarMileageTextView);
        confirmEngineTypeTextView = findViewById(R.id.confirmEngineTypeTextView);
        confirmEngineVolumeTextView = findViewById(R.id.confirmEngineVolumeTextView);
        confirmButton = findViewById(R.id.confirmButton);
        openButton = findViewById(R.id.openButton);
        backToThirdActivityButton = findViewById(R.id.backToThirdActivityButton);
        //endregion()


        backToThirdActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), UserDataActivity.class);
                intent.putExtra("car", bundle);
                startActivity(intent);
            }
        });
    }
    public void save(View view){
        //region Bundle
        Bundle bundle = getIntent().getBundleExtra("car");
        String carBrand = bundle.getString("carBrand");
        String carModel = bundle.getString("carModel");
        String typeBody = bundle.getString("typeBody");
        String placeOfAssembly = bundle.getString("placeOfAssembly");
        String dateOfAssembly = bundle.getString("dateOfAssembly");
        String carMileage = bundle.getString("carMileage");
        String engineType = bundle.getString("engineType");
        String engineVolume = bundle.getString("engineVolume");
        String email=bundle.getString("email");;
        String phone=bundle.getString("phone");;
        String link=bundle.getString("link");;
        //endregion

        //region setText()
        confirmCarBrandTextView.setText("Марка: " + carBrand);
        confirmCarModelTextView.setText("Модель: " + carModel);
        confirmTypeBodyTextView.setText("Тип кузова: " + typeBody);
        confirmPlaceOfAssemblyTextView.setText("Место сборки: " + placeOfAssembly);
        confirmDateOfAssemblyTextView.setText("Дата сборки: " +  dateOfAssembly);
        confirmCarMileageTextView.setText("Пробег : " + carMileage);
        confirmEngineTypeTextView.setText("Тип двигателя: " + engineType);
        confirmEngineVolumeTextView.setText("Объем двигателя: " + engineVolume);
        //endregion

        Gson gson = new Gson();
        Car car = new Car(carBrand, carModel,  typeBody, placeOfAssembly,
                dateOfAssembly, carMileage, engineType, engineVolume,phone,email,link);

        cars.add(car);


        boolean result = JSONHelper.exportToJSON(this, cars);
        if(result){
            Toast.makeText(this, "Данные сохранены", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Не удалось сохранить данные", Toast.LENGTH_LONG).show();
        }
    }

    public void open(View view){
        cars = JSONHelper.importFromJSON(this);
        if(cars!=null){
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cars);
            listView.setAdapter(adapter);
            Toast.makeText(this, "Данные восстановлены", Toast.LENGTH_LONG).show();
            adapter.notifyDataSetChanged();
        }
        else{
            cars=new ArrayList<>();
            Toast.makeText(this, "Не удалось открыть данные", Toast.LENGTH_LONG).show();
        }

    }
}