package com.example.m213_ch09_tp01_trainnes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;

import com.example.m213_ch09_tp01_trainnes.databinding.ActivityMainBinding;

import java.security.Permission;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        TimeAsyncTask timeAsyncTask = new TimeAsyncTask();
        timeAsyncTask.execute(1);

        binding.btnQuit.setOnClickListener(v -> {
            finish();
        });
    }

    private void getTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        binding.tvTime.setText(sdf.format(new Date()));
//        Log.i("TAG", sdf.format(new Date()));
    }

    class TimeAsyncTask extends AsyncTask<Integer, Integer, Void> {
        @Override
        protected Void doInBackground(Integer... integers) {
            int i = 0;
            do {
                publishProgress(i);

                try {
                    Thread.sleep(integers[0]);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                i++;
            } while (true);

//            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... integers) {
            super.onProgressUpdate(integers);

//            getTime();
            binding.tvTime.setText(Integer.toString(integers[0]));
        }
    }
}