package fit.bstu.by.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends Activity {
    private String sqntauth;
    private Bundle firstBundle;
    private SeekBar seekBar;
    private EditText name;
    private RadioGroup radioGroup;
    private TextView bookqnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = super.getIntent();
        firstBundle = intent.getBundleExtra("parameters");
        TextView fparam  = findViewById(R.id.fparam1);
        TextView fparam1 = findViewById(R.id.fparam2);
        TextView fparam2 = findViewById(R.id.fparam3);
        seekBar          = findViewById(R.id.seekBar);
        name             = findViewById(R.id.name);
        radioGroup       = findViewById(R.id.qntauth);
        bookqnt          = findViewById(R.id.qnt);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                bookqnt.setText(String.valueOf(progress));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                sqntauth = String.valueOf(radioButton.getText());
            }
        });

        fparam.setText(firstBundle.getString("publHome"));
        fparam1.setText(firstBundle.getString("genre"));
        fparam2.setText(firstBundle.getString("publDate"));
    }

    public void NextHandler(View view) {

        EditText bookname      = findViewById(R.id.bookname);
        Bundle secondBundle   = new Bundle();
        Intent intent         = new Intent(this, ThirdActivity.class);

        secondBundle.putString("name", name.getText().toString());
        secondBundle.putString("bookname", bookname.getText().toString());
        secondBundle.putString("bookqnt", String.valueOf(seekBar.getProgress()));
        secondBundle.putString("qntauth", sqntauth);
        intent.putExtra("parameters1", firstBundle);
        intent.putExtra("parameters2", secondBundle);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }

    public void BackHandler(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }
}