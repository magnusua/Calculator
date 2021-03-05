package com.kugot.android1.calculator;

import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import static com.kugot.android1.calculator.R.*;
import static com.kugot.android1.calculator.R.id.*;

public class MainActivity extends AppCompatActivity {

    public static final String MY_TAG = "Lifecycle";
    public static final String KEY_PREFIX = MainActivity.class.getCanonicalName();
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = '*';
    private final char DIVISION = '/';
    private final char EQU = '=';
    private final char MODULUS = '%';
    private final char PLUSMINUS = '±';

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
    private Button mButtonCE;
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
    private TextView mTextView1;
    private TextView mTextView2;

    private char ACTION;
    private double val1 = Double.NaN;
    private double val2;

/*
1. Напишите обработку каждой кнопки из макета калькулятора.
2. Создайте объект с данными и операциями калькулятора. Продумайте, каким образом будете
    хранить введённые пользователем данные.
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        Log.e(MY_TAG, "onCreate(): " + (savedInstanceState == null ? "first" : "next"));
        viewSetup();
        setNumericListener();
        setOnClickListener();


    }


    private void addCharToParam(String key) {
        ifErrorOnOutput();
        exceedLength();
        mTextView1.setText(mTextView1.getText().toString() + key);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.e(MY_TAG, "onStart() ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(MY_TAG, "onRestart() ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(MY_TAG, "onResume() ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(MY_TAG, "onPause() ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(MY_TAG, "onStop() ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(MY_TAG, "onDestroy() ");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle state) {
        Log.e(MY_TAG, "onSaveInstanceState() ");
        super.onSaveInstanceState(state);
    }

    @Override
    protected void onRestoreInstanceState(Bundle state) {
        Log.e(MY_TAG, "onRestoreInstanceState() ");
        super.onRestoreInstanceState(state);
    }


    private void viewSetup() {
        mButton0 = findViewById(button0);
        mButton1 = findViewById(button1);
        mButton2 = findViewById(button2);
        mButton3 = findViewById(button3);
        mButton4 = findViewById(button4);
        mButton5 = findViewById(button5);
        mButton6 = findViewById(button6);
        mButton7 = findViewById(button7);
        mButton8 = findViewById(button8);
        mButton9 = findViewById(button9);

        mButtonResult = findViewById(buttonResult);
        mButtonLeftBracket = findViewById(buttonLeftBracket);
        mButtonRightBracket = findViewById(buttonRightBracket);
        mButtonSqrt = findViewById(buttonSqrt);
        mButtonDelimiter = findViewById(buttonDelimiter);
        mButtonMultiply = findViewById(buttonMultiply);
        mButtonMinus = findViewById(buttonMinus);
        mButtonPlus = findViewById(buttonPlus);
        mButtonPlusMinus = findViewById(buttonPlusMinus);
        mButtonSquare = findViewById(buttonSquare);
        mButtonP = findViewById(buttonP);
        mButtonCE = findViewById(buttonCE);
        mTextView1 = findViewById(input);
        mTextView2 = findViewById(output);
    }

    private final View.OnClickListener keyNumericClickListener = (view) -> {
        switch (view.getId()) {
            case button0: {
                addCharToParam("0");
                break;
            }
            case button1: {
                addCharToParam("1");
                break;
            }
            case button2: {
                addCharToParam("2");
                break;
            }
            case button3: {
                addCharToParam("3");
                break;
            }
            case button4: {
                addCharToParam("4");
                break;
            }
            case button5: {
                addCharToParam("5");
                break;
            }
            case button6: {
                addCharToParam("6");
                break;
            }
            case button7: {
                addCharToParam("7");
                break;
            }
            case button8: {
                addCharToParam("8");
                break;
            }
            case button9: {
                addCharToParam("9");
                break;
            }
            default: {
                break;
            }
        }
    };

    private void setNumericListener() {
        mButton0.setOnClickListener(keyNumericClickListener);
        mButton1.setOnClickListener(keyNumericClickListener);
        mButton2.setOnClickListener(keyNumericClickListener);
        mButton3.setOnClickListener(keyNumericClickListener);
        mButton4.setOnClickListener(keyNumericClickListener);
        mButton5.setOnClickListener(keyNumericClickListener);
        mButton6.setOnClickListener(keyNumericClickListener);
        mButton7.setOnClickListener(keyNumericClickListener);
        mButton8.setOnClickListener(keyNumericClickListener);
        mButton9.setOnClickListener(keyNumericClickListener);
    }

    private void setOnClickListener() {
        mButtonResult.setOnClickListener(keyOperationClickListener);
        mButtonLeftBracket.setOnClickListener(keyOperationClickListener);
        mButtonRightBracket.setOnClickListener(keyOperationClickListener);
        mButtonSqrt.setOnClickListener(keyOperationClickListener);
        mButtonDelimiter.setOnClickListener(keyOperationClickListener);
        mButtonMultiply.setOnClickListener(keyOperationClickListener);
        mButtonMinus.setOnClickListener(keyOperationClickListener);
        mButtonPlus.setOnClickListener(keyOperationClickListener);
        mButtonPlusMinus.setOnClickListener(keyOperationClickListener);
        mButtonSquare.setOnClickListener(keyOperationClickListener);
        mButtonP.setOnClickListener(keyOperationClickListener);
        mButtonCE.setOnClickListener(keyOperationClickListener);
    }


    private final View.OnClickListener keyOperationClickListener = (view) -> {
        switch (view.getId()) {
            case buttonLeftBracket: {
                addCharToParam("(");
                break;
            }
            case buttonRightBracket: {
                addCharToParam(")");
                break;
            }
            case buttonDelimiter: {
                addCharToParam("/");
                break;
            }
            case buttonMultiply: {
                addCharToParam("*");
                break;
            }
            case buttonPlus: {
                addCharToParam("+");
                break;
            }
            case buttonMinus: {
                addCharToParam("-");
                break;
            }
            //далее необходимо будет обработать в дальнейшем
            case buttonCE: {
                mTextView1.setText("");
                break;
            }
            case buttonP: {
                addCharToParam(".");
                break;
            }
            case buttonPlusMinus: {
                mTextView1.setText("-" + mTextView1.getText().toString());
                ;
                break;
            }
            case buttonSqrt: {
                addCharToParam("^");
                break;
            }
            case buttonSquare: {
                addCharToParam("^2");
                break;
            }

            default: {
                break;
            }
        }
    };


    // заготовка под обработку ошибок
    private void ifErrorOnOutput() {
        if (mTextView2.getText().toString().equals("Error")) {
            mTextView2.setText("");
        }
    }

    // уменьшить размер текста
    private void exceedLength() {
        if (mTextView1.getText().toString().length() > 10) {
            mTextView1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        }
    }
}