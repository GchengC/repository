package com.farmatodo.notifications.to;

import com.farmatodo.commons.to.ParametersRequestTo;

public class NotificationParameter {
    private ParametersRequestTo Parameters;
    private NotificationHeadTo notiHead;
    private NotificationSchedTo scheduleData;
    private NotificationTo notiData;

    public NotificationTo getNotiData() {
        return notiData;
    }

    public void setNotiData(NotificationTo notiData) {
        this.notiData = notiData;
    }

    public NotificationSchedTo getScheduleData() {
        return scheduleData;
    }

    public void setScheduleData(NotificationSchedTo scheduleData) {
        this.scheduleData = scheduleData;
    }

    public ParametersRequestTo getParameters() {
        return Parameters;
    }

    public void setParameters(ParametersRequestTo parameters) {
        Parameters = parameters;
    }

    public NotificationHeadTo getNotiHead() {
        return notiHead;
    }

    public void setNotiHead(NotificationHeadTo notiHead) {
        this.notiHead = notiHead;
    }
}
