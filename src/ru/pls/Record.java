package ru.pls;

public class Record {
   String itemName;
   Boolean isExpense;
   Integer quantity;
   Integer sumOfOne;

    public Record(String itemName, Boolean isExpense, Integer quantity, Integer sumOfOne) {
        this.itemName = itemName;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.sumOfOne = sumOfOne;
    }
}
