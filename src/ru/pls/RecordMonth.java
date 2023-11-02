package ru.pls;

public class RecordMonth extends Record {
    String itemName;
    Boolean isExpense;
    int quantity;
    int sumOfOne;

    public RecordMonth(String itemName, Boolean isExpense, int quantity, int sumOfOne) {
        this.itemName = itemName;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.sumOfOne = sumOfOne;
    }
}
