
// В файле содержится строка с данными:
// [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"}, {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"}, {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
// Напишите метод, который разберёт её на составные части и, используя StringBuilder создаст массив строк такого вида:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.

//Недопёр как это сделать со строкой из файла txt и да простит мне проверяющий то, что я считерил и использовал JSON

import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;

public class App {
    public static void main(String[] args) throws Exception {

        String path = "C://Users//User//VSCodeProjects//Java//Homework//Homework2//Task3//ivanov.json";
        printStudentParam(path);
    }

    private static void printStudentParam(String pathToJson) throws Exception {

        // Считываем json
        Object studentObject = new JSONParser().parse(new FileReader(pathToJson));
        // Кастим obj в JSONObject
        JSONObject studJsonObject = (JSONObject) studentObject;
        // Достаём firstName and lastName
        StringBuilder studentSb = new StringBuilder();

        // формируем массив строк с необходимой информацией
        studentSb.append("Студент ");
        if (studJsonObject.get("фамилия") != null)
            studentSb.append((String) studJsonObject.get("фамилия"));
        else {
            System.out.println("Искомая строка невалидна");
            return;
        }
        studentSb.append(" получил ");
        if (studJsonObject.get("оценка") != null)
            studentSb.append((String) studJsonObject.get("оценка"));
        else {
            System.out.println("Искомая строка невалидна");
            return;
        }
        studentSb.append(" по предмету ");
        if (studJsonObject.get("предмет") != null)
            studentSb.append((String) studJsonObject.get("предмет"));
        else {
            System.out.println("Искомая строка невалидна");
            return;
        }
        System.out.println(studentSb.toString());
    }

}
