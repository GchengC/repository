package com.farmatodo.notifications.to;

import com.farmatodo.commons.to.ResponseTo;

import java.util.List;

public class NotificationResponseTo extends ResponseTo {
    List<NotificationMiscTo> notifications;
    List<NotificationMiscTo> notiHead;
    List<NotificationTo> notiReports;

    public List<NotificationMiscTo> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<NotificationMiscTo> notifications) {
        this.notifications = notifications;
    }

    public List<NotificationMiscTo> getNotiHead() {
        return notiHead;
    }

    public void setNotiHead(List<NotificationMiscTo> notiHead) {
        this.notiHead = notiHead;
    }

    public List<NotificationTo> getNotiReports() {
        return notiReports;
    }

    public void setNotiReports(List<NotificationTo> notiReports) {
        this.notiReports = notiReports;
    }
}
