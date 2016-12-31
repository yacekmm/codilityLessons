package com.hackerrank.algorithm;

public class Encryption {

    public static String encrypt(String input){
        StringBuilder sb = new StringBuilder();
        char[] inputArray = input.toCharArray();
        int cols = (int)Math.ceil(Math.sqrt(input.length()));

        int offset = 0;
        while(offset < cols){
            for (int i = offset; i < input.length(); i += cols) {
                sb.append(inputArray[i]);
            }
            offset++;
            sb.append(" ");
        }

        return sb.toString().trim();
    }
}
