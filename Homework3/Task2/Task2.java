// Пусть дан произвольный список целых чисел, удалить из него четные числа

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Task2 {

    public static void main(String[] args) {

       List<Integer> items = new ArrayList<Integer>();
        
        fillList(10, items);
        System.out.println("Start items: " + items);
        delOddElements(items);
        System.out.println("Filtered items: " + items);
    }

    private static void fillList(int length, List<Integer> list) {
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            list.add(random.nextInt(20));
        }
    }

    private static void delOddElements(List<Integer> list) {
        for (int i = list.size() - 1; i >= 0; i--) {

            if (list.get(i) % 2 == 0) {
                list.remove(i);
            }
        }
    }
}