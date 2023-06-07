package com.example.m213_ch09_tp01_trainnes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.m213_ch09_tp01_trainnes.databinding.ActivityMainBinding;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        binding.btnQuit.setOnClickListener(v -> {
            finish();
        });

        Thread thread = new Thread() { // Background Thread
            @Override
            public void run() {
                do {
                    runOnUiThread(() -> getTime());

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }while (true);
            }
        };

        thread.start();


    }

    private void getTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        binding.tvTime.setText(sdf.format(new Date()));
//        Log.i("TAG", sdf.format(new Date()));
    }
}