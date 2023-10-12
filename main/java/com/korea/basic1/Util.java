package com.korea.basic1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Util {
    public static String getCurrent() {

        // 현재 날짜 구하기
        LocalDateTime now = LocalDateTime.now();
        // 포맷 정의
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
        // 포맷 적용
        String formatedNow = now.format(formatter);

        return formatedNow;


    }
}
