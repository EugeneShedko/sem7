package fit.bstu.by.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class BookInfoActivity extends AppCompatActivity {

    private Intent intent;
    private TextView publHome;
    private TextView genre;
    private TextView publDate;
    private TextView authName;
    private TextView bookQnt;
    private TextView authQnt;
    private TextView bookName;
    private TextView phone;
    private TextView mail;
    private TextView url;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_info);

        publHome = findViewById(R.id.publHomeValue);
        genre    = findViewById(R.id.genreValue);
        publDate = findViewById(R.id.publDateValue);
        authName = findViewById(R.id.authNameValue);
        bookQnt  = findViewById(R.id.bookQntValue);
        authQnt  = findViewById(R.id.authQntValue);
        bookName = findViewById(R.id.bookNameValue);
        phone    = findViewById(R.id.phoneValue);
        mail     = findViewById(R.id.mailValue);
        url      = findViewById(R.id.urlValue);

        intent = super.getIntent();
        Book book = Book.getAllBooks().get(intent.getIntExtra("index", 0));
        if(book != null)
        {
            publHome.setText(book.getPublHome());
            genre.setText(book.getGenre());
            publDate.setText(book.getPublDate());
            authName.setText(book.getNameAuth());
            bookQnt.setText(book.getBookQnt());
            authQnt.setText(book.getAuthQnt());
            bookName.setText(book.getBookName());
            phone.setText(book.getPhoneNumber());
            mail.setText(book.getMail());
            url.setText(book.getUrl());
        }
    }

    public void imageHandler(View view)
    {
        Intent intent = new Intent();
        intent.setAction(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);

        if(intent.resolveActivity(getPackageManager()) !=null)
        {
            startActivity(intent);
        }
    }
    public void urlHandler(View view)
    {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url.getText().toString()));

        if(intent.resolveActivity(getPackageManager()) !=null)
        {
            startActivity(intent);
        }
    }

    public void mailHandler(View view)
    {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, "Hello, world!");
        intent.setType("text/plain");

        if(intent.resolveActivity(getPackageManager()) != null)
        {
            startActivity(intent);
        }
    }

    public void phoneHandler(View view)
    {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phone.getText().toString()));
        if(intent.resolveActivity(getPackageManager()) != null)
        {
            startActivity(intent);
        }
    }
}