import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int month;
        int day;
        int steps;
        final int END_OF_THE_PROGRAM = 0;
        final int SAVE_STEP_PER_DAY = 1;
        final int PRINT_STATISTICS = 2;
        final int CHANGE_GOAL = 3;
        StepTracker stepTracker = new StepTracker();
        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != END_OF_THE_PROGRAM) {
            if (userInput == SAVE_STEP_PER_DAY) {     // Ввод шагов за определенный день
                System.out.println("Укажите номер месяца, где 0 - январь, 1 - февраль...");
                month = scanner.nextInt();
                System.out.println("Укажите день за который хотите ввести шаги. Вводимое число должно соответствовать календарному."); // при учете что в месяце строго 30 дней
                day = scanner.nextInt();
                System.out.println("Введите количество пройденых шагов :)");
                steps = scanner.nextInt();
                stepTracker.saveSteps(month, day, steps);
            } else if (userInput == PRINT_STATISTICS) { //Печать статистики по шагам за определенный месяц
                System.out.println("За какой месяц вы хотите открыть статистику?");
                month = scanner.nextInt();
                stepTracker.printStatistics(month);
            } else if (userInput == CHANGE_GOAL) { //Меняем цель по количеству шагов в день
                System.out.println("Ведите новую цель по количеству шагов в день!");
                stepTracker.changeGoal();
                System.out.println("Цель по количеству шагов в день изменена!");
            } else {  // Пользователь ввел что то от себя :)
                System.out.println("Неверная команда! Введите команду из списка доступных.");
            }

            printMenu();
            userInput = scanner.nextInt();
        }
    }

    private static void printMenu() {
        System.out.println("1. Ввести количество шагов за определенный день");
        System.out.println("2. Напечатать статистику за определенный месяц");
        System.out.println("3. Изменить цель по количеству шагов в день");
        System.out.println("0. Выйти из приложения");
    }

}
