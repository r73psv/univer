package ru.pls;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileUtility {
    public static ArrayList<Record> parseFileToMonthToRecord (String pathToFile) throws IOException {
        try {
            final String content = Files.readString(Path.of(pathToFile)); //читаем содержимое файла, находящегося по адресу "pathToFile" в константу content
            final String[] lines = content.split("\\r\\n"); //разбиваем содержимое на строки
            return parseStringMonthToWord(lines);
            } catch (IOException e) {
            System.out.println("Невозможно прочитать файл");
            throw new RuntimeException(e);
        }

    }

    public static ArrayList<RecordYear> parseFileToYearToRecord (String pathToFile) throws IOException {
        try {
            final String content = Files.readString(Path.of(pathToFile)); //читаем содержимое файла, находящегося по адресу "pathToFile" в константу content
            final String[] lines = content.split("\\r\\n"); //разбиваем содержимое на строки
            return parseStringYearToWord(lines);
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл");
            throw new RuntimeException(e);
        }

    }
    public static ArrayList<Record> parseStringMonthToWord(String [] array) {
        ArrayList<Record> records=new ArrayList<>(); //создаем список типа Record для хранения строк(Record - сoзданный класс)
        for (int i=1; i< array.length; i++) {
            String[] elements = array[i].split(";");
            //разбиваем строки по разделителю ","
            //записываем полученные элементы в Record предварительно преобразовывая их из строки в необходимый формат
        records.add(new Record(elements[0],Boolean.valueOf(elements[1]), Integer.parseInt(elements[2]), Integer.parseInt(elements[3])));
        // преоразование  BigDecimal если что - BigDecimal.valueOf(Double.valueOf(array[3])))
        }
        return records;
    }
    public static ArrayList<RecordYear> parseStringYearToWord (String [] array) {

        ArrayList<RecordYear> records=new ArrayList<>(); //создаем список типа Record для хранения строк(Record - сoзданный класс)
        for (int i=1; i< array.length; i++) {
            String[] elements = array[i].split(";");  //разбиваем строки по разделителю ","

            //записываем полученные элементы в Record предварительно преобразовывая их из строки в необходимый формат
            records.add(new RecordYear(Integer.valueOf(elements[0]), BigDecimal.valueOf(Double.parseDouble(elements[1])), Boolean.valueOf(elements[2])));
        }
        return records;
    }
 public  static  void loadMonthData() throws IOException {
        String fileName;
        MonthlyReport monthlyReport = new MonthlyReport();
        for (int i=1;i<=3;i++){
            if (i<10){
                fileName = "F:\\git\\services\\services\\src\\ru\\file\\m20230"+i+".csv";
            } else
                fileName = "F:\\git\\services\\services\\src\\ru\\file\\m2023"+i+".csv";
          monthlyReport.addMonthRecord(i, parseFileToMonthToRecord(fileName));
        }


 }
}
