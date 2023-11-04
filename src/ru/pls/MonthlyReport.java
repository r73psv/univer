package ru.pls;

import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReport {
    HashMap<Integer, ArrayList<? extends Record>> data = new HashMap<>();

    public MonthlyReport() {
        for (int i = 1; i <= 12; i++) {
            data.put(i, new ArrayList<>());
        }
    }

    public void addMonthRecord(Integer month, ArrayList<? extends Record> monthRecordMonth) {
        data.put(month, monthRecordMonth);
    }

    public int sumAmountYearExpense() {
        int sumYearExpense = 0;
        for (int i = 0; i < data.size(); i++) {
            ArrayList<? extends Record> newrep = data.get(i);
            sumYearExpense = sumYearExpense + sumAmountMonthExpense(newrep);
        }
        return sumYearExpense;
    }

    public int sumAmountMonthExpense(ArrayList<? extends Record> newrep) {
        int sumExp = 0;
        int sumNotExp = 0;
        for (Record rep : newrep) {
            RecordMonth mr = (RecordMonth) rep;
            if (mr.isExpense) {
                sumExp = sumExp + mr.sumOfOne;
            }
        }
        return sumExp;
    }
}

