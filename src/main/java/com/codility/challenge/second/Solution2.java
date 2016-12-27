package com.codility.challenge.second;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Solution2 {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public String solution(String S) {
        return "";
    }

    public LocalDateTime parseDate(String string) {
        return LocalDateTime.parse(string, formatter);
    }
}
