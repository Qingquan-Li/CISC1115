public class printFormat {
    public static void main(String [] args){
        int w, x;
        double y;
        
        w = 4;
        x = Math.abs(w - 5);
        y = Math.sqrt(x);
        
        System.out.printf("%d %d %f\n", w,x,y);
    }
}