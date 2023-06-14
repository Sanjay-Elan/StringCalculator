package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringCalculator {
    public static int Add(String numbers) {
        if( !numbers.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(numbers);
    }

    public static void main(String args[]) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a valid number string separated by comma(,)");
        String value = null;
        try {
            value = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int result = Add(value);
        System.out.println("Total Sum = "+result);
    }

}
