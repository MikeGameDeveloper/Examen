package com.example.biletulnr17;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
     EditText editText;
     Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText= findViewById(R.id.editText);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generate();
            }
        });
    }
    private void generate() {
        try {
            int et = Integer.parseInt(editText.getText().toString());

            int[] randomArray = new int[et];

            Random random = new Random();

            for (int i = 0; i < et; i++) {
                // Generate a random integer between 0 and 99
                randomArray[i] = random.nextInt(100);
            }
            int max = Arrays.stream(randomArray).max().getAsInt();

            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("ARRAY", randomArray);
            intent.putExtra("MAX", max);

            startActivity(intent);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter an Integer Number", Toast.LENGTH_SHORT).show();
        }
    }


}
