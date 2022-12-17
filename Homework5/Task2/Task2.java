
// Пусть дан список сотрудников: Иван, Пётр, Антон и так далее. 
// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. 
// Отсортировать по убыванию популярности.

import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Task2 {

    public static void main(String[] args) {

        String file = "employees.txt";
        List<String> employees = getListFromFile(file);

        System.out.println(employees);

        Map<String, Integer> employeesEntry = countThingsInList(employees);

        employeesEntry.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(System.out::println);

    }

    static String getStringFromFile(String path) {
        StringBuilder sb = new StringBuilder();
        try {

            FileReader fr = new FileReader(path);
            int c = 0;

            while ((c = fr.read()) != -1) {
                sb.append((char) c);
            }

        } catch (Exception e) {
            return e.toString();
        }
        return sb.toString();
    }

    static String[] sortedArray(String inputStr) {
        return inputStr.replace(" ", "").split(",");
    }

    static LinkedList sortedList(String[] inputArray) {

        LinkedList<String> outputList = new LinkedList<>();

        for (String string : inputArray) {
            outputList.add(string);
        }
        return outputList;
    }

    static List getListFromFile(String path) {

        return sortedList(sortedArray(getStringFromFile(path)));
    }

    static HashMap countThingsInList(List inputlist) {

        HashMap<String, Integer> map = new HashMap<>();

        for (var str : inputlist) {
            if (map.containsKey((String) str)) {
                map.put((String) str, (map.get((String) str) + 1));
            }

            else {
                map.put((String) str, 1);
            }

        }

        return map;
    }

}