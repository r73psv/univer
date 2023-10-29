package ru.pls;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileUtility {
    public String[] parseFileToStringArray(String pathToFile) throws IOException {
        try {
            final String content = Files.readString(Path.of(pathToFile)); //читаем содержимое файла, находящегося по адресу "pathToFile" в константу content
            final String[] lines = content.split("\n"); //разбиваем содержимое на строки
            return lines;

        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл");
            throw new RuntimeException(e);
        }

    }
    public List<Record> parseStringMonthToWord (String array[]) {
        ArrayList<Record> records=new ArrayList<>(); //создаем список типа Record для хранения строк(Record - сoзданный класс)
        for (int i=1; i< array.length; i++) {
            String[] elements = array[i].split(",");    //разбиваем строки по разделителю ","

            //записываем полученные элементы в Record предварительно преобразовывая их из строки в необходимый формат
            records.add(new Record(array[0],Boolean.valueOf(array[1]),Integer.valueOf(array[2]), Integer.valueOf(array[3])));// преоразование  BigDecimal если что - BigDecimal.valueOf(Double.valueOf(array[3])))
        }
        return records;
    }
    public List<RecordYear> parseStringYearToWord (String array[]) {
        ArrayList<RecordYear> records=new ArrayList<>(); //создаем список типа Record для хранения строк(Record - сoзданный класс)
        for (int i=1; i< array.length; i++) {
            String[] elements = array[i].split(",");    //разбиваем строки по разделителю ","

            //записываем полученные элементы в Record предварительно преобразовывая их из строки в необходимый формат
            records.add(new RecordYear(Integer.valueOf(array[0]), BigDecimal.valueOf(Double.valueOf(array[1])), Boolean.valueOf(array[2])));
        }
        return records;
    }

}
