package ru.pls;

import java.math.BigDecimal;

public class Record {
    String itemName;
    Boolean isExpense;
    Integer quantity;
    BigDecimal sumOfOne;

    public Record(String itemName, Boolean isExpense, Integer quantity, BigDecimal sumOfOne) {
        this.itemName = itemName;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.sumOfOne = sumOfOne;
    }
}
