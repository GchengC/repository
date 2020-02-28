package com.farmatodo.notifications.to;

import com.farmatodo.commons.to.ResponseTo;

import java.util.List;

public class NotificationHeadResponse extends ResponseTo {
    List<NotificationHeadTo> notiHeadData;

    public List<NotificationHeadTo> getNotiHeadData() {
        return notiHeadData;
    }

    public void setNotiHeadData(List<NotificationHeadTo> notiHeadData) {
        this.notiHeadData = notiHeadData;
    }

}
