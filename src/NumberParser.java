public class NumberParser {
    public static int parse(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static boolean isArabic(String str) {
        try {
            int number = Integer.parseInt(str);
            return number >= 1 && number <= 10;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}