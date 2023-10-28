package ru.psv.tracker;

import java.util.HashMap;

public class StepTracker {
    private int purposeSteps=10000;
    HashMap<Integer,MonthDate> monthToDate = new HashMap<>();

    public StepTracker () {
    for (int i=1; i<=12;i++){
        monthToDate.put(i,new MonthDate());
    }
}
    public void setPurposeSteps(int purpSteps) {
        purposeSteps = purpSteps;
    }


    public void saveStepsOfDay(int mounth,int dey, int steps) {

     MonthDate mounthDate = monthToDate.get(mounth);
        mounthDate.addSteps(mounth,dey,steps);
        monthToDate.put(mounth,mounthDate);
    }

    public void printStepsToDay(int mounth){
        MonthDate mounthDate = monthToDate.get(mounth);
        if (mounthDate!= null) {
            int sum=0;
            int max=0;
            int count=0;
            int countMax=0;
            for (int i = 0; i < mounthDate.size(); i++) {
                System.out.print("День: " + (i + 1) + " " + mounthDate.getMonthData(i) + ", ");
                sum=sum+mounthDate.getMonthData(i);
                if (mounthDate.getMonthData(i)> max){
                    max=mounthDate.getMonthData(i);
                }
            if (mounthDate.getMonthData(i)>purposeSteps){
                count++;
            } else {
                if(countMax<count){
                    countMax=count;
                    count=0;
                }
            }
            }

            System.out.println();
            System.out.println("Количество шагов за месяц " + sum);
            System.out.println("Пройдено километров за месяц " + Converter.convertToDistance(sum));
            System.out.println("Сожжено калорий за месяц " + Converter.convertToCalories(sum));
            System.out.println("Максимальное количество шагов за день " + max+" что равно " + Converter.convertToDistance(max));
            System.out.println("Cреднее количество шагов за день " + sum/mounthDate.size() +
                    " что равно " + Converter.convertToDistance(sum/mounthDate.size()));
            System.out.println("Наибольшее количество дней подряд когда достигнута цель " + countMax);
            System.out.println("Цель "+purposeSteps);
        } else  System.out.println("В выбранном месяце не было активности");

    }

}
