public class CalculationWithJavaMathMethods {
    public static void main(String[] args) {
        double x, y, z, result;
        x = 4.0;
        y = 5.0;
        z = 6.0;

        result = (Math.pow(x, 2) - (1 / (y + 3))) / ((1 / z) + Math.sqrt(x));
        System.out.println(result);
    }
}
