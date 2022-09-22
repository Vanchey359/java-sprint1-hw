public class Converter {

    private static final int STEP_LENGTH = 75;
    private static final int CENTIMETERS_PER_KILOMETER = 100000;
    private static final int CALL_TO_STEP = 50;
    private static final int CAL_TO_KCAL = 1000;

    public double convertToDistance(double steps) {
         return (steps * STEP_LENGTH) / CENTIMETERS_PER_KILOMETER;
    }

    public double convertToKcal(double steps) {
         return (steps * CALL_TO_STEP) / CAL_TO_KCAL;
    }
}
