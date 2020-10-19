package com.corpoapp.corpoevent.entity.builder;

import com.corpoapp.corpoevent.entity.Event;

import java.math.BigDecimal;
import java.sql.Date;

public final class EventBuilder {
    public String name;
    public String description;
    public Integer userSlots;
    public BigDecimal interval;
    public Date startDate;
    public BigDecimal duration;

    private EventBuilder() {
    }

    public static EventBuilder anEvent() {
        return new EventBuilder();
    }

    public EventBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public EventBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public EventBuilder withUserSlots(Integer userSlots) {
        this.userSlots = userSlots;
        return this;
    }

    public EventBuilder withInterval(BigDecimal interval) {
        this.interval = interval;
        return this;
    }

    public EventBuilder withStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public EventBuilder withDuration(BigDecimal duration) {
        this.duration = duration;
        return this;
    }

    public Event build() {
        return new Event(name, description, userSlots, interval, startDate, duration);
    }
}
