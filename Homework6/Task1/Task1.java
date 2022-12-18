
// 1.Подумать над структурой класса Ноутбук для магазина техники - выделить поля
// и методы. Реализовать в java.

// 2.Создать множество ноутбуков.

// 3.Написать метод, который будет запрашивать у пользователя критерий (или
// критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии
// фильтрации можно хранить в Map. Например:

// “Введите цифру, соответствующую необходимому критерию:
// 1 - ОЗУ
// 2 - Объем ЖД
// 3 - Операционная система
// 4 - Цвет …

// 4. Далее нужно запросить минимальные значения для указанных критериев -
// сохранить параметры фильтрации можно также в Map.

// 5. Отфильтровать ноутбуки их первоначального множества и вывести проходящие
// по условиям.

import java.util.Scanner;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class Task1 {

    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        Set<Laptop> laptops = new HashSet<>();

        laptops.add(new Laptop("Asus", "win10", "black", "8", "125"));
        laptops.add(new Laptop("Asus", "win8", "red", "16", "250"));
        laptops.add(new Laptop("Asus", "win7", "blue", "4", "100"));
        laptops.add(new Laptop("Sony", "win7", "red", "8", "125"));
        laptops.add(new Laptop("Sony", "win8", "blue", "16", "250"));
        laptops.add(new Laptop("Sony", "bios", "black", "4", "100"));

        System.out.println(laptops);

        laptops = laptopFilter(laptops);

    }

    public static Set<Laptop> laptopFilter(Set unfiltred) {

        System.out.println("Фильтрация из имеющихся ноутбуков");

        Set<Laptop> filtred = new HashSet<>();

        String[] filterMask = getChoise();
        String filterParameter = filterMask[0];
        String filterValue = filterMask[1];

        Iterator<Laptop> iterator = unfiltred.iterator();
        while (iterator.hasNext()) {

            Laptop laptop = iterator.next();
            Map<String, String> laptopMap = laptop.toMap();

            if (laptopMap.containsKey(filterParameter)) {

                if (isDigit(filterValue) &&
                        Integer.parseInt(filterValue) <= Integer.parseInt(laptopMap.get(filterParameter))) {
                    filtred.add(laptop);
                } else if (filterValue.equals(laptopMap.get(filterParameter))) {
                    filtred.add(laptop);
                }

            }
        }

        System.out.println("Список отсортированных ноутбуков:\n" + filtred.toString());

        System.out.println("Продолжить сортировку? y/n\n");

        if (scn.nextLine().equals("y"))
            filtred = laptopFilter(filtred);
        return filtred;
    }

    public static String[] getChoise() {

        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - Производитель");
        System.out.println("2 - OS");
        System.out.println("3 - цвет");
        System.out.println("4 - объём RAM");
        System.out.println("5 - объём HDD");

        String[] output = new String[2];
        int choise = Integer.parseInt(scn.nextLine());

        switch (choise) {
            case 1: {
                System.out.println("Введите производителя:");
                output[0] = "manufacturer";
                output[1] = scn.nextLine();
            }
                break;
            case 2: {
                System.out.println("Введите OS:");
                output[0] = "os";
                output[1] = scn.nextLine();
            }
                break;
            case 3: {
                System.out.println("Введите цвет:");
                output[0] = "collor";
                output[1] = scn.nextLine();
            }
                break;
            case 4: {
                System.out.println("Введите объём RAM (не меньше желаемого)");
                output[0] = "ram";
                output[1] = scn.nextLine();
            }
                break;
            case 5: {
                System.out.println("Введите объём HDD (не меньше желаемого)");
                output[0] = "memory";
                output[1] = scn.nextLine();
            }
                break;
            default: {
                output[0] = "err";
                output[1] = "err";
            }
                break;
        }

        return output;

    }

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
