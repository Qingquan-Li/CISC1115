public class circleAreaAndCircumference {
    public static void main(String[] args) {
        double radius = 3;
        double area;
        double circumference;
        
        // area = Math.PI * radius * radius;
        area = Math.PI * Math.pow(radius, 2);
        circumference = 2 * Math.PI * radius; 

        System.out.println("Area: " + area);
        System.out.println("Circumference: " + circumference);
        // Area: 28.274333882308138
        // Circumference: 18.84955592153876

        // Limit each result to a precision of 3 decimal places
        // %[flags][width][.precision]conversion-character
        System.out.printf("%.3f%n", area);
        System.out.printf("%.3f%n", circumference);
    }
}
