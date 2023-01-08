package fit.bstu.by.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar  seekBar      = findViewById(R.id.seekBar2);
        EditText editTextView = findViewById(R.id.editTextTextPersonName);
        Button button         = findViewById(R.id.button);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                editTextView.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    public void CalculateLoanAmount(View view){
        Double resultSum;
        Double monthSum;
        TextView resultAmount  = findViewById(R.id.ResultAmount);
        TextView monthPlat     = findViewById(R.id.MonthPlat);
        SeekBar  seekBar       = findViewById(R.id.seekBar2);
        EditText editText      = findViewById(R.id.Stavka);
        Spinner  countOfYear   = findViewById(R.id.CountOfYear);

        resultSum = seekBar.getProgress() * ((Double.valueOf(editText.getText().toString()) / 100));
        monthSum  = (resultSum / (Double.valueOf(countOfYear.getSelectedItem().toString()) * 12));

        resultAmount.setText(String.format("%.2f", resultSum));
        monthPlat.setText(String.format("%.2f", monthSum));

    }
}