package cn.chenhaonee.movies.service;

import java.time.LocalDate;

/**
 * Created by chenhaonee on 2017/6/12.
 */
public class DateCode {

    public static String toMyDate(String date) {
        String todayInString = date.substring(0, 6);
        todayInString = todayInString.replace("月", "-");
        todayInString = todayInString.replace("日", "");
        LocalDate today = LocalDate.now();
        return today.getYear() + "-" + todayInString;
    }
}
