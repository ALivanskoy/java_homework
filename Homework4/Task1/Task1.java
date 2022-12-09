// Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Task1 {

    public static void main(String[] args) {
        List lList = new LinkedList<>();

        fillRandomise(lList, 7, 1, 10);

        System.out.println(lList.toString());

        System.out.println(listReverse(lList).toString());

    }

    public static void fillRandomise(List list, int value, int min, int max) {

        Random rand = new Random();

        for (int i = 0; i < value; i++) {

            list.add(rand.nextInt(min, max));
        }
    }

    public static List listReverse(List list) {

        List outList = new LinkedList<>();

        for (int i = list.size() - 1; i >= 0; i--) {
            outList.add(list.get(i));
        }

        return outList;
    }

}
