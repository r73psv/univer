package ru.psv.tracker;

import java.util.Scanner;

public class Menu {

public static void mainMenu(){


    Scanner sc = new Scanner(System.in);
    StepTracker stepTracker =new StepTracker();
    while (true) {
      printMenu();
      int command = sc.nextInt();
      if (command==0){
          break;
      } else {

            switch (command) {
                case 1: {
                    int numOfMonth=0;
                    int numOfDate=0;
                    int countSteps=0;
                    boolean flag=true;
                    while (flag){
                        System.out.println("Введите номер месяца - число от 1 до 12");
                        numOfMonth=sc.nextInt();
                    if (numOfMonth<=0 || numOfMonth>12){
                        System.out.println("Такого месяца не существует");
                    } else {
                        flag=false;
                    }
                    }

                    flag=true;
                    while (flag){
                    System.out.println("Введите дату");
                    numOfDate=sc.nextInt();
                    if (numOfMonth==2){
                        if (numOfDate<=0 || numOfDate>29){
                            System.out.println("Такой даты в этом месяце нет");
                        } else {
                            flag=false;
                        }
                    } else if (numOfMonth==4|| numOfMonth==6||numOfMonth==9||numOfMonth==11) {
                        if (numOfDate<=0 || numOfDate>30){
                            System.out.println("Такой даты в этом месяце нет");
                        }
                        else {
                            flag=false;
                        }
                    } else {
                        if (numOfDate <= 0 || numOfDate > 31) {
                            System.out.println("Такой даты в этом месяце нет");
                        } else {
                            flag = false;
                        }
                    }

                }

               flag=true;
               while (flag) {
                   System.out.println("Введите количество шагов");
                   countSteps =sc.nextInt();
                   if (countSteps<0){
                       System.out.println("Количество шаов не может быть отрицательным");
                   } else {
                       flag=false;
                   }
               }
                    stepTracker.saveStepsOfDay(numOfMonth, numOfDate, countSteps);
              }
              break;

                case 2: {
                    int numOfMonth=0;
                    boolean flag=true;
                    while (flag){
                      System.out.println("Введите номер месяца - число от 1 до 12");
                      numOfMonth=sc.nextInt();
                      if (numOfMonth<=0 || numOfMonth>12) {
                            System.out.println("Такого месяца не существует");

                        } else {
                            flag=false;
                        }
                    }
                    stepTracker.printStepsToDay(numOfMonth);
                }
                break;

                case 3: {
                    boolean flag=true;
                    int purposeSteps=0;
                    while (flag) {
                        System.out.println("Введите количество шагов");
                        purposeSteps =sc.nextInt();
                        if (purposeSteps<0){
                            System.out.println("Количество шагов не может быть отрицательным");
                        } else {
                            flag=false;
                        }
                    }
                    stepTracker.setPurposeSteps(purposeSteps);
                }
                break;

                default:
                    System.out.println("Извините, такой команды пока нет.");
            }
        }
    }
}

    public static void printMenu () {
            System.out.println("Что вы хотите сделать? ");
            System.out.println("1 - Ввести количество шагов за определенный день");
            System.out.println("2 - Напечатать статистику за определенный месяц");
            System.out.println("3 - Изменить цель по количеству шагов в день");
            System.out.println("0 - Выход");
    }


}


