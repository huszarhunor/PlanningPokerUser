package com.example.planningpokeruser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class VoteActivity extends AppCompatActivity {

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;

    TextView textViewQuestion;

    FirebaseDatabase database;
    DatabaseReference myRef;

    String code;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote);

        initialize();

        code = getIntent().getStringExtra("codeString");
        name = getIntent().getStringExtra("nameString");

        Log.d("vegre","nev:"+name);
        Log.d("vegre","kod:"+code);

        myRef.child("Aktiv").child(code).child("Kerdes").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String question = dataSnapshot.getValue().toString();
                textViewQuestion.setText(question);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child("Aktiv").child(code).child("Szavazatok").child("1").child(name).setValue("1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child("Aktiv").child(code).child("Szavazatok").child("2").child(name).setValue("2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child("Aktiv").child(code).child("Szavazatok").child("3").child(name).setValue("3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child("Aktiv").child(code).child("Szavazatok").child("4").child(name).setValue("4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child("Aktiv").child(code).child("Szavazatok").child("5").child(name).setValue("5");
            }
        });


    }

    private void initialize() {
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        textViewQuestion = findViewById(R.id.textViewQuestion);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
    }

}
