package ru.pls;

import java.util.ArrayList;
import java.util.HashMap;

public class YearlyReport {
    HashMap<Integer, ArrayList<? extends Record>> data = new HashMap<>();

    public YearlyReport() {
        data.put(2023, new ArrayList<>());
    }

    public void addYearRecord(Integer year, ArrayList<? extends Record> yearRecords) {
        data.put(year, yearRecords);
    }
}
