/**
 * Класс выполняет арифметические операции.
 */
public class OperationExecutor {
    public static int execute(int num1, String operation, int num2){
        switch (operation) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) {
                    throw new ArithmeticException("Деление на ноль.");
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Неверный оператор: " + operation);
        }
    }
}
