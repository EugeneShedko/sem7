package kad.fit.bstu.by.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class ThirdActivity extends AppCompatActivity {
    Button backToBirthdayActivityButton;
    Button toVerificationActivityButton;
    EditText carMileageEditText, engineTypeEditText, engineVolumeEditText;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        bundle = getIntent().getBundleExtra("car");

        Log.d("2222","2222");
        carMileageEditText = findViewById(R.id.carMileageEditText);
        engineTypeEditText = findViewById(R.id.engineTypeEditText);
        engineVolumeEditText = findViewById(R.id.engineVolumeEditText);

        carMileageEditText.setText(bundle.getString("carMileage",""));
        engineTypeEditText.setText(bundle.getString("engineType",""));
        engineVolumeEditText.setText(bundle.getString("engineVolume",""));

        toVerificationActivityButton = findViewById(R.id.toVerificationActivityButton);
        backToBirthdayActivityButton = findViewById(R.id.backToBirthdayActivityButton);




        toVerificationActivityButton.setOnClickListener(view -> {
            Intent intent= new Intent(getApplicationContext(), UserDataActivity.class);
            saveInfoInIntent(intent);
            startActivity(intent);
        });

        backToBirthdayActivityButton.setOnClickListener(view -> {
            Intent intent= new Intent(getApplicationContext(), BirthdayActivity.class);
            saveInfoInIntent(intent);
            startActivity(intent);
        });

    }


    public void saveInfoInIntent(Intent intent) {
        bundle.putString("carMileage", carMileageEditText.getText().toString());
        bundle.putString("engineType", engineTypeEditText.getText().toString());
        bundle.putString("engineVolume", engineVolumeEditText.getText().toString());
        intent.putExtra("car", bundle);
    }
}