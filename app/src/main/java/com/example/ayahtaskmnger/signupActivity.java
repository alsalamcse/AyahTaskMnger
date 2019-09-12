package com.example.ayahtaskmnger;

        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.widget.Button;
        import android.widget.EditText;

public class signupActivity extends AppCompatActivity {
    private EditText etFname,etLname,etEmail,etPhone,etPassword,etRewitePassword;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etFname=findViewById(R.id.etFname);
        etLname=findViewById(R.id.etLname);
        etEmail=findViewById(R.id.etEmail);
        etPhone=findViewById(R.id.etPhone);
        etPassword=findViewById(R.id.etPassword);
        etRewitePassword=findViewById(R.id.etRewitePassword);
        btnSave=findViewById(R.id.btnSave);

    }
}
