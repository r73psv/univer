package ru.psv.tracker;

public class MonthDate {
    int [] monthData;

       public int getMonthData(int i) {
        return monthData[i];
    }
public int size(){
       return monthData.length;
    }
   public  void addSteps (int month,int day, int steps){
      if (monthData==null) {
          if (month == 2) {
              monthData = new int[29];
          } else if (month == 4 || month == 6 || month == 9 || month == 11) {
              monthData = new int[30];
          } else {
              monthData = new int[31];
          }
          monthData[(day-1)] =steps;
      } else
      monthData[(day-1)] =steps;
        }
    }

