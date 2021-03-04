package com.kugot.android1.calculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button mButtonCE;
    private Button mButton0;
    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private Button mButton4;
    private Button mButton5;
    private Button mButton6;
    private Button mButton7;
    private Button mButton8;
    private Button mButton9;
    private Button mButtonLeftBracket;
    private Button mButtonRightBracket;
    private Button mButtonSqrt;
    private Button mButtonDelimiter;
    private Button mButtonMultiply;
    private Button mButtonMinus;
    private Button mButtonPlus;
    private Button mButtonPlusMinus;
    private Button mButtonSquare;
    private Button mButtonP;
    private Button mButtonResult;
    private Button mButtonClear;
    private TextView t1;
    private TextView t2;
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = '*';
    private final char DIVISION = '/';
    private final char EQU = '=';
    private final char MODULUS = '%';
    private char ACTION;
    private double val1 = Double.NaN;
    private double val2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewSetup();
    }

    private void viewSetup() {
        mButton1 = findViewById(R.id.button1);
        mButton2 = findViewById(R.id.button2);
        mButton3 = findViewById(R.id.button3);
        mButton4 = findViewById(R.id.button4);
        mButton5 = findViewById(R.id.button5);
        mButton6 = findViewById(R.id.button6);
        mButton7 = findViewById(R.id.button7);
        mButton8 = findViewById(R.id.button8);
        mButton9 = findViewById(R.id.button9);
        mButton0 = findViewById(R.id.button0);
        mButtonResult = findViewById(R.id.buttonResult);
        mButtonLeftBracket = findViewById(R.id.buttonLeftBracket);
        mButtonRightBracket = findViewById(R.id.buttonRightBracket);
        mButtonSqrt = findViewById(R.id.buttonSqrt);
        mButtonDelimiter = findViewById(R.id.buttonDelimiter);
        mButtonMultiply = findViewById(R.id.buttonMultiply);
        mButtonMinus = findViewById(R.id.buttonMinus);
        mButtonPlus = findViewById(R.id.buttonPlus);
        mButtonPlusMinus = findViewById(R.id.buttonPlusMinus);
        mButtonSquare = findViewById(R.id.buttonSquare);
        mButtonP = findViewById(R.id.buttonP);
        mButtonCE = findViewById(R.id.buttonCE);
        t1 = findViewById(R.id.input);
        t2 = findViewById(R.id.output);
    }
}