package com.corpoapp.corpoevent.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "event", schema = "corpo_event_db", catalog = "database")
public class Event extends PanacheEntityBase {

    @Id
    @Column(name = "event_id")
    @GeneratedValue()
    public UUID eventId;
    public String name;
    public String description;
    @Column(name = "user_slots")
    public Integer userSlots;
    public BigDecimal interval;
    @Column(name = "start_date")
    public Date startDate;
    public BigDecimal duration;

    public Event() {
    }

    public Event(String name, String description, Integer userSlots, BigDecimal interval, Date startDate, BigDecimal duration) {
        this.name = name;
        this.description = description;
        this.userSlots = userSlots;
        this.interval = interval;
        this.startDate = startDate;
        this.duration = duration;
    }
}
