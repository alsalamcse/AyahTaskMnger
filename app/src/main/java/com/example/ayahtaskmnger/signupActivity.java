package com.example.ayahtaskmnger;

        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.widget.Button;
        import android.widget.EditText;

public class signupActivity extends AppCompatActivity {
    private EditText etFname,etLname,etEmail2,etPhone,etPassword2,etPassword1;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etFname=findViewById(R.id.etFname);
        etLname=findViewById(R.id.etLname);
        etEmail2=findViewById(R.id.etEmail2);
        etPhone=findViewById(R.id.etPhone);
        etPassword1=findViewById(R.id.etPassword2);
        etPassword2=findViewById(R.id.etPassword2);
        btnSave=findViewById(R.id.btnSave);




    }
    public void dataHandler(){
        boolean isok=true;//if all the fields well
        String email=etEmail2.getText().toString();
        String passwl=etPassword2.getText().toString();
        String passw2=etPassword2.getText().toString();
        String fname=etFname.getText().toString();
        String lname=etLname.getText().toString();
        String phone=etPhone.getText().toString();
        if(email.length()<4 ||
                email.indexOf('@')<0 ||
                email.indexOf('.')<0){
            etEmail2.setError("Wrong Email");
            isok=false;

        }
        if(passwl.length()<8||passwl.equals(passw2)){
            etPassword2.setError("Have to be at least 8 char and the same password");

        }

        }


    }
}
