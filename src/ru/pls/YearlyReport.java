package ru.pls;

import java.util.ArrayList;
import java.util.HashMap;

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
        } else if (data.isEmpty() && MonthlyReport.data.isEmpty()) {
            System.out.println("Не получены данные годового и  месячных отчетов");

        } else if (data.isEmpty()) {
            System.out.println("не получены данные годового отчета");

        } else {
            System.out.println("Не получены данные месячных отчетов");

        }
    }

}



