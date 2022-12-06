// Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

import java.util.logging.*;
import java.util.Arrays;
import java.io.File;
import java.io.IOException;

public class main {

    public static Logger logger = Logger.getLogger(main.class.getName());

    /*
     * Этот кусок кода вне функции почему-то не работает:
     * FileHandler fh = new FileHandler("log.txt");
     * logger.addHandler(fh);
     * public static SimpleFormatter sFormat = new SimpleFormatter();
     * fh.setFormatter(sFormat);
     */

    public static void main(String[] args) throws Exception {

        // тот же кусок кода, но тут он уже работает:

        FileHandler fh = new FileHandler("log.txt");
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);

        int[] nums = new int[] { 4, 1, 2, 5, 7, 3 };

        StringBuilder sb = new StringBuilder();

        sb.append("input numbers: ");
        sb.append(Arrays.toString(nums));
        logger.info(sb.toString());

        bubbleSort(nums);

    }

    public static void bubbleSort(int[] numbers) throws IOException {

        logger.info("Start sorting");

        int swap = 0;
        for (int i = numbers.length - 1; i >= 0; i--) {

            for (int j = 0; j < i; j++) {

                if (numbers[j] > numbers[j + 1]) {
                    swap = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = swap;
                }

            }

            logger.info(Arrays.toString(numbers));

        }
        logger.info("End sorting");
    }
}
