package com.example.task2ya;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    EditText edit1;
    EditText edit2;
    EditText edit3;
    TextView tV1;
    private int REQUEST_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         edit1 = findViewById(R.id.number1);
         edit2 = findViewById(R.id.number2);
        edit3 = findViewById(R.id.number3);
        tV1 = findViewById(R.id.answer);

    }
    @Override
    protected void onActivityResult(int source, int result, @Nullable Intent data_back)
    {
        super.onActivityResult(source, result, data_back);
        if (source == REQUEST_CODE)
        {
            if (result == RESULT_OK)
            {
                if (data_back != null)
                {
                    String count3 = data_back.getStringExtra("solve");
                    tV1.setText(count3);
                }
            }
        }
    }
    public void rand(View view)
    {
        Random rand = new Random();
        int n1 = rand.nextInt(10);
        int n2 = rand.nextInt(10);
        int n3 = rand.nextInt(10);
        edit1.setText(String.valueOf(n1));
        edit2.setText(String.valueOf(n2));
        edit3.setText(String.valueOf(n3));
    }

    public void calc(View view)
    {
        String t1 = edit1.getText().toString();
        String t2 = edit2.getText().toString();
        String t3 = edit3.getText().toString();
        try
        {
            if (!t1.equals("-") || t2.equals("-") || t3.equals("-")) {
                if (!t1.equals("0")) {
                    if (!(t1.isEmpty() || t2.isEmpty() || t3.isEmpty())) {
                        Intent getNumber = new Intent(this, calculate.class);
                        double a = Double.valueOf(t1);
                        double b = Double.valueOf(t2);
                        double c = Double.valueOf(t3);

                        getNumber.putExtra("a", a);
                        getNumber.putExtra("b", b);
                        getNumber.putExtra("c", c);
                        startActivityForResult(getNumber, REQUEST_CODE);
                    }
                }
            }
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}