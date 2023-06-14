package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class StringCalculator {
    public static int Add(String numbers) {
        if( !numbers.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(numbers);
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a valid number string separated by comma(,)");
        String value = br.readLine();
        int result = Add(value);
        System.out.println("Total Sum = "+result);
    }

}
