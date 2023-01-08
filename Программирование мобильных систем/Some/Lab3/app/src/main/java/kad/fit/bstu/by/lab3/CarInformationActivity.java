package kad.fit.bstu.by.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CarInformationActivity extends AppCompatActivity {
    TextView carBrand, carModel, typeBody, placeOfAssembly, dateOfAssembly, carMileage, engineType,
    engineVolume, phone, email,link;
    Car car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_information);

        Bundle bundle = getIntent().getExtras();
        car = (Car) bundle.getSerializable("carInformation");

        carBrand = findViewById(R.id.carBrand);
        carModel = findViewById(R.id.carModel);
        typeBody = findViewById(R.id.typeBody);
        placeOfAssembly = findViewById(R.id.placeOfAssembly);
        dateOfAssembly = findViewById(R.id.dateOfAssembly);
        carMileage = findViewById(R.id.carMileage);
        engineType = findViewById(R.id.engineType);
        engineVolume = findViewById(R.id.engineVolume);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        link = findViewById(R.id.link);

        carBrand.setText(car.getCarBrand());
        carModel.setText(car.getCarModel());
        typeBody.setText(car.getTypeBody());
        placeOfAssembly.setText(car.getPlaceOfAssembly());

        dateOfAssembly.setText(car.getDateOfAssembly());
        carMileage.setText(car.getCarMileage());
        engineType.setText(car.getEngineType());
        engineVolume.setText(car.getEngineVolume());

        phone.setText(car.getPhone());
        email.setText(car.getEmail());
        link.setText(car.getLink());

    }

    public void goPhone(View v) {
        Intent intent = new Intent(Intent.ACTION_DIAL,
                Uri.parse("tel:" + phone.getText().toString()));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        startActivity(intent);
    }

    public void goEmail(View v) {
        final Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setType("plain/text");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{email.getText().toString()});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Lector");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email text");

        startActivity(Intent.createChooser(emailIntent, "Send mail..."));
    }

    public void goSocialNet(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www." + car.getLink()));
        startActivity(intent);
    }

    public void back(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}