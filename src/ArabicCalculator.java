/**
 * класс для реализации арифметики с арабскими числами
 */
public class ArabicCalculator {
    // арифметическое выражение
    protected String[] exprArr;
    // результат вычисления
    protected String result;

    public ArabicCalculator(String[] exprArr) {
        this.exprArr = exprArr;
    }

    /**
     * функция применения арифметической операции
     * @param "число1"
     * @param "число2"
     * @param "оператор"
     * @return "результат выражения"
     */
    protected int eval(int a, int b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
        }
        throw new RuntimeException("Неверная арифметическая операция. Попробуйте еще раз.");
    }

    /**
     * метод вычисления выражения
     */
    public void calc() {
        int a = Integer.parseInt(exprArr[0]);
        int b = 0;
        try {
            b = Integer.parseInt(exprArr[2]);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка ввода! Попробуйте еще раз.");
        }
        if ((a < 1 || a > 10) || (b < 1 || b > 10)) {
            throw new RuntimeException("Числа вне диапазона [1; 10]. Попробуйте еще раз.");
        }
        String op = exprArr[1];
        int res = eval(a, b, op);
        result = String.valueOf(res);
    }

    public String getResult() {
        return result;
    }
}
