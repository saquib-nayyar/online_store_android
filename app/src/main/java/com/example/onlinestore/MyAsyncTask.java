package com.example.onlinestore;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AlertDialog;

public class MyAsyncTask extends AsyncTask {


    ProgressBar progressBar;

    public MyAsyncTask(ProgressBar progressBar){
        this.progressBar = progressBar;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        this.progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        this.progressBar.setVisibility(View.GONE);
        Log.i("TAG", "onPostExecute:" +o);
    }
}
