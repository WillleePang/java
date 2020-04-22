package com.willlee.leetcode;

public class Leetcode1185 {

    public String dayOfTheWeek(int day, int month, int year) {
        int sum = 4;
        if (year != 1971) {
            for (int i = 1971; i < year; i++) {
                sum += Tianshu(i);
            }
        }

        String[] arr = new String[7];
        arr[0] = "Sunday";
        arr[1] = "Monday";
        arr[2] = "Tuesday";
        arr[3] = "Wednesday";
        arr[4] = "Thursday";
        arr[5] = "Friday";
        arr[6] = "Saturday";
        int[] brr = new int[12];
        brr[0] = 31;
        brr[2] = 31;
        brr[3] = 30;
        brr[4] = 31;
        brr[5] = 30;
        brr[6] = 31;
        brr[7] = 31;
        brr[8] = 30;
        brr[9] = 31;
        brr[10] = 30;
        brr[11] = 31;

        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            brr[1] = 29;
            if (month == 1) {
                return arr[(day + sum) % 7];
            }
            for (int i = 0; i < month - 1; i++) {
                sum += brr[i];
            }
            sum += day;
            return arr[sum % 7];
        } else {
            brr[1] = 28;
            if (month == 1) {
                return arr[(day + sum) % 7];
            }
            for (int i = 0; i < month - 1; i++) {
                sum += brr[i];
            }
            sum += day;
            return arr[sum % 7];
        }

    }

    public int Tianshu(int a) {
        if (a % 4 == 0 && a % 100 != 0 || a % 400 == 0) {
            return 366;
        }
        return 365;
    }

    public String dayOfTheWeek1(int day, int month, int year) {
        if (month == 1 || month == 2) {
            month += 12;
            year--;
        }
        int iWeek = (day + 2 * month + 3 * (month + 1) / 5 + year + year / 4 - year / 100 + year / 400) % 7; // 基姆拉尔森计算公式
        String result[] = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
        return result[iWeek];

    }
}
