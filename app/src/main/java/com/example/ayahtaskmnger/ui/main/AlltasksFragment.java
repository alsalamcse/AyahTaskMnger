package com.example.ayahtaskmnger.ui.main;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ayahtaskmnger.R;
import com.example.ayahtaskmnger.data.MyTask;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class AlltasksFragment extends Fragment {


    public AlltasksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_alltasks, container, false);
    }

    public void readTasksFromeFirebase(){
        FirebaseDatabase database=FirebaseDatabase.getInstance();//to connect to database
        FirebaseAuth auth=FirebaseAuth.getInstance();//to get correct id
        String uid = auth.getUid();
        DatabaseReference reference = database.getReference();

        reference.child("task").child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //fe al datachange m3alg al7dth
                for (DataSnapshot d:dataSnapshot.getChildren()) {
                    MyTask t=d.getValue(MyTask.class);
                    Log.d("MyTask",t.toString());

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }

}
