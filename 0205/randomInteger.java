public class randomInteger {
    public static void main(String[] args) {
        // Print random integer from 1 - 10 (inclusive)

        double random = Math.random();
        // int randomInt = (int) (random * 10);
        // Math.random() * (max - min) + min;
        int randomInt = (int) (random * 10 + 1);
        System.out.println(random); // 0.8243550954214788
        System.out.println(randomInt); // 9

    }
}
