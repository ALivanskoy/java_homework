
// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, 
// что один человек может иметь несколько телефонов.

import java.util.HashMap;
import java.util.Map;

public class Task1 {

    public static void main(String[] args) {

        Map<Integer, String> idName = new HashMap<>();

        Map<String, Integer> numberId = new HashMap<>();

        idName.put(1, "Иван");
        idName.put(2, "Пётр");
        idName.put(3, "Антон");

        numberId.put("88005553535", 1);
        numberId.put("+71234567890", 2);
        numberId.put("+79876543210", 3);
        numberId.put("+79182736450", 3);

        for (Map.Entry<Integer, String> contact : idName.entrySet()) {
            System.out.println(contact.getValue() + " имеет следующие телефоны:");
            for (Map.Entry<String, Integer> number : numberId.entrySet()) {
                if (contact.getKey() == number.getValue()) {
                    System.out.println(number.getKey());
                }

            }

        }

    }

}