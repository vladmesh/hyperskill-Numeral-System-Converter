package converter;

import java.util.Scanner;

public class Main {
    private static boolean isPoint = false;
    private static double toDecimal(String source, int radix) {
        String intPart;
        String fracPart;
        if (source.contains(".")) {
            isPoint = true;
            String[] tmp = source.split("\\.");
            intPart = tmp[0];
            fracPart = tmp[1];
        } else {
            intPart = source;
            fracPart = "";
        }

        double number;
        if (radix == 1) {
            number = source.length();

        } else {
            number = Long.parseLong(intPart, radix);
        }
        for (int i = 0; i < fracPart.length(); i++) {
            number += Integer.parseInt("" + fracPart.charAt(i), radix) / Math.pow(radix, i + 1);
        }

        return number;
    }

    private static String toRadix(double number, int targetRadix) {
        long intPart = (long) number;
        double fracPart = number - intPart;
        int  round = 5;
        StringBuilder res = new StringBuilder();
        if (targetRadix == 1) {
            for (int i = 0; i < intPart; i++) {
                res.append('1');
            }
        } else {
            res.append(Long.toString(intPart, targetRadix));

            if(isPoint){
                res.append('.');
                if(fracPart == 0){
                    res.append("0");
                }
            }
            while (round > 0 && fracPart > 0) {
                round--;
                fracPart *= targetRadix;
                res.append(Long.toString((int)fracPart, targetRadix));
                fracPart -= (int) fracPart;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sourceRadix = scanner.nextInt();
        String sourceNumber = scanner.next();
        int targetRadix = scanner.nextInt();
        double numberInDec = toDecimal(sourceNumber, sourceRadix);
        //System.out.println(numberInDec);
        System.out.println(toRadix(numberInDec, targetRadix));


    }
}
