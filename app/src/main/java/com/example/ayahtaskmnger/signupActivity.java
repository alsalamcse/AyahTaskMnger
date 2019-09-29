package com.example.ayahtaskmnger;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;

        import com.google.android.gms.tasks.OnCompleteListener;
        import com.google.android.gms.tasks.Task;
        import com.google.firebase.auth.AuthResult;
        import com.google.firebase.auth.FirebaseAuth;

public class signupActivity extends AppCompatActivity {
    private EditText etFname, etLname, etEmail2, etPhone, etPassword2, etPassword1;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etFname = findViewById(R.id.etFname);
        etLname = findViewById(R.id.etLname);
        etEmail2 = findViewById(R.id.etEmail2);
        etPhone = findViewById(R.id.etPhone);
        etPassword1 = findViewById(R.id.etPassword1);
        etPassword2 = findViewById(R.id.etPassword2);
        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataHandler();
            }
        });


    }

    public void dataHandler() {
        boolean isok = true;//if all the fields well
        String email = etEmail2.getText().toString();
        String passwl = etPassword1.getText().toString();
        String passw2 = etPassword2.getText().toString();
        String fname = etFname.getText().toString();
        String lname = etLname.getText().toString();
        String phone = etPhone.getText().toString();

        if (email.length() < 4 ||
                email.indexOf('@') < 0 ||
                email.indexOf('.') < 0) {
            etEmail2.setError("Wrong Email");
            isok = false;

        }
        if (passwl.length() < 8 || passwl.equals(passw2)) {
            etPassword2.setError("Have to be at least 8 char and the same password");
            etPassword1.setError("Have to be at least 8 char and the same password");
            isok = false;

        }
        if (fname.length() == 0) {
            etFname.setError("enter name");
            isok = false;
        }
        if (isok) {
            creatAcount(email, passwl, lname, phone, fname)
            //creatAcount(email,passw1)
        }

    }



    private void creatAcount(String email, String passwl, String lname, String phone, String fname) {
        FirebaseAuth auth=FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(email,passwl).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        finish();
                        // entakl llshasha alraesea
                    }
                    else
                    {
                        etEmail2.setError("sign up failrd");
                    }

            }
        });
        // (bnaa) sign up


    }


//4.
}

