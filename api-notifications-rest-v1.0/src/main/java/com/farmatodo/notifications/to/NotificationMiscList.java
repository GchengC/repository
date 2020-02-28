package com.farmatodo.notifications.to;

import java.util.List;

public class NotificationMiscList {
    List<NotificationMiscTo> notiHead;
    List<NotificationMiscTo> notifications;

    public List<NotificationMiscTo> getNotiHead() {
        return notiHead;
    }

    public void setNotiHead(List<NotificationMiscTo> notiHead) {
        this.notiHead = notiHead;
    }

    public List<NotificationMiscTo> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<NotificationMiscTo> notifications) {
        this.notifications = notifications;
    }
}
