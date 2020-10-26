package com.corpoapp.corpoevent.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "registered", schema = "corpo_event_db", catalog = "database")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Registered extends PanacheEntityBase implements Serializable {

    @ManyToOne
    @Id
    public Event event;

    @ManyToOne
    @Id
    public User user;

    public String mail;
    public LocalDateTime date;
}
