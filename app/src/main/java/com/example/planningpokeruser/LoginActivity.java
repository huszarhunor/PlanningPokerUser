package com.example.planningpokeruser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText editTextName;
    EditText editTextCode;
    Button buttonEnter;

    String code;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);

        initialize();

        buttonEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code = editTextCode.getText().toString();
                name = editTextCode.getText().toString();
                Intent intent = new Intent(getApplicationContext(), VoteActivity.class);
                intent.putExtra("codeString",code);
                intent.putExtra("nameString",name);
                startActivity(intent);
            }
        });
    }

    private void initialize() {
        editTextName = findViewById(R.id.editTextName);
        editTextCode = findViewById(R.id.editTextCode);
        buttonEnter = findViewById(R.id.buttonEnter);
    }
}
