// Вывести все простые числа от 1 до 1000

public class main {

    public static boolean isPrimeNum(int num) {

        if (num == 0 || num == 1)
            return false;

        // пытаемся найти число, на которое наше искомое делится без остатка:
        for (int i = 2; i < num - 1; i++) {
            if (num % i == 0)
                return false;
        }
        // если такогового нет, возвращаем true
        return true;
    }

    public static void main(String[] args) {

        for (int i = 1; i < 1000; i++) {

            if (isPrimeNum(i))
                System.out.println(i);

        }

    }

}
