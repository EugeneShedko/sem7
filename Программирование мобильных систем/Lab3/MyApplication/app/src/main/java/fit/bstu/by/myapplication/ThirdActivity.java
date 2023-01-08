package fit.bstu.by.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class ThirdActivity extends Activity {

    private Book book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        TextView param1 = findViewById(R.id.param1);
        TextView param2 = findViewById(R.id.param2);
        TextView param3 = findViewById(R.id.param3);
        TextView param4 = findViewById(R.id.param4);
        TextView param5 = findViewById(R.id.param5);
        TextView param6 = findViewById(R.id.param6);
        TextView param7 = findViewById(R.id.param7);

        Intent intent = super.getIntent();
        Bundle firstBundle  = intent.getBundleExtra("parameters1");
        Bundle secondBundle = intent.getBundleExtra("parameters2");

        param1.setText(firstBundle.getString("publHome"));
        param2.setText(firstBundle.getString("genre"));
        param3.setText(firstBundle.getString("publDate"));
        param4.setText(secondBundle.getString("name"));
        param5.setText(secondBundle.getString("nameuth"));
        param6.setText(secondBundle.getString("bookqnt"));
        param7.setText(secondBundle.getString("qntauth"));

        book = new Book(firstBundle.getString("publHome"), firstBundle.getString("genre"), firstBundle.getString("publDate"),
                             secondBundle.getString("name"), secondBundle.getString("nameuth"), secondBundle.getString("bookqnt"),
                             secondBundle.getString("qntauth"));
    }

    public void saveHandler(View view){
        Book.saveBook(book);
        Book.saveAllBooksIntoFile();
        Toast.makeText(this, "Сохранено в файл!", Toast.LENGTH_LONG).show();
    }
}