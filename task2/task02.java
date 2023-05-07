// Задание 2.
// Дана строка (получение через обычный текстовый файл!!!)

// "фамилия":"Иванов","оценка":"5","предмет":"Математика"
// "фамилия":"Петрова","оценка":"4","предмет":"Информатика"

// Написать метод(ы), который распарсит строку и, используя StringBuilder, создаст строки вида:
// Студент [фамилия] получил [оценка] по предмету [предмет].

// Пример вывода в консоль:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.

package task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class task02 {
    public static void main(String[] args) {
        String filePath = "students.txt";

        try (FileReader fr = new FileReader(filePath);
                BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String surname = parts[0].split(":")[1].replace("\"", "");
                String mark = parts[1].split(":")[1].replace("\"", "");
                String subject = parts[2].split(":")[1].replace("\"", "");

                StringBuilder sb = new StringBuilder();
                sb.append("Student ").append(surname).append(" get ")
                        .append(mark).append(" subject ").append(subject).append(".");
                System.out.println(sb.toString());
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}