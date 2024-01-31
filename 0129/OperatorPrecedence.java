public class OperatorPrecedence {
    public static void main(String[] args) {
        int a = 2 + 3 * 4 - 1;
	int b = 10;
	b += 2 * 3 - 1;
        System.out.println("5 + 4 * 2 = " + (5 + 4 * 2));
	System.out.println("2 + 3 * 4 - 5 = " + (2 + 3 * 4 - 5));
	System.out.println("10 / 2 + 3 * 5 - 4 = " + (10 / 2 + 3 * 5 - 4));
	System.out.println("int a = 2 + 3 * 4 - 1;");
	System.out.println("Result: " + a);
	System.out.println("int b = 10; -> b += 2 * 3 - 1, then b is");
	System.out.println(b);
    }
}
