package com.farmatodo.notifications.to;

import com.farmatodo.commons.to.RequestTo;

public class NotificationRequestTo extends RequestTo {
    NotificationTo notiData;

    public NotificationTo getNotiData() {
        return notiData;
    }

    public void setNotiData(NotificationTo notiData) {
        this.notiData = notiData;
    }
}
