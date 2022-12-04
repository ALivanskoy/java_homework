
// В файле содержится строка с исходными данными в такой форме: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
// Требуется на её основе построить и вывести на экран новую строку, в форме SQL запроса:
// SELECT * FROM students WHERE name = "Ivanov" AND country = "Russia" AND city = "Moscow";

// Для разбора строки используйте String.split. Сформируйте новую строку, используя StringBuilder. Значения null не включаются в запрос.

import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class main {

    public static void main(String[] args) {

        String fileName = "ivanov.txt";

        System.out.println(sqlRequest(fileName));

    }

    public static String readFile(String fileName) {

        // метод для чтения файла и записи содержимого в строку

        try (FileReader reader = new FileReader(fileName)) {
            int c;
            StringBuilder sbString = new StringBuilder();
            while ((c = reader.read()) != -1) {

                sbString.append((char) c);
            }

            return sbString.toString();

        } catch (IOException ex) {

            System.out.println(ex.getMessage());
            return "Error";
        }
    }

    private static String[] getTokens(String inputStr) {
        // метод получает пары токенов из полученной строки, удаляя первую и последнюю
        // скобки
        String[] fileTokens = inputStr.substring(1, inputStr.length() - 1).split(",");
        return fileTokens;
    }

    private static String[] getPair(String inputStr) {
        // метод из полученной строки токенов возвращает пару строк с содержимым без
        // ковычек
        String[] outputStrings = inputStr.split(":");
        outputStrings[0] = outputStrings[0].substring(1, outputStrings[0].length() - 1);
        outputStrings[1] = outputStrings[1].substring(1, outputStrings[1].length() - 1);
        return outputStrings;
    }

    private static String sqlRequest(String fileName) {

        String fileString = readFile(fileName);
        String[] tokens = getTokens(fileString);
        String[][] pairs = new String[tokens.length][2];

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM students WHERE ");
        Boolean isFirst = true;

        for (int i = 0; i < pairs.length; i++) {

            pairs[i] = getPair(tokens[i]);

            if (!Objects.equals(pairs[i][1], "null")) {
                if (isFirst == true) {
                    sb.append(pairs[i][0]).append(" = ").append(pairs[i][1]);
                    isFirst = false;
                } else
                    sb.append(" AND ").append(pairs[i][0]).append(" = ").append(pairs[i][1]);
            }

        }

        return sb.toString();
    }
}