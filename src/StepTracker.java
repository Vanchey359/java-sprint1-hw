import java.util.Scanner;

public class StepTracker {

    MonthData[] monthToData;
    int goalSteps = 10000;

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    class MonthData {
       private int[] stepsPerDay = new int[31];

        public int[] getStepsPerDay() {
            return stepsPerDay;
        }

        public void setStepsPerDay(int[] stepsPerDay) {
            this.stepsPerDay = stepsPerDay;
        }
    }

    public void enterSteps(int month, int day, int steps) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            if (steps >= 0) {
                monthToData[month].stepsPerDay[day] = steps;
                System.out.println("Изменения внесены.");
                break;
            } else {
                System.out.println("Ввод отрицательного количества шагов запрещен! Введите корректное количество шагов.");
                steps = scanner.nextInt();
            }
        }
    }
    public void changeGoal()  {
        Scanner scanner = new Scanner(System.in);
        goalSteps = scanner.nextInt();
        while(true) {
            if(goalSteps >= 0) {
                break;
            } else {
                System.out.println("Ввод отрицательного количества шагов запрещен! Введите корректное количество шагов.");
                goalSteps = scanner.nextInt();
            }
        }
    }
    public void printStat(int month) {
        Converter converter = new Converter();
        int all = 0;
        int max = 0;
        int mid = 0;
        int count = 0;
        int strik = 0;
        for(int i = 1; i < 31; i++) {
            System.out.print(i + " " + "День: " + monthToData[month].stepsPerDay[i] + ". ");
            all = all + monthToData[month].stepsPerDay[i];
            if(monthToData[month].stepsPerDay[i] > max) {
                max = monthToData[month].stepsPerDay[i];
            }
            if(monthToData[month].stepsPerDay[i] >= goalSteps) {
                count++;
                if(count > strik) {
                    strik = count;
                }
            } else {
                count = 0;
            }
        }
        mid = all / 30;
        System.out.println(); // Перенос на строку ниже, для красоты.
        System.out.println("Общее количество шагов за месяц: " + all);
        System.out.println("Максимальное пройденное количество шагов в месяце: " + max);
        System.out.println("Среднее количество шагов в месяце: " + mid);
        System.out.println("Пройденная дистанция в км: " + converter.convertDistance(all));
        System.out.println("Количество сожжённых килокалорий: " + converter.convertKKal(all));
        System.out.println("Лучшая серия: " + strik);
    }
}