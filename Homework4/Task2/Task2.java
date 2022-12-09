
// Реализуйте очередь с помощью LinkedList со следующими методами:
// enqueue() - помещает элемент в конец очереди, 
// dequeue() - возвращает первый элемент из очереди и удаляет его, 
// first() - возвращает первый элемент из очереди, не удаляя.

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Task2 {

    public static void main(String[] args) {

        LinkedList lList = new LinkedList<>();

        fillRandomise(lList, 7, 1, 10);
        System.out.println("Изначальный LinkedList:");
        System.out.println(lList.toString());

        enqueue(lList, 4);
        System.out.println("Результат работы функции enqueue(4):");
        System.out.println(lList.toString());
        System.out.println("Результат работы функции dequeue():");
        System.out.println(dequeue(lList));
        System.out.println("LinkedList после работы функции dequeue():");
        System.out.println(lList.toString());
        System.out.println("Результат работы функции first():");
        System.out.println(first(lList));

    }

    public static void fillRandomise(List list, int value, int min, int max) {

        Random rand = new Random();

        for (int i = 0; i < value; i++) {

            list.add(rand.nextInt(min, max));
        }
    }

    public static void enqueue(LinkedList inputList, Object element) {

        inputList.add(element);
    }

    public static Object dequeue(LinkedList inputList) {

        var outputElemet = inputList.get(0);
        inputList.removeFirst();
        return outputElemet;
    }

    public static Object first(LinkedList inputList) {

        var outputElemet = inputList.get(0);
        return outputElemet;
    }

}