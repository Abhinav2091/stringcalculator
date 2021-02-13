package com.kata.stringcalculator.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class StringCalculator {

    public int Add(String numbers)
    {
        int result=0;
        if(!StringUtils.hasLength(numbers))
            result=0;
        else{
            if(numbers.contains("\\n"))
                numbers=numbers.replaceAll("\\n",",");
            String[] numbersArray= numbers.split(",");
            for(String num:numbersArray)
            {
                result=result+Integer.parseInt(num);
            }
        }
        return result;
    }
}
