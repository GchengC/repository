package com.farmatodo.notifications.to;

public class NotificationSchedTo {
    String frequency;
    String notificationTime;
    int notificationDay;
    String repeatInd;
    int notificationId;
    int notischedId;

    public int getNotischedId() {
        return notischedId;
    }

    public void setNotischedId(int notischedId) {
        this.notischedId = notischedId;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getNotificationTime() {
        return notificationTime;
    }

    public void setNotificationTime(String notificationTime) {
        this.notificationTime = notificationTime;
    }

    public int getNotificationDay() {
        return notificationDay;
    }

    public void setNotificationDay(int notificationDay) {
        this.notificationDay = notificationDay;
    }

    public String getRepeatInd() {
        return repeatInd;
    }

    public void setRepeatInd(String repeatInd) {
        this.repeatInd = repeatInd;
    }

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }
}
