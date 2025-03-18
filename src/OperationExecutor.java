/**
 * Класс выполняет арифметические операции.
 */
public class OperationExecutor {
    public static int execute(int firstNumber, String operation, int secondNumber){
        switch (operation) {
            case "+":
                return firstNumber + secondNumber;
            case "-":
                return firstNumber - secondNumber;
            case "*":
                return firstNumber * secondNumber;
            case "/":
                if (secondNumber == 0) {
                    throw new ArithmeticException("Деление на ноль.");
                }
                return firstNumber / secondNumber;
            default:
                throw new IllegalArgumentException("Неверный оператор: " + operation);
        }
    }
}
