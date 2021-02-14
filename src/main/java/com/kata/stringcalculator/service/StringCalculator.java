package com.kata.stringcalculator.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class StringCalculator {

    public static int count = 0;

    public int Add(String numbers) throws Exception {
        List<String> negativeNumbers = new ArrayList<>();

        String delimiter=",";
        int result=0;

        if(!StringUtils.hasLength(numbers))
            result=0;
        else {
            if (numbers.substring(0, 1).equals("/")) {
                if(String.valueOf(numbers.charAt(2)).equals("["))
{
    numbers=recallMethod(numbers,delimiter);

}
    else {
        delimiter = String.valueOf(numbers.charAt(2));
        numbers = numbers.substring(4);
    }
            }
            else {
                numbers = numbers.replaceAll("\n", delimiter);
            }

                System.out.println(numbers);
                String[] numbersArray = numbers.split(delimiter);
                for (String num : numbersArray) {
                    if(Integer.parseInt(num)>1000)
                        num ="0";
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

    public int GetCalledCount()
    {
        return count;
    }

    private Map<String,Object> delimaters(String inputString) {
        Map<String,Object> resultMap= new HashMap<>();
        System.out.println("inputString"+inputString);
        StringJoiner mystring = new StringJoiner("\\","\\","");
        String delim="";
        int i=0;
        while(!String.valueOf(inputString.charAt(i)).equals("]"))
        {
            //System.out.println(inputString.charAt(i));
            mystring.add(String.valueOf(inputString.charAt(i)));
            i++;
        }
        System.out.println("index i after do the delim"+i);
        System.out.println(mystring.toString());
        resultMap.put("delim",mystring.toString());
        //index + 5 coz two for extra slash and 3 for line brekup
        resultMap.put("index",i+4);
        return resultMap;
    }

    public String recallMethod(String numbers,String delimiter)
    {
        System.out.println("number inside recall"+numbers);

        int indexCheck =2;
        int tempIndex=0;
//while(String.valueOf(numbers.charAt(indexCheck)).equals("[")) {
        System.out.println("inside while char at index check" + numbers.charAt(indexCheck));
        System.out.println("number to send" + numbers.substring(4));
        Map<String, Object> resultmap = delimaters(numbers.substring(indexCheck+1));
        delimiter = (String) resultmap.get("delim");
        System.out.println("delimiters" + delimiter);
        indexCheck = (Integer) resultmap.get("index");
        numbers = numbers.substring(indexCheck);
        numbers = numbers.replaceAll(delimiter, ",");
        System.out.println("numbers String after replace ment" + numbers);
        delimiter = ",";
        indexCheck = 0;
        System.out.println("end of while char i returned" + numbers.charAt(0));
//}
        //numbers=recallFunction(numbers,delimiter);
        if(String.valueOf(numbers.charAt(0)).equals("[")) {
            numbers = "\\\\" + numbers;
            System.out.println("string before break"+numbers);
            numbers=recallMethod(numbers,delimiter);
        }
        else
            numbers=numbers.substring(1);
        return  numbers;
    }

}
