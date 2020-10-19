package com.corpoapp.corpoevent.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "registered", schema = "corpo_event_db", catalog = "database")
public class Registered extends PanacheEntityBase {

    @Id
    @Column(name = "event_id")
    public UUID eventId;
    public String mail;
    public Date date;

    public Registered() {
    }

    public Registered(UUID eventId, String mail, Date date) {
        this.eventId = eventId;
        this.mail = mail;
        this.date = date;
    }
}
