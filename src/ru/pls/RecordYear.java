package ru.pls;

public class RecordYear extends Record {
   Integer month;
    Integer amount;
    Boolean isExpense;

    public RecordYear(Integer month, Integer amount, Boolean isExpense) {
        this.month = month;
        this.amount = amount;
        this.isExpense = isExpense;
    }
}
