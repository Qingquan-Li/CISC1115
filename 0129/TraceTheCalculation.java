public class TraceTheCalculation {
    public static void main(String[] args) {
	int a, b, c, d, e, f, g;
	a = 10;
	b = 27;
	System.out.println( "a is " + a + ", b is " + b );

	c = a + b;
	System.out.println( "a+b is " + c );
	d = a - b;
	System.out.println( "a-b is " + d );
	e = a+b*3;
	System.out.println( "a+b*3 is " + e );
	f = b / 2;
	System.out.println( "b/2 is " + f );
	g = b % 10;
	System.out.println( "b%10 is " + g );
    }
}
