package com.sonic.gof23.prototype;

/**
 * Client
 *
 * @author Sonic
 * @since 2019/3/24
 */
public class Client {
    public static void main(String[] args) {
        WeeklyLog weeklyLog = new WeeklyLog();
        Attachment attachment = new Attachment();
        weeklyLog.setAttachment(attachment);

        WeeklyLog weeklyLogClone1 = weeklyLog.clone();
        WeeklyLog weeklyLogClone2 = weeklyLog.deepClone();
        WeeklyLog weeklyLogClone3 = weeklyLog.deepCloneMultiFields();

        System.out.println(weeklyLog.getAttachment() == weeklyLogClone1.getAttachment());
        System.out.println(weeklyLog.getAttachment() == weeklyLogClone2.getAttachment());
        System.out.println(weeklyLog.getAttachment() == weeklyLogClone3.getAttachment());

    }
}
