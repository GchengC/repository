package com.farmatodo.notifications.to;

import com.farmatodo.commons.to.ResponseTo;

import java.util.List;

public class NotificationSchedResponse extends ResponseTo {
    List<NotificationSchedRequestTo> scheduleData;

    public List<NotificationSchedRequestTo> getScheduleData() {
        return scheduleData;
    }

    public void setScheduleData(List<NotificationSchedRequestTo> scheduleData) {
        this.scheduleData = scheduleData;
    }
}
