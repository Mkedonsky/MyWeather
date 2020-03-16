package ru.mkedonsky.myweather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private ImageView imageView;
    private Switch tempSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setOnSwitchChanged();
    }
    private void initViews() {
        textView = findViewById(R.id.textView);
        textView = findViewById(R.id.tempView);
        textView = findViewById(R.id.windView);
        textView = findViewById(R.id.pressureView);
        imageView = findViewById(R.id.imageView3);
        imageView = findViewById(R.id.imageView);


        int orientation = getResources().getConfiguration().orientation;
        if (orientation != Configuration.ORIENTATION_LANDSCAPE) {
            tempSwitch = findViewById(R.id.switch1);
        }

    }
    private void setOnSwitchChanged() {
        int orientation = getResources().getConfiguration().orientation;
        if (orientation != Configuration.ORIENTATION_LANDSCAPE) {
           tempSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    String text;
                    if(isChecked) {
                        text = getString(R.string._5);
                    } else {
                        text = getString(R.string._F);
                    }

                    textView.setText(text);
                }
            });
        }
    }
}
