package kad.fit.bstu.by.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class UserDataActivity extends AppCompatActivity {
    EditText phone, email, link;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);
        bundle = getIntent().getBundleExtra("car");

        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        link = findViewById(R.id.link);

        phone.setText(bundle.getString("phone",""));
        email.setText(bundle.getString("email",""));
        link.setText(bundle.getString("link",""));
    }

    public void nextPage(View v) {
        Intent intent = new Intent(this, VerificationActivity.class);
        saveInfoInIntent(intent);
        startActivity(intent);
    }

    public void backPage(View v) {
        Intent intent = new Intent(this, ThirdActivity.class);
        saveInfoInIntent(intent);
        startActivity(intent);
    }

    public void saveInfoInIntent(Intent intent) {
        bundle.putString("phone", phone.getText().toString());
        bundle.putString("email", email.getText().toString());
        bundle.putString("link", link.getText().toString());
        intent.putExtra("car", bundle);
    }

}