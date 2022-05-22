import java.util.Scanner;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите пример:");
        String input = scan.nextLine();
        String[] inputArr = input.split(" ");
        if (inputArr.length < 3) {
            throw new Exception("т.к. строка не является математической операцией");
        } else if (inputArr.length > 3) {
            throw new Exception("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        String s1 = inputArr[0];
        String oper = inputArr[1];
        String s2 = inputArr[2];
        if ((Objects.equals(s2, "1") | Objects.equals(s2, "2") | Objects.equals(s2, "3") |
                Objects.equals(s2, "4") | Objects.equals(s2, "5") | Objects.equals(s2, "6") |
                Objects.equals(s2, "7") | Objects.equals(s2, "8") | Objects.equals(s2, "9") |
                Objects.equals(s2, "10"))
                &&
                (Objects.equals(s1, "1") | Objects.equals(s1, "2") | Objects.equals(s1, "3") |
                        Objects.equals(s1, "4") | Objects.equals(s1, "5") | Objects.equals(s1, "6") |
                        Objects.equals(s1, "7") | Objects.equals(s1, "8") | Objects.equals(s1, "9") |
                        Objects.equals(s1, "10"))) {
            int i1 = Integer.parseInt(s1);
            int i2 = Integer.parseInt(s2);
            int otv;
            if (Objects.equals(oper, "+")) {
                otv = i1 + i2;
            } else if (Objects.equals(oper, "-")) {
                otv = i1 - i2;
            } else if (Objects.equals(oper, "*")) {
                otv = i1 * i2;
            } else if (Objects.equals(oper, "/")) {
                otv = i1 / i2;
            } else {
                throw new Exception("Вы ввели неверный пример");
            }
            System.out.println(otv);
        } else {
            int number1 = romanToNumber(s1);
            int number2 = romanToNumber(s2);
            int otv1;
            if (Objects.equals(oper, "+")) {
                otv1 = number1 + number2;
            } else if (Objects.equals(oper, "-")) {
                otv1 = number1 - number2;
            } else if (Objects.equals(oper, "*")) {
                otv1 = number1 * number2;
            } else if (Objects.equals(oper, "/")) {
                otv1 = number1 / number2;
            } else {
                throw new Exception("Вы ввели неверный пример");
            } if (otv1 < 1) {
                throw new Exception("т.к. в римской системе нет отрицательных чисел");
            } else {
            String resultRoman = convertNumToRoman(otv1);
            System.out.println(resultRoman);
            }
        }
    }

    private static String convertNumToRoman (int numArabian) {
        String[] roman = new String[]{"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV",
                "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII",
                "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII",
                "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI",
                "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV",
                "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII",
                "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII",
                "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX","C"};
        return roman[numArabian];
    }
    private static int romanToNumber (String roman) throws Exception {
        return switch (roman) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> throw new Exception("т.к. используются одновременно разные системы счисления");
        };
    }
}