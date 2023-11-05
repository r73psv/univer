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
        ArrayList<? extends Record> ry = YearlyReport.data.get(2023);
        for (int i = 0; i < ry.size(); i++) {
            RecordYear yearRep = (RecordYear) ry.get(i);
            System.out.println(yearRep.month + " " + yearRep.amount + " " + yearRep.isExpense);

            int month = yearRep.month;
            ArrayList<? extends Record> newrep = MonthlyReport.data.get(month);
            RecordMonth rm = (RecordMonth) newrep.get(month);

            int mr = MonthlyReport.sumAmountMonthNotExpense(newrep);
            int mr2 = MonthlyReport.sumAmountMonthExpense(newrep);
            System.out.println(mr);
            System.out.println(mr2);

            if (!yearRep.isExpense) {
                if (yearRep.amount != MonthlyReport.sumAmountMonthNotExpense(newrep)) {
                    System.out.println("Доходы " + yearRep.amount + "  " + MonthlyReport.sumAmountMonthNotExpense(newrep));
                    System.out.println("Суммы доходов по годовому и месячному отчетам за " + yearRep.month + " месяц не совпадают");
                }
            } else {
                if (yearRep.amount != MonthlyReport.sumAmountMonthExpense(MonthlyReport.data.get(month))) {
                    System.out.println("Расходы " + yearRep.amount + "  " + MonthlyReport.sumAmountMonthNotExpense(newrep));
                    System.out.println("Суммы расходов по годовому и месячному отчетам за " + yearRep.month + " месяц не совпадают");
                }
            }
        }
    }
}

