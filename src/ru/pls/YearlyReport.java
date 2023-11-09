package ru.pls;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static ru.pls.Menu.mainMenu;

public class YearlyReport {
    static HashMap<Integer, ArrayList<? extends Record>> data = new HashMap<>();

    public YearlyReport() {
        data.put(2023, new ArrayList<>());
    }

    public void addYearRecord(Integer year, ArrayList<? extends Record> yearRecords) {
        data.put(year, yearRecords);
    }

    //
    public static void equalsAmount() {
        if (!data.isEmpty() && !MonthlyReport.data.isEmpty()) {
            ArrayList<? extends Record> ry = YearlyReport.data.get(2023);
            for (int i = 0; i < ry.size(); i++) {
                RecordYear yearRep = (RecordYear) ry.get(i);
                int month = yearRep.month;

                ArrayList<? extends Record> newrep = MonthlyReport.data.get(month);
                if (!yearRep.isExpense) {
                    if (yearRep.amount != MonthlyReport.sumAmountMonthNotExpense(newrep)) {
                        System.out.println("Доходы за " + month + " из годового " + yearRep.amount + " из месячного  " + MonthlyReport.sumAmountMonthNotExpense(newrep));
                        System.out.println("Суммы доходов по годовому и месячному отчетам за " + month + " месяц не совпадают");
                    }
                } else {
                    if (yearRep.amount != MonthlyReport.sumAmountMonthExpense(MonthlyReport.data.get(month))) {
                        System.out.println("Расходы за " + month + " из годового " + yearRep.amount + " из месячного " + MonthlyReport.sumAmountMonthNotExpense(newrep));
                        System.out.println("Суммы расходов по годовому и месячному отчетам за " + month + " месяц не совпадают");
                    }
                }
            }
        } else {
            if (data.isEmpty() && MonthlyReport.data.isEmpty()) {
                System.out.println("Не получены данные годового и  месячных отчетов");
                try {
                    mainMenu();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else if (data.isEmpty()) {
                System.out.println("не получены данные годового отчета");
                try {
                    mainMenu();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("Не получены данные месячных отчетов");
                try {
                    mainMenu();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void yearlyReportInfo() {
        for (int key : data.keySet()) {
            int yearExpense = 0;
            int yearNotExpense = 0;
            System.out.println("Год " + key);
            ArrayList<? extends Record> ry = YearlyReport.data.get(key);
            int month = 0;
            for (int i = 0; i < ry.size() - 1; i++) {
                int profit = 0;
                int yearExpenseMonth = 0;
                int yearNotExpenseMonth = 0;
                RecordYear yearRep = (RecordYear) ry.get(i);
                RecordYear yearRepNew = (RecordYear) ry.get(i + 1);
                if (yearRep.month == yearRepNew.month) {
                    if (yearRep.isExpense)
                        yearExpenseMonth = yearExpenseMonth + yearRep.amount;
                    else
                        yearNotExpenseMonth = yearNotExpenseMonth + yearRep.amount;
                    if (yearRepNew.isExpense)
                        yearExpenseMonth = yearExpenseMonth + yearRepNew.amount;
                    else
                        yearNotExpenseMonth = yearNotExpenseMonth + yearRepNew.amount;
                    profit = yearNotExpenseMonth - yearExpenseMonth;
                    month = yearRep.month;
                    System.out.println("Месяц " + month);
                    System.out.println("Приыль " + profit);
                    yearExpense = yearExpense + yearExpenseMonth;
                    yearNotExpense = yearNotExpense + yearNotExpenseMonth;

                }

            }
            System.out.println("Доход в среднем за месяц " + yearNotExpense / month);
            System.out.println("Расход в среднем за месяц " + yearExpense / month);
        }
    }
}


