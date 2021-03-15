package com.kugot.android1.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {

    public static Double evaluate(String expression) {
        List<String> strList = new ArrayList<>();
        for (String listElement : expression.trim().split(" ")) {
            strList.add(listElement);
            strList.add(" ");
        }
        strList.remove(strList.size() - 1);

        if (strList.contains("(")) {
//          Если "(" обнаружен, ищем подходящую конструкцию используя цикл.
            for (int i = strList.indexOf("(") + 1; i < strList.size() - 1; i++) {
////              Конструкция 1: первым элиментом, который мы отыскали были вторые "("
                StringBuilder recursion = new StringBuilder();
                if (strList.get(i).equals("(")) {
                    for (int j = i; j < strList.lastIndexOf(")"); j++) {
                        recursion.append(strList.get(j));
                    }
                    // сверху считывали последовательность находящуюся в скобках (()) До lastIndex элемента
                    String test = expression.substring(expression.indexOf("("), expression.lastIndexOf(")") + 1);
                    // test - последовательность как и сверху, но с добавлением скобок по краям

                    // т.к. наш метод evaluate() возвращает Double, мы должны преобразовать результат рекрусии в String;
                    String testRecursion = String.valueOf(evaluate(recursion.toString()));
                    expression = expression.replace(test, testRecursion);
                    // преобразовали нашу строку с использование рекрс. Избавились от первых скобок
                    strList.removeAll(strList);
                    for (String newElement : expression.trim().split(" ")) {
                        strList.add(newElement);
                        strList.add(" ");
                    }
                    // Тут очищаем наш список и сново его заполняем (но уже раскрыв первые скобки)
                }

//                Конструкция 2: первым элиментом, который мы отыскали был  ")"
                StringBuilder recursion2 = new StringBuilder();
                if (strList.get(i).equals(")")) {

                    for (int j = strList.indexOf("(") + 1; j < strList.indexOf(")"); j++) {
                        recursion2.append(strList.get(j));
                    }
                    String test2 = expression.substring(expression.indexOf("("), expression.lastIndexOf(")") + 1);
                    String testRecursion2 = String.valueOf(evaluate(recursion2.toString()));
                    expression = expression.replace(test2, testRecursion2);
                    for (String newElement : expression.trim().split(" ")) {
                        strList.add(newElement);
                        strList.add(" ");
                    }
                    // Тут повторили тот же алгоритм, что и в первой конструкции
                }
            }
        }

/*
  Этап 3
  Заключительный этап на котором мы будем реализовывать сами вычесления (* /-+)
  Всю реализацию помещаем в цикл while ( который прекратиться, если все действия будут выполнены (соответственно в списке останется 1 элемент)).
  Внимательно посмотрите на порядок операций: 1)/ 2)* 3)- 4)+
        System.out.println(expression + "-------expression-");
        System.out.println();
 создаем очередной список для реализации вычеслений, на этот раз без добавления " ".
*/

        List<String> stringList2 = new ArrayList<>();
        stringList2.addAll(Arrays.asList(expression.trim().split(" ")));

        while (stringList2.size() != 0) {

            Double result = 0d;

            if (stringList2.contains("/")) {
                int index = stringList2.indexOf("/");
                result = Double.parseDouble(stringList2.get(index - 1)) / Double.parseDouble(stringList2.get(index + 1));
                stringList2.add(index - 1, String.valueOf(result));
                stringList2.remove(index + 2);
                stringList2.remove(index + 1);
                stringList2.remove(index);
            } else if (stringList2.contains("*")) {
                int index = stringList2.indexOf("*");
                result = Double.parseDouble(stringList2.get(index - 1)) * Double.parseDouble(stringList2.get(index + 1));
                stringList2.add(index - 1, String.valueOf(result));
                stringList2.remove(index + 2);
                stringList2.remove(index + 1);
                stringList2.remove(index);
            } else if (stringList2.contains("-")) {
                int index = stringList2.indexOf("-");
                int lastIndex = stringList2.lastIndexOf("-");
                if (index == 0) {
                    result = 0.0 - Double.parseDouble(stringList2.get(index + 1));
                    stringList2.add(0, String.valueOf(result));
                    stringList2.remove(2);
                    stringList2.remove(1);
                } else if ((lastIndex - 2 > 0) && (stringList2.get(lastIndex - 2).equals("-"))) {
                    result = Double.parseDouble(stringList2.get(lastIndex + 1)) + Double.parseDouble(stringList2.get(lastIndex - 1));
                    stringList2.add(lastIndex - 1, String.valueOf(result));
                    stringList2.remove(lastIndex + 2);
                    stringList2.remove(lastIndex + 1);
                    stringList2.remove(lastIndex);
                } else {
                    result = Double.parseDouble(stringList2.get(index - 1)) - Double.parseDouble(stringList2.get(index + 1));
                    stringList2.add(index - 1, String.valueOf(result));
                    stringList2.remove(index + 2);
                    stringList2.remove(index + 1);
                    stringList2.remove(index);
                }
            } else if (stringList2.contains("+")) {
                int index = stringList2.indexOf("+");
                result = Double.parseDouble(stringList2.get(index - 1)) + Double.parseDouble(stringList2.get(index + 1));
                stringList2.add(index - 1, String.valueOf(result));
                stringList2.remove(index + 2);
                stringList2.remove(index + 1);
                stringList2.remove(index);
            }

            // Вот тут все немного коряво. (На всякий случий проверял отсутствие (*/+-))
            if ((!stringList2.contains("*")) && (!stringList2.contains("/")) && (!stringList2.contains("+")) && (!stringList2.contains("-"))) {
                return result;
            }
        }
        return Double.valueOf(stringList2.get(0));
    }
}
