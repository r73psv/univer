package ru.pls;

public class Record {
   String itemName;
   Boolean isExpense;
   int quantity;
   int sumOfOne;

    public Record(String itemName, Boolean isExpense, int quantity, int sumOfOne) {
        this.itemName = itemName;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.sumOfOne = sumOfOne;
    }
}
