/**
 * Класс выполняет основную логику калькулятора: разбивает входную строку,
 * определяет систему счисления, выполняет вычисления и форматирует результат.
 */
public class CalculatorService {
    public static String calculate(String args) {
        String[] parts = args.split(" ");

        FormatExpression.preCheckingExpression(parts);

        String firstNumber = parts[0];
        String operation = parts[1];
        String secondNumber = parts[2];

        boolean isRoman = false;
        int num1;
        int num2;

        num1 = NumberParser.parse(firstNumber);
        num2 = NumberParser.parse(secondNumber);

        if (num1 == -1 || num2 == -1)
        {
            try {
                num1 = RomanToArabConverter.convertToArab(firstNumber);
                num2 = RomanToArabConverter.convertToArab(secondNumber);
                isRoman = true;
            } catch (IllegalArgumentException ex) {
                throw new IllegalArgumentException("Неверный формат чисел: должны быть арабские или римские (от I до X).");
            }
        }

        FormatExpression.checkingExpression(parts,isRoman,num1,num2);
        int result = OperationExecutor.execute(num1,operation,num2);

        if (isRoman) {
            if (result < 1) {
                throw new ArithmeticException("Результат работы с римскими числами не может быть меньше единицы.");
            }
            return ArabToRomanConverter.convertToRoman(result);
        } else {
            return String.valueOf(result);
        }
    }
}
