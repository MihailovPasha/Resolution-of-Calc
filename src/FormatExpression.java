/**
 * Класс содержит методы для проверки формата входного выражения.
 */
public class FormatExpression {
    public static void checkingExpression (String[] parts, boolean isRoman, int num1, int num2){
        String operation = parts[1];
        if (!operation.equals("+") && !operation.equals("-") && !operation.equals("*") && !operation.equals("/")) {
            throw new IllegalArgumentException("Неверный оператор. Допустимые операторы: +, -, *, /");
        }
        if (isRoman && (NumberParser.isArabic(parts[0]) || NumberParser.isArabic(parts[2]))) {
            throw new IllegalArgumentException("Нельзя использовать одновременно арабские и римские цифры.");
        }

        if ((!isRoman && (!NumberParser.isArabic(parts[0]) || !NumberParser.isArabic(parts[2])))) {
            throw new IllegalArgumentException("Числа должны быть арабскими и в диапазоне от 1 до 10.");
        }
        if ((num1 < 1 || num1 > 10) || (num2 < 1 || num2 > 10)) {
            throw new IllegalArgumentException("Числа должны быть от 1 до 10 включительно.");
        }
    }

    /**
     * Метод проверяет длину выражения до выполнения остальных условий
     * @param parts String, значения, введённые пользователем
     */
    public static void preCheckingExpression (String[] parts){
        if (parts.length != 3) {
            throw new IllegalArgumentException("Неправильный формат задания");
        }
    }
}
