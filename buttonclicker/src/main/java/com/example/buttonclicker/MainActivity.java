package com.example.buttonclicker;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView kto;
    private Button ktoya;
    private Button ItIsNotMe;

    public void onMyButtonClick(View view) {
        kto.setText("Это не я сделал");
        CheckBox checkBox = findViewById(R.id.done);
        checkBox.setChecked(false);
        Toast.makeText(this, "Ещё один способ!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        kto = findViewById(R.id.kto);
        ktoya = findViewById(R.id.ktoya);
        ItIsNotMe = findViewById(R.id.ItIsNotMe);

        CheckBox checkBox = findViewById(R.id.done);
        View.OnClickListener oclktoya = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kto.setText("Мой номер по списку № 3");
                checkBox.setChecked(true);
            }
        };

        ktoya.setOnClickListener(oclktoya);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

}