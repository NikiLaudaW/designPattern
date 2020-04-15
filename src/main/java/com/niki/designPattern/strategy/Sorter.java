package com.niki.designPattern.strategy;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * @author niki-lauda
 * @create 2020-03-10 22:46
 */
public class Sorter {
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[i] >= arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
//        List<String> data = new ArrayList<>(20);
//        System.out.println(data.isEmpty());
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.setTimeZone(TimeZone.getDefault());
        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
//        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        for(int i =0; i < 8; i++) {
            cal.add(Calendar.DATE, 1);
            System.out.println(cal.getTime() + "----" + cal.get(Calendar.DAY_OF_WEEK));
        }
    }
}
