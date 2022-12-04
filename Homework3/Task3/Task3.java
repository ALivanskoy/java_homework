// Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Task3 {

    public static void main(String[] args) {

        List<Integer> items = new ArrayList<Integer>();

        fillList(10, items);
        System.out.println("Start items: " + items);
        System.out.println("min item: " + findMin(items));
        System.out.println("max item: " + findMax(items));
        System.out.println("avg item: " + findAvg(items));

    }

    private static void fillList(int length, List<Integer> list) {
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            list.add(random.nextInt(20));
        }
    }

    private static int findMin(List<Integer> list) {
        int min = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            if (min > list.get(i)) {
                min = list.get(i);
            }
        }
        return min;
    }

    private static int findMax(List<Integer> list) {
        int max = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            if (max < list.get(i)) {
                max = list.get(i);
            }
        }
        return max;
    }

    private static double findAvg(List<Integer> list) {
        int sum = 0;

        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }

        double avg = (double) sum / (double) list.size();
        return avg;
    }
}