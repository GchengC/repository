package com.farmatodo.notifications.to;

import java.util.List;

public class NotificationSchedList {
    List<NotificationSchedRequestTo> scheduleData;

    public List<NotificationSchedRequestTo> getScheduleData() {
        return scheduleData;
    }

    public void setScheduleData(List<NotificationSchedRequestTo> scheduleData) {
        this.scheduleData = scheduleData;
    }
}
