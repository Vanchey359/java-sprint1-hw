import java.util.Scanner;

public class StepTracker {

    private final MonthData[] monthToData;
    private int goalSteps = 10000;

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    private static class MonthData {
       private int[] stepsPerDay = new int[30];
    }

    public void saveSteps(int month, int day, int steps) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (steps >= 0) {
                monthToData[month].stepsPerDay[day - 1] = steps;
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
        while (true) {
            if (goalSteps >= 0) {
                break;
            } else {
                System.out.println("Ввод отрицательного количества шагов запрещен! Введите корректное количество шагов.");
                goalSteps = scanner.nextInt();
            }
        }
    }

    public void printStatistics(int month) {
        Converter converter = new Converter();
        int allStepsPerMonth = 0;
        int maxStepsPerDay = 0;
        int averageStepsPerMonth = 0;
        int streakCounter = 0;
        int streak = 0;
        for (int i = 0; i < 30; i++) {
            System.out.print((i + 1) + " " + "День: " + monthToData[month].stepsPerDay[i] + ". ");
            allStepsPerMonth = allStepsPerMonth + monthToData[month].stepsPerDay[i];
            if (monthToData[month].stepsPerDay[i] > maxStepsPerDay) {
                maxStepsPerDay = monthToData[month].stepsPerDay[i];
            }
            if (monthToData[month].stepsPerDay[i] >= goalSteps) {
                streakCounter++;
                if (streakCounter > streak) {
                    streak = streakCounter;
                }
            } else {
                streakCounter = 0;
            }
        }
        averageStepsPerMonth = allStepsPerMonth / 30;
        System.out.println();
        System.out.println("Общее количество шагов за месяц: " + allStepsPerMonth);
        System.out.println("Максимальное пройденное количество шагов в месяце: " + maxStepsPerDay);
        System.out.println("Среднее количество шагов в месяце: " + averageStepsPerMonth);
        System.out.println("Пройденная дистанция в км: " + converter.convertToDistance(allStepsPerMonth));
        System.out.println("Количество сожжённых килокалорий: " + converter.convertKKal(allStepsPerMonth));
        System.out.println("Лучшая серия: " + streak);
    }
}