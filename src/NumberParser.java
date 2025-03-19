public class NumberParser {

    private static Integer tryParse(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static int parse(String number) {
        Integer parsedNumber = tryParse(number);
        if (parsedNumber == null) {
            return -1;
        }
        return parsedNumber;
    }

    public static boolean isArabic(String str) {
        Integer parsedNumber = tryParse(str);
        return parsedNumber != null && parsedNumber >= 1 && parsedNumber <= 10;
    }
}