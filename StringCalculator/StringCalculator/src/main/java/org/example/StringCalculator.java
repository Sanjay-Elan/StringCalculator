package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
    public static int Add(String numbers) {
        if( !numbers.isEmpty()) {
            List<Integer> nums = Arrays.stream(numbers.split(",")).map(Integer::parseInt).collect(Collectors.toList());
            return nums.stream().reduce(Integer::sum).orElseThrow();
        }
        return 0;
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
