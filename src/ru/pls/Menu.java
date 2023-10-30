package ru.pls;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

    public static void mainMenu() throws IOException {


        Scanner sc = new Scanner(System.in);


        while (true) {
            printMenu();
            int command = sc.nextInt();
            if (command == 0) {
                break;
            } else {

                switch (command) {
                    case 1: {
                        FileUtility.loadMonthData();
                    }
                    break;

                    case 2: {
                        int numOfMonth = 0;
                        boolean flag = true;
                        while (flag) {
                            System.out.println("Введите номер месяца - число от 1 до 12");
                            numOfMonth = sc.nextInt();
                            if (numOfMonth <= 0 || numOfMonth > 12) {
                                System.out.println("Такого месяца не существует");

                            } else {
                                flag = false;
                            }
                        }
                    }
                        break;

                        case 3: {
                            boolean flag = true;
                            int purposeSteps = 0;
                            while (flag) {
                                System.out.println("Введите количество шагов");
                                purposeSteps = sc.nextInt();
                                if (purposeSteps < 0) {
                                    System.out.println("Количество шагов не может быть отрицательным");
                                } else {
                                    flag = false;
                                }
                            }

                        }
                        break;
                        case 4: {
                        }
                        break;
                        case 5: {
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
        System.out.println("1 - Считать все месячные отчеты");
        System.out.println("2 - Считать годовой отчет");
        System.out.println("3 - Сверить информацию");
        System.out.println("4 - Вывести информацию о всех месячных отчетах");
        System.out.println("5 - Вывести информацию о годовом отчете");
        System.out.println("0 - Выход");
    }


}
