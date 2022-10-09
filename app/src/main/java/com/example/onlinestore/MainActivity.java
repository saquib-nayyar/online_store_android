package com.example.onlinestore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText userName, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        userName = (EditText)findViewById(R.id.editTextTextPersonName);
        password = (EditText)findViewById(R.id.editTextTextPassword);
    }

    public void loginAction(View view) {
        if (userName.getText().toString().isEmpty() && password.getText().toString().isEmpty()) {
            userName.setError("Please Enter Username");
            password.setError("Please Enter Password");
            Toast.makeText(this,"Please Fill Credential",Toast.LENGTH_LONG).show();
        } else if (userName.getText().toString().isEmpty()) {
            userName.setError("Please Enter Username");
        } else if (password.getText().toString().isEmpty()) {
            password.setError("Please Enter Password");
        } else {
            Toast.makeText(this,"Login Successful",Toast.LENGTH_LONG).show();
            Intent navigationActivity  = new Intent(MainActivity.this, NavigationActivity.class);
            startActivity(navigationActivity);
        }
    }
}