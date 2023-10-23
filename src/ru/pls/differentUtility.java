package ru.pls;

public class differentUtility {
  //  Проверка валидности (в последнем if  нужно использовать регулярные выражения)
    public static boolean checkPassword(String password){
        if(password.isEmpty()||password.isBlank()){
            System.out.println("пустой пароль");
            return false;
        }
        else if (password.length()<8){
            System.out.println("короткий пароль");
            return false;
        }
        else if (!password.contains("@") && !password.contains("%")){
            System.out.println("пароль не содержит спецсимволов");
            return false;
        }
        return true;
    }

    //startIndex - с какого индекса показывать символы, endIndex до какого индекса показывать
    // изначально была реализация сокрытия номеров банковских карт (0,4)
    public static String hideSumbol(String str, int startIndex, int endIndex) {
       return (str.substring(startIndex, endIndex) + " **** **** " + str.substring(str.length() - endIndex, str.length()));
    }

    //Разбиение строки на подстроки и вывод консоль
    String str= "a, b, cd, ert, d";

    public static void splittingString (String str, char separator) {
        int startIndex=0;
        for (int i= 0; i<str.length();i++){
            if(str.charAt(i)==separator) {
                System.out.println(str.substring(startIndex,i).trim());
                startIndex=i+1;
            }
        }
    }



}