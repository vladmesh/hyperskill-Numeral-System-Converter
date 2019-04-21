package converter;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sourceRadix = scanner.nextInt();
        String sourceNumber = scanner.next();
        int targetRadix = scanner.nextInt();
        long number = 0;
        if (sourceRadix == 1) {
            number = sourceNumber.length();

        } else {
            number = Long.parseLong(sourceNumber, sourceRadix);
        }
        if (targetRadix == 1) {
            for (int i = 0; i < number; i++) {
                System.out.print("1");
            }
        } else {
            System.out.println(Long.toString(number, targetRadix));
        }
    }
}
