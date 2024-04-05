package com.example.biletulnr17;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    //TextView textViewPerimeter = findViewById(R.id.textViewPerimeter);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);
        Button button = findViewById(R.id.buttong);


        int maxValue = getIntent().getIntExtra("MAX", 0);
        int[] array = getIntent().getIntArrayExtra("ARRAY");


        TextView tvArrayElements = findViewById(R.id.tvMaxElements);
        StringBuilder arrayText = new StringBuilder("Array Elements: ");

        for (int i = 0; i < array.length; i++) {
            arrayText.append(array[i]);
            if (i < array.length - 1) {
                arrayText.append(", ");
            }
        }
        tvArrayElements.setText(arrayText.toString());


        TextView tvMaxElement = findViewById(R.id.tvMaxElement);
        tvMaxElement.setText("Max Number: " + maxValue);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
