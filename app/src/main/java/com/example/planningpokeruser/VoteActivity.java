package com.example.planningpokeruser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class VoteActivity extends AppCompatActivity {

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;

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

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child("Aktiv").child("123").child("Szavazatok").child("1").setValue(name);
            }
        });


    }

    private void initialize() {
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
    }

}
