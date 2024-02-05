public class learnString {
    public static void main(String[] args) {
        String s = "Hello";
        System.out.println(1 + 2 + s); // 3Hello
        System.out.print(s + 1 + 2); // Hello12

        System.out.println();
        System.out.println("Type of s: " + s.getClass().getName()); // java.lang.String
        System.out.println("Type of 1 + 2 + s: " + (1 + 2 + s).getClass().getName()); // java.lang.String
        System.out.println("Type of s + 1 + 2: " + (s + 1 + 2).getClass().getName()); // java.lang.String
        // Notes: Primitive types are not objects, so they don't have methods.
        // However, Java provides a wrapper class for each primitive type.
        Double d = 1.0;
        System.out.println("Type of d: " + d.getClass().getName()); // java.lang.Double
    }
}
