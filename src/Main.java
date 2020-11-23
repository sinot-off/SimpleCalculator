import java.util.Scanner;

/**
 * Основная программа
 */
public class Main {
    public static void main(String[] args) {
        // выводим приветствие
        System.out.println("Калькулятор:");
        System.out.println(" Введите арифметическое выражение (через пробел):");
        // создаем сканер
        Scanner sc = new Scanner(System.in);
        // получаем пользовательский ввод
        String input = sc.nextLine();
        // создаем калькулятор
        Calculator calc = new Calculator(input);
        // вычисляем выражение
        calc.calculate();
        // и выводим результат
        System.out.println(calc.getResult());
    }
}
