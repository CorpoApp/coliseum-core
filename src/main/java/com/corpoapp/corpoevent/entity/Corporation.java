package com.corpoapp.corpoevent.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "corporation", schema = "corpo_event_db")
public class Corporation extends PanacheEntity {
    String name;
    String sport;
}

