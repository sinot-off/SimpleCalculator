import java.util.Scanner;

/**
 * Главный класс Калькулятор:
 * конструктор принимает исходное выражение,
 * а метод Calculate вычисляет выражение
 */
public class Calculator {
    // выражение
    private String expr;
    // результат
    private String result;

    public Calculator(String expr) {
        this.expr = expr;
    }

    /**
     * метод вычисления выражения определяет, какой класс использовать для вычисления выражения,
     * и в зависимости от этого вычисляет выражение
     */
    public void calculate() {
        Scanner sc = new Scanner(expr);
        String[] exprArr = expr.split(" ");
        if (exprArr.length != 3) {
            throw new RuntimeException("Ошибка ввода. Попробуйте еще раз.");
        }
        /** если первым в выражении идет целое число,
         *  то вычисляем выражение с арабскими числами
         *  иначе вычисляем выражение с римскими числами
         */
        if (sc.hasNextInt()) {
            ArabicCalculator arCalc = new ArabicCalculator(exprArr);
            arCalc.calc();
            result = arCalc.getResult();
        } else {
            RomanCalculator romCalc = new RomanCalculator(exprArr);
            romCalc.calc();
            result = romCalc.getResult();
        }
    }

    public String getResult() {
        return result;
    }
}
