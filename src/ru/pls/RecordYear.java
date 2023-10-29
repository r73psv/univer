package ru.pls;

import java.math.BigDecimal;

public class RecordYear {
   Integer month;
   BigDecimal amount;
   Boolean isExpense;

   public RecordYear(Integer month, BigDecimal amount, Boolean isExpense) {
      this.month = month;
      this.amount = amount;
      this.isExpense = isExpense;
   }
}
