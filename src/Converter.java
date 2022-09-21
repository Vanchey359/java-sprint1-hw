public class Converter {

    final int STEP_LENGTH = 75; // длинна шага в сантиметрах
    final int SM_TO_KM = 100000; // если честно я не могу придумать как назвать эту переменную, понимаю что это название ужасно - но ничего другого в голову не пришло
    final int STEP_KAL = 50; // количество калорий за один шаг
    final int KAL_TO_KKAL = 1000; // по аналогии с переменной выше
    public double convertToDistance(double step) {
         return (step * STEP_LENGTH) / SM_TO_KM;
    }

    public double convertKKal(double step) {
        double kkal = (step * STEP_KAL) / KAL_TO_KKAL;
        return kkal;
    }
}
