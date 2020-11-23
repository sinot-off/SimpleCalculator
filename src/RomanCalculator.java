/**
 * класс является расширением класса
 */
public class RomanCalculator extends ArabicCalculator {
    public RomanCalculator(String[] exprArr) {
        super(exprArr);
    }

    /**
     * функция перевода Арабского числа в Римское
     * @param "арабское число"
     * @return "римское число"
     */
    private String arabicToRoman(int num) {
        if (num <= 0) {
            return "Число меньше или равно 0";
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < num; i++) {
            sb.append("I");
        }
        return  sb.toString()
                .replace("IIIII", "V")
                .replace("IIII", "IV")
                .replace("VV", "X")
                .replace("VIV", "IX")
                .replace("XXXXX", "L")
                .replace("XXXX", "XL")
                .replace("LL", "C");
    }

    /**
     * функция перевода Римского числа в Арабское
     * @param "римское число"
     * @return "арабское число"
     */
    private int romanToArabic(String symb) {
        for (ROMANS rom : ROMANS.values()) {
            if (symb.compareTo(rom.toString()) == 0) {
                return rom.ordinal() + 1;
            }
        }
        throw new RuntimeException("Недопустимое число! Попробуйте еще раз.");
    }

    /**
     * метод вычисления выражения
     */
    @Override
    public void calc() {
        String a = exprArr[0];
        String b = exprArr[2];
        String op = exprArr[1];
        int res = eval(romanToArabic(a), romanToArabic(b), op);
        result = arabicToRoman(res);
    }
}
