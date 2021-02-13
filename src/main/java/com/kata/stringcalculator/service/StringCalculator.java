package com.kata.stringcalculator.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.List;
import java.util.ArrayList;

@Service
public class StringCalculator {

    public int Add(String numbers) throws Exception {
        List<String> negativeNumbers = new ArrayList<>();
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
                    if(Integer.parseInt(num)<0)
                    {
                        negativeNumbers.add(num);
                    }
                    result = result + Integer.parseInt(num);
                }

        }
        if(!negativeNumbers.isEmpty())
            throw new Exception("negatives not allowed -"+negativeNumbers);
        else
        return result;
    }
}
