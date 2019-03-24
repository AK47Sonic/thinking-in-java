package com.sonic.gof23.prototype;

import java.io.*;

/**
 * WeeklyLog
 *
 * @author Sonic
 * @since 2019/3/24
 */
public class WeeklyLog implements Cloneable, Serializable {

    private Attachment attachment;
    private String content;

    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    //浅克隆
    @Override
    public WeeklyLog clone() {
        WeeklyLog wl = null;
        try {
            wl = (WeeklyLog) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        return wl;
    }

    //深克隆
    public WeeklyLog deepClone() {
        WeeklyLog wl = null;
        try {
            wl = (WeeklyLog) super.clone();
            wl.attachment = this.attachment.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        return wl;
    }

    //深克隆
    public WeeklyLog deepCloneMultiFields() {
        WeeklyLog obj = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(this);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);

            obj = (WeeklyLog) objectInputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e);
        }
        return obj;
    }
}
