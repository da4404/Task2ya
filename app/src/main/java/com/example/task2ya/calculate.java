package com.example.task2ya;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class calculate extends AppCompatActivity
{
    ImageView parabulal;
    Button returnBack;
    String result;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
        double a = getIntent().getDoubleExtra("a", 0);
        double b = getIntent().getDoubleExtra("b", 0);
        double c = getIntent().getDoubleExtra("c", 0);
        parabulal = findViewById(R.id.parabulal);
        returnBack  = findViewById(R.id.back);

        txtResult = findViewById(R.id.solvee);
        result = solve(a, b, c);
        txtResult.setText(result);

    }


    public String solve(double a, double b, double c)
    {
        if (a == 0)
        {
            if (b == 0)
            {
                if (c == 0)
                {
                    return "Infinite solutions";
                }
                else
                {
                    return "No solution";
                }
            }
            else
            {
                double x = -c / b;
                return "Single solution: x = " + x;
            }
        }
         double delta = b * b - 4 * a * c;

        if (delta < 0)
        {
            if (a > 0)
            {
                parabulal.setImageResource(R.drawable.parabola_up_no_root);
            }
            else
            {
                parabulal.setImageResource(R.drawable.parabola_down_no_root);
            }
            return "No real solutions";
        }
        else if (delta == 0)
        {
            if (a > 0)
            {
                parabulal.setImageResource(R.drawable.parabulal_up_one_root);
            }
            else
            {
                parabulal.setImageResource(R.drawable.parabola_down_one_root);
            }
            double x = -b / (2 * a);
            return "Single solution: x = " + x;
        }
        else
        {
            if (a > 0)
            {
                parabulal.setImageResource(R.drawable.parabola_up_two_roots);
            }
            else
            {
                parabulal.setImageResource(R.drawable.parabola_down_two_root);
            }
            double sqrtDelta = Math.sqrt(delta);
            double x1 = (-b + sqrtDelta) / (2 * a);
            double x2 = (-b - sqrtDelta) / (2 * a);
            return "Two solutions: x1 = " + x1 + ", x2 = " + x2;
        }
    }

    public void back1(View view)
    {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("solve", result);
        setResult(RESULT_OK, returnIntent);
        finish();
    }
}