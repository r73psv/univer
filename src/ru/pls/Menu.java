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
                        FileUtility.loadYearData();
                        }

                    break;

                        case 3: {
                            //YearlyReport.equalsAmount();
                            MonthlyReport.equalsExpenses();
                        }
                        break;
                        case 4: {

                            int yearExpense = MonthlyReport.sumAmountYearExpense();
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
