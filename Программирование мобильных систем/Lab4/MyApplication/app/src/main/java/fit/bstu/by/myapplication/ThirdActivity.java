package fit.bstu.by.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class ThirdActivity extends Activity {

    private TextView param1;
    private TextView param2;
    private TextView param3;
    private TextView param4;
    private TextView param5;
    private TextView param6;
    private TextView param7;
    private TextView phone;
    private TextView mail;
    private TextView url;
    private ListView booksList;

    private Bundle firstBundle;
    private Bundle secondBundle;
    private Book book;
    private ArrayList<String>    booksName;
    private ArrayList<Book>      desBooksList;
    private ArrayAdapter<String> booksAdapter;

    //Может пропадать номер телефона при переключениях активаностей, потом подумать над этим
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        booksName = new ArrayList<String>();
        if(savedInstanceState == null)
        {
            desBooksList = Serializer.jsonDeserializer("BookList.json");
            if(desBooksList != null)
            {
                Book.addAllBooks(desBooksList);
                for(int i = 0; i < desBooksList.size(); i++)
                {
                    booksName.add(desBooksList.get(i).getBookName());
                }
            }
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Intent intent = super.getIntent();
        firstBundle  = intent.getBundleExtra("parameters1");
        secondBundle = intent.getBundleExtra("parameters2");

        param1    = findViewById(R.id.param1);
        param2    = findViewById(R.id.param2);
        param3    = findViewById(R.id.param3);
        param4    = findViewById(R.id.param4);
        param5    = findViewById(R.id.param5);
        param6    = findViewById(R.id.param6);
        param7    = findViewById(R.id.param7);
        booksList = findViewById(R.id.bookList);
        phone     = findViewById(R.id.phone);
        mail      = findViewById(R.id.mail);
        url       = findViewById(R.id.url);


        param1.setText(firstBundle.getString("publHome"));
        param2.setText(firstBundle.getString("genre"));
        param3.setText(firstBundle.getString("publDate"));
        param4.setText(secondBundle.getString("name"));
        param5.setText(secondBundle.getString("bookname"));
        param6.setText(secondBundle.getString("bookqnt"));
        param7.setText(secondBundle.getString("qntauth"));

        booksAdapter = new ArrayAdapter<String>(this, R.layout.simple_list_item_1, booksName);
        booksList.setAdapter(booksAdapter);

        Intent intentifo = new Intent(this, BookInfoActivity.class);
        booksList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                intentifo.putExtra("index", position);
                intentifo.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intentifo);
            }
        });
    }

    @Override
    public void onRestoreInstanceState(Bundle saveInstance)
    {
        super.onRestoreInstanceState(saveInstance);
        booksName.addAll(saveInstance.getStringArrayList("listview"));
        booksAdapter.notifyDataSetChanged();
    }

    @Override
    public void onSaveInstanceState(Bundle saveInstanceState)
    {
        super.onSaveInstanceState(saveInstanceState);
        saveInstanceState.putStringArrayList("listview", booksName);
    }

    public void saveHandler(View view){

        book = new Book(firstBundle.getString("publHome"), firstBundle.getString("genre"), firstBundle.getString("publDate"),
                        secondBundle.getString("name"), secondBundle.getString("bookqnt"),secondBundle.getString("qntauth"),
                        secondBundle.getString("bookname"), phone.getText().toString(), mail.getText().toString(), url.getText().toString());

        Book.addBook(book);
        Serializer.jsonSerialize(Book.getAllBooks(), "BookList.json");

        Toast.makeText(this, "Сохранено в файл!", Toast.LENGTH_LONG).show();

        booksName.add(book.getBookName());
        booksAdapter.notifyDataSetChanged();
    }
}