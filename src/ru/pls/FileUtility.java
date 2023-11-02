package ru.pls;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileUtility {
    public static ArrayList<? extends Record> parseFileToMonthToRecord(String pathToFile) {
        try {
            String separator = File.separator;
            final String content = Files.readString(Path.of(pathToFile)); //читаем содержимое файла, находящегося по адресу "pathToFile" в константу content
            final String[] lines = content.split("\\r\\n"); //разбиваем содержимое на строки
            if (("F:" + separator + "git" + separator + "services" + separator + "services" + separator + "src" + separator + "ru" + separator + "pls" + separator + "file" + separator + "m").equals(pathToFile.substring(0, 38))) {
                return parseStringMonthToWord(lines);
            } else
                return parseStringYearToWord(lines);

        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл");
            throw new RuntimeException(e);
        }

    }

    /*
     *   public static ArrayList<RecordYear> parseFileToYearToRecord (String pathToFile) throws IOException {
     *      try {
     *          final String content = Files.readString(Path.of(pathToFile)); //читаем содержимое файла, находящегося по адресу "pathToFile" в константу content
     *          final String[] lines = content.split("\\r\\n"); //разбиваем содержимое на строки
     *          return parseStringYearToWord(lines);
     *      } catch (IOException e) {
     *          System.out.println("Невозможно прочитать файл");
     *          throw new RuntimeException(e);
     *      }
     *
     *  }
     */
    public static ArrayList<RecordMonth> parseStringMonthToWord(String[] array) {
        ArrayList<RecordMonth> recordMonths = new ArrayList<>(); //создаем список типа RecordMonth для хранения строк(RecordMonth - ранее оъявленный класс)
        for (int i = 1; i < array.length; i++) {
            String[] elements = array[i].split(";");
            //разбиваем строки по разделителю ","
            //записываем полученные элементы в RecordMonth предварительно преобразовывая их из строки в необходимый формат
            recordMonths.add(new RecordMonth(elements[0], Boolean.valueOf(elements[1]), Integer.parseInt(elements[2]), Integer.parseInt(elements[3])));
            // преоразование  BigDecimal если что - BigDecimal.valueOf(Double.valueOf(array[3])))
        }
        return recordMonths;
    }

    public static ArrayList<RecordYear> parseStringYearToWord(String[] array) {

        ArrayList<RecordYear> records = new ArrayList<>(); //создаем список типа RecordYear для хранения строк(RecordYear - объявленный класс)
        for (int i = 1; i < array.length; i++) {
            String[] elements = array[i].split(";");  //разбиваем строки по разделителю ";"

            //записываем полученные элементы в RecordMonth предварительно преобразовывая их из строки в необходимый формат
            records.add(new RecordYear(Integer.parseInt(elements[0]), BigDecimal.valueOf(Double.parseDouble(elements[1])), Boolean.valueOf(elements[2])));
        }
        return records;
    }

    public static void loadMonthData() {
        String fileName;
        MonthlyReport monthlyReport = new MonthlyReport();
        String separator = File.separator;
        for (int i = 1; i <= 3; i++) {
            if (i < 10) {
                fileName = "F:" + separator + "git" + separator + "services" + separator + "services" + separator + "src" + separator + "ru" + separator + "pls" + separator + "file" + separator + "m20230" + i + ".csv";
            } else
                fileName = "F:" + separator + "git" + separator + "services" + separator + "services" + separator + "src" + separator + "ru" + separator + "pls" + separator + "file" + separator + "m2023" + i + ".csv";
            monthlyReport.addMonthRecord(i, parseFileToMonthToRecord(fileName));
        }


 }
}
