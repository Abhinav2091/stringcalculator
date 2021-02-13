package com.kata.stringcalculator.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class StringCalculator {

    public int Add(String numbers)
    {
        String delimiter=",";
        int result=0;
        if(!StringUtils.hasLength(numbers))
            result=0;
        else {
            if (numbers.substring(0, 1).equals("/")) {
                delimiter=String.valueOf(numbers.charAt(2));
                numbers=numbers.substring(4);
            }
            else {
                numbers = numbers.replaceAll("\n", delimiter);
            }

                System.out.println(numbers);
                String[] numbersArray = numbers.split(delimiter);
                for (String num : numbersArray) {
                    result = result + Integer.parseInt(num);
                }

        }
        return result;
    }
}
