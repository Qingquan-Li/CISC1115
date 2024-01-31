public class printFormat {
    public static void main(String[] args) {
        double a = 4.0;
        int b;
        b = 3;
        double c = a / b; //interger division
        System.out.println(c); // 1.3333333333333333

        // %[flags][width][.precision]conversion-character
        // % means start of the format specifier
        // 22 means 22 spaces to the right
        // .1 means 1 decimal place
        // f means floating-point number
        // %n is a platform-independent newline character
        // while \n is a newline character specific to Unix-based systems
        System.out.printf("%22.1f\n", c);
        System.out.printf("%22.2f\n", 1.0);
        System.out.printf("%22.4f\n", 2.59);
    }   
}
