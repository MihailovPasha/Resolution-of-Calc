/**
 * Класс отвечает за перевод арабских чисел в римские и наоборот;
 */
public class RomanNumeral {
    private static final int[] values = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    private static final String[] symbols = {"X", "IX","VIII", "VII", "VI", "V", "IV","III", "II", "I"};

    /**
     * Метод переводит введённое римское значение к соответсвующему арабскому значению;
     *
     * @param symbol String, римское число;
     * @return Возвращает целочисленное значение арабской системы чисел;
     */
    public static int getValue(String symbol) {
        return switch (symbol) {
            case "X" -> 10;
            case "IX" -> 9;
            case "VIII" -> 8;
            case "VII" -> 7;
            case "VI" -> 6;
            case "V" -> 5;
            case "IV" -> 4;
            case "III" -> 3;
            case "II" -> 2;
            case "I" -> 1;
            default -> throw new IllegalArgumentException("Неверный римский символ: " + symbol);
        };
    }

    /**
     * Метод переводит арабские числа в римские
     * @param num int, принимает в качестве входящих параметров целочисленные значения;
     * @return Возвращает строковое значение римской системы чисел;
     */
    public static String toRoman(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException("Римские числа не могут быть меньше единицы.");
        }
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (num > 0) {
            if (values[i] <= num) {
                result.append(symbols[i]);
                num = num - values[i];
            } else {
                i++;
            }
        }
        return result.toString();
    }
}
