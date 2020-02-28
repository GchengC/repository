package com.farmatodo.notifications.to;

import com.farmatodo.commons.to.RequestTo;

public class NotificationSchedRequestTo extends RequestTo {
    NotificationSchedTo scheduleData;

    public NotificationSchedTo getScheduleData() {
        return scheduleData;
    }

    public void setScheduleData(NotificationSchedTo scheduleData) {
        this.scheduleData = scheduleData;
    }
}
