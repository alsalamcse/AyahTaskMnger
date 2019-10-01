package com.example.ayahtaskmnger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

public abstract class AddtaskActivity extends AppCompatActivity {
    private EditText etTitle,etSubject;
    private SeekBar skbrImportant;
    private Button btnSave;
    private Object FirebaseDatabas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtask);

        etTitle=findViewById(R.id.etTitel);
        etSubject=findViewById(R.id.etSupject);
        skbrImportant=findViewById(R.id.skbrImportant);
        btnSave=findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener()
        {
              @Override
               public void onClick(View v) {
                 Intent i = new Intent(getApplication(), TempAllTaskActivity.class);
                 startActivity(i);
                   }
        });


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
            t.setTitle(title);
           // creatMyTask(t);



        }


    }
////
////    private void creatMyTask(MyTask t) {
////        //1
////        FirebaseDatabas databas=FirebaseDatabas.getInstance();
////        //2
////        DatabaseReferencre referencre=database.getReferencre();
////    //7fed b data base
////        String key= reference.child("task").push.getKey();
//           reference.child("task").child(key).setValue(t);
//
////    }




}
