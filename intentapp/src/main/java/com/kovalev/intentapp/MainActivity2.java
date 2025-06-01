package com.kovalev.intentapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        String dateString = getIntent().getStringExtra("Время");
        int groupNumber = getIntent().getIntExtra("Номер по списку", 0);

        int squareValue = groupNumber * groupNumber;

        String message = "КВАДРАТ ЗНАЧЕНИЯ МОЕГО НОМЕРА ПО СПИСКУ В ГРУППЕ СОСТАВЛЯЕТ ЧИСЛО "
                + squareValue + ", а текущее время " + dateString;

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView textView = findViewById(R.id.textView);
        textView.setText(message);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}