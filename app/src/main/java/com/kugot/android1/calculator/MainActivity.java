package com.kugot.android1.calculator;

import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import static com.kugot.android1.calculator.R.id.button0;
import static com.kugot.android1.calculator.R.id.button1;
import static com.kugot.android1.calculator.R.id.button2;
import static com.kugot.android1.calculator.R.id.button3;
import static com.kugot.android1.calculator.R.id.button4;
import static com.kugot.android1.calculator.R.id.button5;
import static com.kugot.android1.calculator.R.id.button6;
import static com.kugot.android1.calculator.R.id.button7;
import static com.kugot.android1.calculator.R.id.button8;
import static com.kugot.android1.calculator.R.id.button9;
import static com.kugot.android1.calculator.R.id.buttonCE;
import static com.kugot.android1.calculator.R.id.buttonDelimiter;
import static com.kugot.android1.calculator.R.id.buttonLeftBracket;
import static com.kugot.android1.calculator.R.id.buttonMinus;
import static com.kugot.android1.calculator.R.id.buttonMultiply;
import static com.kugot.android1.calculator.R.id.buttonP;
import static com.kugot.android1.calculator.R.id.buttonPlus;
import static com.kugot.android1.calculator.R.id.buttonPlusMinus;
import static com.kugot.android1.calculator.R.id.buttonResult;
import static com.kugot.android1.calculator.R.id.buttonRightBracket;
import static com.kugot.android1.calculator.R.id.buttonSqrt;
import static com.kugot.android1.calculator.R.id.buttonSquare;
import static com.kugot.android1.calculator.R.id.input;
import static com.kugot.android1.calculator.R.id.output;
import static com.kugot.android1.calculator.R.layout;

public class MainActivity extends AppCompatActivity {

    public static final String MY_TAG = "Lifecycle";
    public static final String KEY_PREFIX = MainActivity.class.getCanonicalName();
    private static final String KEY_MAIN_SCREEN = "mainScreen";
    private static final String KEY_MEMORY_SCREEN = "memoryScreen";
    private static final String KEY_EQUATION = "equation";

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
    //   private Button mButtonClear; //заготовка под кнопку очищения текстового поля с результатами при долгом нажатии

    private TextView mScreen;
    private TextView mMemoryScreen;
    String equation = "";

/*
1. Напишите обработку каждой кнопки из макета калькулятора.
2. Создайте объект с данными и операциями калькулятора. Продумайте, каким образом будете
    хранить введённые пользователем данные.
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        Log.e(MY_TAG, "onCreate(): " + KEY_PREFIX + (savedInstanceState == null ? " first" : " next"));
        viewSetup();
        setNumericListener();
        setOperationClickListener();

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
        state.putString(KEY_MAIN_SCREEN, mScreen.getText().toString());
        state.putString(KEY_MEMORY_SCREEN, mMemoryScreen.getText().toString());
        state.putString(KEY_EQUATION, equation);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.e(MY_TAG, "onRestoreInstanceState() ");
        super.onRestoreInstanceState(savedInstanceState);
        mScreen.setText(savedInstanceState.getString(KEY_MAIN_SCREEN));
        mMemoryScreen.setText(savedInstanceState.getString(KEY_MEMORY_SCREEN));
        equation = savedInstanceState.getString(KEY_EQUATION);
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
        mScreen = findViewById(input);
        mMemoryScreen = findViewById(output);
    }

    private final View.OnClickListener keyNumericClickListener = (view) -> {
        switch (view.getId()) {
            case button0: {
                addCharToParam('0');
                break;
            }
            case button1: {
                addCharToParam('1');
                break;
            }
            case button2: {
                addCharToParam('2');
                break;
            }
            case button3: {
                addCharToParam('3');
                break;
            }
            case button4: {
                addCharToParam('4');
                break;
            }
            case button5: {
                addCharToParam('5');
                break;
            }
            case button6: {
                addCharToParam('6');
                break;
            }
            case button7: {
                addCharToParam('7');
                break;
            }
            case button8: {
                addCharToParam('8');
                break;
            }
            case button9: {
                addCharToParam('9');
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

    private void setOperationClickListener() {
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
                addCharToParam('(');
                break;
            }
            case buttonRightBracket: {
                addCharToParam(')');
                break;
            }
            case buttonDelimiter: {
                addCharToParam('/');
                break;
            }
            case buttonMultiply: {
                addCharToParam('*');
                break;
            }
            case buttonPlus: {
                addCharToParam('+');
                break;
            }
            case buttonMinus: {
                addCharToParam('-');
                break;
            }
            //необходимо будет обработать в дальнейшем
            case buttonCE: {
                clear();
                break;
            }
            case buttonP: {
                addCharToParam('.');
                break;
            }
            case buttonPlusMinus:
            case buttonSqrt: {
                toasterText();
                break;
            }

            case buttonSquare: {
                addCharToParam('^');
                break;
            }

            case buttonResult: {
                if (mScreen.getText().toString().matches("\\d*[+-/*]?\\d+$")) {
                    ifErrorOnOutput();
                    equation = String.valueOf(Calculator.evaluate(mScreen.getText().toString()));
                    mMemoryScreen.setText(equation);
                } else {
                    mMemoryScreen.setText("Error!");
                }
                clear();
                break;
            }

            default: {
                break;
            }
        }
    };

    private void addCharToParam(char key) {
        ifErrorOnOutput();
        setTextView1(key);
        exceedLength();

    }

    private void setTextView1(char key) {
        if (key == '.' && mScreen.getText().length() == 0) {
            mScreen.setText(mScreen.getText().toString() + 0 + key);
        } else {
            mScreen.setText(mScreen.getText().toString() + key);
        }

    }

    //plusMinus
    private void plusMinusButton() {
        if (mScreen.getText().length() > 0 && (mScreen.getText().charAt(0) == '-')) {
            mScreen.setText(mScreen.getText().toString().substring(1));
        } else {
            mScreen.setText("-" + mScreen.getText().toString());
        }
    }

    // заготовка под обработку ошибок
    private void ifErrorOnOutput() {
        if (mMemoryScreen.getText().toString().equals("Error")) {
            mMemoryScreen.setText("");
        }
    }

    // уменьшить размер текста
    private void exceedLength() {
        if (mScreen.getText().toString().length() > 20) {
            mScreen.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        } else {
            mScreen.setTextSize(TypedValue.COMPLEX_UNIT_SP, 50);
        }
    }

    private void clear() {
        mScreen.setText("");
    }

    private void toasterText() {
        Toast.makeText(this, "Эта функция пока не работает", Toast.LENGTH_LONG).show();
    }
}