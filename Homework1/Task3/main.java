// Реализовать простой калькулятор

import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Введите математическое выражение вида 'x/y' без пробелов\n (прим.: 24-15)\n");
        String a = input.next();
        System.out.print("\033[H");
        System.out.print(a + " = " + Calc(a));
        input.close();
    }

    public static String Calc(String str) {
        // метод обработки основных математических действий

        String sym = GetMathAction(str);
        String[] nums = GetNums(str, sym);
        var num = switch (sym) {
            case "\\+":
                yield (Integer.parseInt(nums[0]) + Integer.parseInt(nums[1]));
            case "-":
                yield (Integer.parseInt(nums[0]) - Integer.parseInt(nums[1]));
            case "/":
                yield (Float.parseFloat(nums[0]) / Float.parseFloat(nums[1]));
            case "\\*":
                yield (Integer.parseInt(nums[0]) * Integer.parseInt(nums[1]));
            default:
                yield "error";
        };
        return num.toString();
    }

    private static String GetMathAction(String str) {
        // метод получения математического действия из строки:
        // пробегаемся по строке, пытаясь найти символ математического выражения
        //возвращаем найденный символ как строку
        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case '+':
                    return "\\+";
                case '-':
                    return "-";
                case '/':
                    return "/";
                case '*':
                    return "\\*";
            }
        }
        return "0";
    }

    private static String[] GetNums(String str, String sym) {
        // метод получения массива чисел из выражения
        // разбиваем выражение на два числа
        return str.split(sym);
    }
}