package org.ImportJARFileTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.example.StringCalculator.Add;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a valid number string separated by comma(,)");
        String value = br.readLine();
        int result = Add(value);
        System.out.println("Total Sum = "+result);
    }
}