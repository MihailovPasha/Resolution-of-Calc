/**
 * Класс Calc - класс калькулятор, который выполняет арифметические действия(+, -, *, /)
 * и проверяет правильность введённых значений
 */
public class Calc {
    /**
     * Метод Calc отвечает за действия калькулятора и проверку правильности введённых значений;
     * @param args String, на вход принимает строковые значения;
     * @return В зависимости от проверки значений возвращает арабский либо римский результат операции;
     * @throws Exception Исключения, при которых производится проверка и ошибки;
     */
    public static String calс(String args) throws Exception {
        String[] parts = args.split(" ");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Неправильный формат задания");
        }
        String chislo1 = parts[0];
        String operation = parts[1];
        String chislo2 = parts[2];

        int num1;
        int num2;
        boolean isRoman = false;
        int result;
        try {
            num1 = Integer.parseInt(chislo1); // Пытается преобразовать входящие значения чисел в целые числа.
            num2 = Integer.parseInt(chislo2); // Если это удается, считает, что это арабские числа.
        } catch (NumberFormatException e1) {
            try {
                num1 = Roma.getValue(chislo1); // Если преобразование в целые числа не удается,
                num2 = Roma.getValue(chislo2); // пытается преобразовать входящие значения чисел в римские числа.
                isRoman = true;
            } catch (IllegalArgumentException e2) {
                throw new IllegalArgumentException("Неправильный формат чисел: должны быть арабские или римские (от 1 до 10)");
            }
        }
        if (isRoman && (isArabic(chislo1) || isArabic(chislo2))) {
            throw new IllegalArgumentException("Нельзя использовать одновременно арабские и римские цифры.");
        }

        if ((!isRoman && (!isArabic(chislo1) || !isArabic(chislo2)))) {
            throw new IllegalArgumentException("Числа должны быть арабскими и в диапазоне от 1 до 10.");
        }
        if ((num1 < 1 || num1 > 10) || (num2 < 1 || num2 > 10)) {
            throw new IllegalArgumentException("Числа должны быть от 1 до 10 включительно.");
        }
        switch (operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    throw new ArithmeticException("Деление на ноль.");
                }
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("Неверный оператор. Допустимые операторы: +, -, *, /");
        }
        if (isRoman) {
            if (result < 1) {
                throw new ArithmeticException("Результат работы с римскими числами не может быть меньше единицы.");
            }
            return Roma.toRoman(result);
        } else {
            return String.valueOf(result);
        }
    }

    /**
     * Метод проверяет строку на возможность преобразования в арабское число от 1 до 10 включительно;
     * @param str String, принимает в качестве входящих параметров строковое значение
     * @return Возвращает логическое значение
     */
    public static boolean isArabic(String str) {
        try {
            int num = Integer.parseInt(str);
            return num >= 1 && num <= 10;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
