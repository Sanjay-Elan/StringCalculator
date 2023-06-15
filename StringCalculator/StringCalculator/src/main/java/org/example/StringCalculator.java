package org.example;

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {

    public static int Add(String numbers) {
        if( !numbers.isEmpty()) {
            List<Integer> nums = stringArraytoIntegerList(getSplit(numbers));

            return nums.stream().reduce(Integer::sum).orElseThrow();
        }
        return 0;
    }

    @NotNull
    private static List<Integer> stringArraytoIntegerList(String[] numbers) {
        return Arrays.stream(numbers).map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    @NotNull
    private static String[] getSplit(String numbers) {
        if(numbers.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(numbers);
            if (matcher.matches()) {
                String delimiter = matcher.group(1);
                String toSplit = matcher.group(2);
                return toSplit.split(delimiter);
            }

            throw new RuntimeException("Not a Custom Delimiter format");
        }
        return numbers.split("\n|,");
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
