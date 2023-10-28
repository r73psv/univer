package ru.pls;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileUtility {
    public List<Record> parseToReport(String pathToFile) throws IOException {
        try {
            final String content = Files.readString(Path.of(pathToFile)); //читаем содержимое файла, находящегося по адресу "pathToFile" в константу content

            final String[] lines = content.split("\n"); //разбиваем содержимое на строки
            ArrayList<Record> records=new ArrayList<>(); //создаем список типа Record для хранения строк(Record - сщзданный класс)
            for (int i=1; i< lines.length; i++) {
                 String[] elements = lines[i].split(",");    //разбиваем строки по разделителю ","

                //записываем полученные элементы в Record предварительно преобразовывая их из строки в необходимый формат
                records.add(new Record(lines[0],Boolean.valueOf(lines[1]),Integer.valueOf(lines[2]), BigDecimal.valueOf(Double.valueOf(lines[3]))));
               }
            return records;
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл");
            throw new RuntimeException(e);
        }

    }

}
