package com.example.assignment_3quest02;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.GridLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridLayout gridLayout = findViewById(R.id.gridLayout);

        int rows = 3;
        int cols = 3;

        int[][] numbers = new int[rows][cols];

        // Generate random numbers and populate the grid layout
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int randomNumber = generateRandomNumber();
                numbers[i][j] = randomNumber;
                TextView textView = createTextView(String.valueOf(randomNumber));
                GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                params.rowSpec = GridLayout.spec(i);
                params.columnSpec = GridLayout.spec(j);
                textView.setLayoutParams(params);
                gridLayout.addView(textView);
            }
        }

        // Check adjacent cells for the same number and change background color
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (j < cols - 1 && numbers[i][j] == numbers[i][j + 1]) {
                    TextView textView1 = (TextView) gridLayout.getChildAt(i * cols + j);
                    textView1.setBackgroundColor(Color.YELLOW);
                    TextView textView2 = (TextView) gridLayout.getChildAt(i * cols + j + 1);
                    textView2.setBackgroundColor(Color.YELLOW);
                }
                if (i < rows - 1 && numbers[i][j] == numbers[i + 1][j]) {
                    TextView textView1 = (TextView) gridLayout.getChildAt(i * cols + j);
                    textView1.setBackgroundColor(Color.YELLOW);
                    TextView textView2 = (TextView) gridLayout.getChildAt((i + 1) * cols + j);
                    textView2.setBackgroundColor(Color.YELLOW);
                }
            }
        }
    }

    // Generate a random number between 1 and 9
    private int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(9) + 1;
    }

    // Create a TextView with specified text
    private TextView createTextView(String text) {
        TextView textView = new TextView(this);
        textView.setText(text);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(20);
        return textView;
    }
}
