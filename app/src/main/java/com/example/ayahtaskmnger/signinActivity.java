package com.example.ayahtaskmnger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class signinActivity extends AppCompatActivity {
    private EditText etEmail,etPassword;
    private Button btnsignin,btnsignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        etEmail=findViewById(R.id.etEmail);
        etPassword=findViewById(R.id.etPassword);
        btnsignin=findViewById(R.id.btnsignin);
        btnsignup=findViewById(R.id.btnsignup);

       // btnsignup.setOnClickListener((view){
                //Intent i=new Intent((getApplicationContext(),signupActivity))
        //});

        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataHndler();
            }
        });
        //2.
    }
    //1
    private void dataHndler(){
        String email=etEmail.getText().toString();
        String passw=etPassword.getText().toString();
        boolean isOk=true;
//        if(email.length()<4){
////            etEmail.setError("Email length error");
////            isOk=false;
////
////        }
////        if(email.indexOf("@")<0||email.indexOf(".")<0)
////        {
////            etEmail.setError("Email wrong format");
////            isOk=false;
////        }
        if(isValidEmailAddress(email)==false){
            etEmail.setError("Invalid Email");
            isOk=false;
        }
        if(passw.length()<8)
        {
            etPassword.setError("min lenght 8");
            isOk=false;


        }
        if(isOk){


        }
        //signIn(email,passw)
    }

    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }



    private void signIn(String email,String passw){
        FirebaseAuth auth=FirebaseAuth.getInstance();//need firebaseAuth when we do Email and Password
        auth.signInWithEmailAndPassword(email,passw);

    }

}
