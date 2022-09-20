public class Converter {
    public double convertDistance(double step) {
        double distance = (step * 75) / 100000;
        return distance;
    }
    public double convertKKal(double step) {
        double kkal = (step * 50) / 1000;
        return kkal;
    }
}
