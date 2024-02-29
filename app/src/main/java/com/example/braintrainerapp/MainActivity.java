package com.example.braintrainerapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView timer, addition,couter;
    private int value1, value2;
    private Button valueOne, valueTwo, valueThree, valueFour;


    private int totalQuestion=0;

    private int wrongAnswer=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // IMPLEMENT TIMER
        timer = findViewById(R.id.timer);
        implementTimer();

        // IMPLEMENT VALUES FOR ADDITION
        addition = findViewById(R.id.addition);
        implementValueForAddition();


        // IMPLEMENT ALL OPTION VALUE
        valueOne = findViewById(R.id.valueOne);
        valueTwo = findViewById(R.id.valueTwo);
        valueThree = findViewById(R.id.valueThree);
        valueFour = findViewById(R.id.valueFour);
        implementOptionValues();



        couter=findViewById(R.id.couter);



        valueOne.setOnClickListener(view -> {
            totalQuestion++;
            if ((value1 + value2) == Integer.parseInt(valueOne.getText().toString())) {
                Toast.makeText(this, "Answer is Correct", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Answer is Wrong", Toast.LENGTH_SHORT).show();
                wrongAnswer++;
            }
            implementValueForAddition();
            implementOptionValues();
            totalQuestion();
        });

        valueTwo.setOnClickListener(view -> {
            totalQuestion++;
            if ((value1 + value2) == Integer.parseInt(valueTwo.getText().toString())) {
                Toast.makeText(this, "Answer is Correct", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Answer is Wrong", Toast.LENGTH_SHORT).show();
                wrongAnswer++;
            }
            implementValueForAddition();
            implementOptionValues();
            totalQuestion();
        });

        valueThree.setOnClickListener(view -> {
            totalQuestion++;
            if ((value1 + value2) == Integer.parseInt(valueThree.getText().toString())) {
                Toast.makeText(this, "Answer is Correct", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this, "Answer is Wrong", Toast.LENGTH_SHORT).show();
                wrongAnswer++;


            }
            implementValueForAddition();
            implementOptionValues();
            totalQuestion();
        });

        valueFour.setOnClickListener(view -> {
            totalQuestion++;
            if ((value1 + value2) == Integer.parseInt(valueFour.getText().toString())) {
                Toast.makeText(this, "Answer is Correct", Toast.LENGTH_SHORT).show();


            } else {
                Toast.makeText(this, "Answer is Wrong", Toast.LENGTH_SHORT).show();
                wrongAnswer++;

            }
            implementValueForAddition();
            implementOptionValues();
            totalQuestion();
        });


    }


public  void totalQuestion(){
        couter.setText(wrongAnswer+"/"+totalQuestion);
}

    //IMPLEMENT ALL OPTION VALUE

    public void implementOptionValues() {
        int i = value1 + value2;
        if (i <= 50) {
            valueOne.setText(i + "");
            valueTwo.setText(i + 3 + "");
            valueThree.setText(i - 1 + "");
            valueFour.setText(i + 1 + "");
        } else if (i > 50 && i <= 100) {
            valueThree.setText(i + "");
            valueOne.setText(i - 1 + "");
            valueTwo.setText(i + 3 + "");
            valueFour.setText(i + 1 + "");
        } else if (i > 100 && i <= 150) {
            valueFour.setText(i + "");
            valueOne.setText(i + 3 + "");
            valueTwo.setText(i + 1 + "");
            valueThree.setText(i - 1 + "");
        } else if (i > 150) {
            valueFour.setText(i - 1 + "");
            valueOne.setText(i + 3 + "");
            valueTwo.setText(i + "");
            valueThree.setText(i + 1 + "");
        }


    }

    //IMPLEMENT VALUES FOR ADDITION
    public void implementValueForAddition() {
        value1 = new Random().nextInt(100);
        value2 = new Random().nextInt(100);
        addition.setText(value1 + " + " + value2);
    }


    // IMPLEMENT TIMER
    public void implementTimer() {
        new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                // Update the timer TextView with remaining seconds
                timer.setText((millisUntilFinished / 1000) + "S");
            }

            @Override
            public void onFinish() {
                // When the countdown finishes, show an AlertDialog
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this); // Replace YourActivityName with the name of your activity class
                alert.setTitle("TIME UP ....");
                alert.setMessage("Do You Want to Restart the Game");
                alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Restart the game by starting the MainActivity again
                        Intent intent = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                });
                alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Finish the current activity to exit the game
                        finish();
                    }
                });
                alert.show();
            }
        }.start();
    }
}