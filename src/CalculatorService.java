/**
 * Класс выполняет основную логику калькулятора: разбивает входную строку,
 * определяет систему счисления, выполняет вычисления и форматирует результат.
 */
public class CalculatorService {
    public static String calculate(String args) {
        String[] parts = args.split(" ");

        FormatExpression.checkInputLength(parts);

        String firstNumber = parts[0];
        String operation = parts[1];
        String secondNumber = parts[2];

        boolean isRoman = false;

        int resultOfParseOfFirstNumber = NumberParser.parse(firstNumber);
        int resultOfParseOfSecondNumber = NumberParser.parse(secondNumber);

        if (resultOfParseOfFirstNumber == -1 || resultOfParseOfSecondNumber == -1) {
            try {
                resultOfParseOfFirstNumber = Converter.toArabic(firstNumber);
                resultOfParseOfSecondNumber = Converter.toArabic(secondNumber);
                isRoman = true;
            } catch (IllegalArgumentException ex) {
                throw new IllegalArgumentException("Неверный формат чисел: должны быть арабские или римские (от I до X).");
            }
        }

        FormatExpression.checkExpression(parts, isRoman, resultOfParseOfFirstNumber, resultOfParseOfSecondNumber);
        int result = OperationExecutor.execute(resultOfParseOfFirstNumber, operation, resultOfParseOfSecondNumber);

        if (isRoman) {
            if (result < 1) {
                throw new ArithmeticException("Результат работы с римскими числами не может быть меньше единицы.");
            }
            return Converter.toRoman(result);
        } else {
            return String.valueOf(result);
        }
    }
}
