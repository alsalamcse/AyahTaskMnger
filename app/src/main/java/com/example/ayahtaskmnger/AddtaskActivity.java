package com.example.ayahtaskmnger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

public abstract class AddtaskActivity extends AppCompatActivity {
    private EditText etTitle,etSubject;
    private SeekBar skbrImportant;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtask);

        etTitle=findViewById(R.id.etTitel);
        etSubject=findViewById(R.id.etSupject);
        skbrImportant=findViewById(R.id.skbrImportant);
        btnSave=findViewById(R.id.btnSave);

    }


}
