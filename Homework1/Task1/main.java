
// Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
import java.util.Scanner;

public class main {

    public static int factorial(int num) {
        if (num == 0) {
            return 1;
        } else {
            return num * factorial(num - 1);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Введите число для расчёта факторила: ");
        int number = Integer.parseInt(input.nextLine());
        System.out.printf("%d! = %d\n", number, factorial(number));
        input.close();
    }
}
