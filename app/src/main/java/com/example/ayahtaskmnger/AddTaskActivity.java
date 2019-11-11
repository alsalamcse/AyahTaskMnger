package com.example.ayahtaskmnger;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

import com.example.ayahtaskmnger.data.MyTask;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddTaskActivity extends AppCompatActivity {

    private EditText etTitle,etSubject;
    private SeekBar skbrImportant;
    private Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtask);

        etTitle=findViewById(R.id.etTitle);
        btnSave=findViewById(R.id.btnSave);
        etSubject=findViewById(R.id.etSupject);
        skbrImportant=findViewById(R.id.skbrImportant);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataHandler();
            }

        });

    }

    public void dataHandler(){
        String title=etTitle.getText().toString();
        String sub=etSubject.getText().toString();
        int skb=skbrImportant.getProgress();
        boolean isok=true;
        if(title.length()<0){
            etTitle.setError("you have to write title");
            isok=false;
        }


        if(sub.length()<0)

        {
            etSubject.setError("you have to write supject");
            isok=false;


        }
        if(isok)
        {
            MyTask t=new MyTask();
            t.setTittle(title);
            creatMyTask(t);



        }


    }
    ////
//          private void creatMyTask(MyTask t) {
////        //1
//          FirebaseDatabas databas=FirebaseDatabas.getInstance();
////        //2
//          DatabaseReferencre referencre=database.getReferencre();
////    //7fed b data base
//           String key= reference.child("task").push.getKey();
//           reference.child("task").child(key).setValue(t);
//
////     }
    private void creatMyTask(MyTask t){
        FirebaseDatabase databas=FirebaseDatabase.getInstance();
        DatabaseReference reference=databas.getReference();
        FirebaseAuth auth=FirebaseAuth.getInstance();//top get the user id or other detais email
        String uid = auth.getCurrentUser().getUid();
        t.setOwner(uid);


        String  key= reference.child("task").child(uid).push().getKey();//(t7ded almfta7)
        reference.child("task").child(uid).child(key).setValue(t).addOnCompleteListener(AddTaskActivity.this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful())
                {

                    Toast.makeText(AddTaskActivity.this, "add successful", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else
                {
                    Toast.makeText(AddTaskActivity.this, "add failed", Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();

                }
            }
        });

    }


}
