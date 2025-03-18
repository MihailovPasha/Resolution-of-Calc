import java.util.Scanner;

/**
 *
 */
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Введите задание (например, 1 + 2 или V - I):");
        String input = s.nextLine();

        try {
            String result = CalculatorService.calculate(input);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            s.close();
        }
    }
}