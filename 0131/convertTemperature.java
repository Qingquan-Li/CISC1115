public class convertTemperature {
    public static void main(String[] args) {
        // Celsius = (Fahrenheit - 32) * (5 / 9)
        double fahrenheit, celsius;
        fahrenheit = 50;
        
        // celsius = (fahrenheit - 32) * (5 / 9);
        celsius = (fahrenheit - 32) * (double) 5 / 9;
        System.out.println(celsius);
    }
}
