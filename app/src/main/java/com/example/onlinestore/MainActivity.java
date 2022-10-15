package com.example.onlinestore;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    String myUrl = "http://restapi.adequateshop.com/api/authaccount/login";
//    AlertDialog alertDialog;
    EditText userName, password;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        userName = (EditText)findViewById(R.id.editTextTextPersonName);
        password = (EditText)findViewById(R.id.editTextTextPassword);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
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
//            Toast.makeText(this,"Login Successful",Toast.LENGTH_LONG).show();
//            Intent navigationActivity  = new Intent(MainActivity.this, NavigationActivity.class);
//            startActivity(navigationActivity);
//            progressBar.setVisibility(View.VISIBLE);
            //https://www.geeksforgeeks.org/how-to-post-data-to-api-using-retrofit-in-android/
            // calling a method to post the data and passing our name and job.
            postData(userName.getText().toString(), password.getText().toString());
        }
    }

    private void postData(String name, String pswd) {

        // below line is for displaying our progress bar.
        progressBar.setVisibility(View.VISIBLE);

        // below line is to create an instance for our retrofit api class.
        RetrofitAPI retrofitAPI = APIClient.getRetrofit().create(RetrofitAPI.class);

        // passing data from our text fields to our modal class.
        DataModal modal = new DataModal(name, pswd);

        // calling a method to create a post and passing our modal class.
        //Call<DataModal> call = retrofitAPI.createPost(modal);
        Call<ResponseDataModel> call = retrofitAPI.login(modal);
        // on below line we are executing our method.

        call.enqueue(new Callback<ResponseDataModel>() {
            @Override
            public void onResponse(Call<ResponseDataModel> call, Response<ResponseDataModel> response) {
                Log.i("Success", "Success onResponse:"+response.body().getCode());
                progressBar.setVisibility(View.GONE);

                if(response.body().getCode() == 0) {
                    Toast.makeText(MainActivity.this,"Login Successful",Toast.LENGTH_LONG).show();
                    Intent navigationActivity  = new Intent(MainActivity.this, NavigationActivity.class);
                    startActivity(navigationActivity);
                } else {
                    Toast.makeText(MainActivity.this,"Please Enter Correct Credential",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseDataModel> call, Throwable t) {
                Log.i("Failure", "Failure API: "+t.getLocalizedMessage());
                progressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this,t.getLocalizedMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}