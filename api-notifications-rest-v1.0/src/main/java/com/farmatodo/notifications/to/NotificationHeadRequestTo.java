package com.farmatodo.notifications.to;

import com.farmatodo.commons.to.RequestTo;

public class NotificationHeadRequestTo extends RequestTo {
    NotificationHeadTo notiHead;

    public NotificationHeadTo getNotiHead() {
        return notiHead;
    }

    public void setNotiHead(NotificationHeadTo notiHead) {
        this.notiHead = notiHead;
    }
}
