package fit.bstu.by.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.Spinner;
import android.widget.Toast;

import java.sql.Date;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void NextHandler(View viw){
        Bundle bundle = GetDataActivity();
        Intent intent = new Intent(this, SecondActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        intent.putExtra("parameters", bundle);
        startActivity(intent);
    }

    private Bundle GetDataActivity() {
        Spinner publHome = findViewById(R.id.PublHome);
        Spinner genre    = findViewById(R.id.genre);
        CalendarView publDate = findViewById(R.id.publDate);
        Bundle bundle = new Bundle();

        bundle.putString("publHome", publHome.getSelectedItem().toString());
        bundle.putString("genre", genre.getSelectedItem().toString());
        bundle.putString("publDate", String.valueOf(new Date(publDate.getDate())));

        return  bundle;

    }
}