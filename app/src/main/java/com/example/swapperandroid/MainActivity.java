package com.example.swapperandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView tvOutput;
    private Button btnSwap, btnCheck;
    private EditText inputOne, inputTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Initialize
        tvOutput = (TextView) findViewById(R.id.tvOutput);
        btnSwap = (Button) findViewById(R.id.btnSwap);
        btnCheck = (Button) findViewById(R.id.btnCheck);
        inputOne = (EditText) findViewById(R.id.edTxt1);
        inputTwo = (EditText) findViewById(R.id.edTxt2);

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String word1 = inputOne.getText().toString().trim();
                String word2 = inputTwo.getText().toString().trim();


                if (word1.equals(word2)) {
                    tvOutput.setText("Same");
                } else {
                    tvOutput.setText("Not the Same");
                }
            }
        });

        btnSwap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //This is the swapper method

                String stored = "";
                String word1 = inputOne.getText().toString().trim();
                String word2 = inputTwo.getText().toString().trim();
                stored = word2;
                word2 = word1;
                word1 = stored;

                inputOne.setText(word1);
                inputTwo.setText(word2);
            }
        });
    }
}