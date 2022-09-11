package com.miliky.entry;

/**
 * @Author: Miliky
 * @Date: 2022/9/7 16:40
 * @Description: [爱意随风起，风止意难平。]
 */
public class Limited {

    String limitedTime;

    String limitedNumber;

    String limitedWeek;

    public Limited(String limitedTime, String limitedNumber, String limitedWeek) {
        this.limitedTime = limitedTime;
        this.limitedNumber = limitedNumber;
        this.limitedWeek = limitedWeek;
    }

    public String getLimitedTime() {
        return limitedTime;
    }

    public void setLimitedTime(String limitedTime) {
        this.limitedTime = limitedTime;
    }

    public String getLimitedNumber() {
        return limitedNumber;
    }

    public void setLimitedNumber(String limitedNumber) {
        this.limitedNumber = limitedNumber;
    }

    public String getLimitedWeek() {
        return limitedWeek;
    }

    public void setLimitedWeek(String limitedWeek) {
        this.limitedWeek = limitedWeek;
    }

    @Override
    public String toString() {
        return limitedTime + " " + limitedWeek + " 限行：" + limitedNumber + "\n";
    }
}
