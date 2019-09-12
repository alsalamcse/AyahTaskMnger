package com.example.ayahtaskmnger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Switch;

public class settingActivity extends AppCompatActivity {
    private Switch switch1;
    private SeekBar skbrFontsize;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        switch1=findViewById(R.id.switch1);
        skbrFontsize=findViewById(R.id.skbrFontsize);
        btnSave=findViewById(R.id.btnSave);
    }
}
