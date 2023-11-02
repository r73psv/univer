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
}
