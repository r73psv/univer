package ru.pls;

import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReport {
    static HashMap<Integer, ArrayList<? extends Record>> data = new HashMap<>();

    public MonthlyReport() {
        for (int i = 1; i <= 12; i++) {
            data.put(i, new ArrayList<>());

        }
    }

    public static HashMap<Integer, ArrayList<? extends Record>> getData() {
        return data;
    }

    //подсчет трат за месяц
    public static int sumAmountYearExpense() {
        int sumYearExpense = 0;

        for (int i = 1; i <= data.size(); i++) {
            sumYearExpense = sumYearExpense + sumAmountMonthExpense(data.get(i));
        }
        System.out.println("Сумма трат за год:" + sumYearExpense);
        return sumYearExpense;
    }

    //подсчет дохода за год
    public static int sumAmountYearNotExpense() {
        int sumYearNotExpense = 0;

        for (int i = 1; i <= data.size(); i++) {
            ArrayList<? extends Record> newrep = data.get(i);
            System.out.println(newrep.size());
            sumYearNotExpense = sumYearNotExpense + sumAmountMonthNotExpense(newrep);
        }
        System.out.println("Сумма приыли за год:" + sumYearNotExpense);
        return sumYearNotExpense;
    }

    //подсчет трат за месяц
    public static int sumAmountMonthExpense(ArrayList<? extends Record> newrep) {
        int sumExp = 0;
        System.out.println(newrep.size());
        for (int i = 0; i < newrep.size(); i++) {
            RecordMonth mr = (RecordMonth) newrep.get(i);
            System.out.println(mr.quantity);
            if (mr.isExpense) {
                sumExp = sumExp + mr.quantity;
            }
        }
        System.out.println(sumExp + "SE");
        return sumExp;
    }

    //подсчет дохода за месяц
    public static int sumAmountMonthNotExpense(ArrayList<? extends Record> newrep) {
        int sumNotExp = 0;
        for (int i = 0; i < newrep.size(); i++) {
            RecordMonth mr = (RecordMonth) newrep.get(i);
            if (!mr.isExpense) {
                sumNotExp = sumNotExp + mr.quantity;
            }
        }
        return sumNotExp;
    }

    //
    public static void equalsExpenses() {
        ArrayList<? extends Record> ry = YearlyReport.data.get(2023);
        RecordYear yearRep = (RecordYear) ry.get(0);
        if (sumAmountYearExpense() == yearRep.amount)
            System.out.println("Сумма трат в годовом отчете равна сумме трат в месячных отчетах");
        else System.out.println("Сумма трат в годовом отчете не равна сумме трат в месячных отчетах");
    }

    public void addMonthRecord(Integer month, ArrayList<RecordMonth> monthRecordMonth) {
        data.put(month, monthRecordMonth);
    }
}

