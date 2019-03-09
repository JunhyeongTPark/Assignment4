package com.example.extstudent.mainactivity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    LinearLayout scrollViewLayout = null;
    Button startButton = null;

    int currentNewButtonCount = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrollViewLayout = (LinearLayout)findViewById(R.id.scrollViewLayout);

        startButton = (Button)findViewById(R.id.buttonSubmit);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                generateNewButton();
                startButton.setEnabled(false);
            }
        });
        // TO-DO:
        // 1. Create a reference to the main layout.
        // 2. Create a reference to the start button and make the callback.
    }

    private void generateNewButton() {
        // TO-DO:
        // 1. Create a new Button widget (HINT: Pass in MainActivity.this);
        // 2. Create a layout prams for the new button. Layout params takes in the height and the width.
        // 3. Set the text and text color (use getRandomColor()) for the button. You can also set the background, but it might look weird.
        // 4. Create the callback for the new Button.
        // 5. Add the Button to the current view.

        final Button newButton = new Button(MainActivity.this);

        int width = LinearLayout.LayoutParams.MATCH_PARENT;
        int length = LinearLayout.LayoutParams.MATCH_PARENT;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width, length);

        newButton.setLayoutParams(layoutParams);

        newButton.setText("PRESS ME " + Integer.toString(currentNewButtonCount++));
        newButton.setTextColor(getRandomColor());

        scrollViewLayout.addView(newButton);

        newButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                generateNewButton();
                newButton.setEnabled(false);
            }
        });

    }

    private int getRandomColor() {
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256),
                rnd.nextInt(256), rnd.nextInt(256));
    }
}