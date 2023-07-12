package org.example;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {

    //Definition of Add Method accepting numbers as String
    /**
     *
     * @param numbers text with the integers to be added, separated by the delimiter
     * @return Zero (0) if array is empty, else return sum of array of values
     */
    public static int Add(String numbers) {
        //Checking numbers is not empty
        if( !numbers.isEmpty()) {
            //Splitting the delimiters and converting string into List of Integers
            List<Integer> nums = stringArrayToIntegerList(getSplit(numbers));

            negatives(nums);
            nonInteger(nums);

            //returns the Sum of the number(s) string as Integer
            return nums.stream().reduce(Integer::sum).orElseThrow();
        }
        return 0;
    }

    //Checking the range of the Integer, If range exits the limit it will throw the error

    /**
     *
     * @param nums
     * throw nonInteger runtime exception
     */
    private static void nonInteger(List<Integer> nums) {
        StringBuilder SB = new StringBuilder();
        nums.stream().filter(num->num>2147483646).forEach(num->SB.append(num).append(" "));
        if (!SB.toString().isEmpty()) {
            throw new RuntimeException("Integer values more than 2147483646 are not allowed");
        }
    }

    //Checking for the negative values in the array, If negative values present in the string array it will throw the error
    /**
     *
     * @param nums List
     * throws error if negatives present in array
     */

    private static void negatives(List<Integer> nums) {
        StringBuilder SB = new StringBuilder();
        nums.stream().filter(num->num<0).forEach(num->SB.append(num).append(" "));
        if (!SB.toString().isEmpty()) {
            throw new RuntimeException("Negatives not allowed");
        }
    }

    //Refactoring as function of converting StringArrayToIntegerList and returns the numbers as an Array of Integers
    @NotNull
    private static List<Integer> stringArrayToIntegerList(String[] numbers) {
        return Arrays.stream(numbers).map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    //Refactoring as function of splitting the delimiters from the String Input and returns only the numbers from the string
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
        return numbers.split("[\n,]");
    }
}
//End of Class