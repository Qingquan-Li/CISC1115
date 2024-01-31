public class mathAbsAndSqrt {
    public static void main(String [] args) {
        int w, x;
        double y;
        
        w = 4;
        x = Math.abs(w - 5);
        y = Math.sqrt(x);
        
        System.out.println(y); // 1.0

        // printf(String format, datatype args)
        // %d is for decimal integers, %f is for floating-point numbers
        System.out.printf("%d %d %f\n", w,x,y); // 4 1 1.000000
    }
}
