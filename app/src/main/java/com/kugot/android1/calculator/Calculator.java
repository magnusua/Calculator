package com.kugot.android1.calculator;

import java.util.Stack;

import static com.kugot.android1.calculator.InfixToPostfix.isOperator;

public class Calculator {
    final static InfixToPostfix infixToPostfix = new InfixToPostfix();

    public static double evaluate(String equation) {

        return calculate(infixToPostfix.convertToPostfix(equation));
    }

    private static double calculate(String postfixExpWithUnderscore) {
        Stack<Double> operandStack = new Stack<>();

        boolean isUnderscore = false;
        StringBuilder numberString = new StringBuilder();

        for (int i = 0; i < postfixExpWithUnderscore.length(); i++) {
            if (postfixExpWithUnderscore.charAt(i) == '_') {
                isUnderscore = true;
                if (i > 0 && numberString.length() > 0)
                    operandStack.push(Double.parseDouble(numberString.toString()));
                numberString.delete(0, numberString.length());
                continue;
            }
            final boolean isOperator = isOperator(postfixExpWithUnderscore.charAt(i));
            if (isUnderscore) {
                if (!isOperator) {
                    numberString.append(postfixExpWithUnderscore.charAt(i));
                    continue;
                } else {
                    operandStack.push(Double.parseDouble(numberString.toString()));
                    numberString.delete(0, numberString.length());
                    isUnderscore = false;
                }
            }
            if (isOperator) {
                final double res = evaluate(operandStack.pop(), operandStack.pop(), postfixExpWithUnderscore.charAt(i));
                operandStack.push(res);
            }
        }

        return operandStack.pop();
    }

    private static double evaluate(Double second, Double first, char operator) {
        switch (operator) {
            case '+':
                return first + second;
            case '-':
                return first - second;
            case '*':
                return first * second;
            case '/':
                return first / second;
            case '^':
                return Math.pow(first, second);
            default:
                return 0;

        }
    }

}