package com.corpoapp.corpoevent.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "corporation", schema = "corpo_event_db", catalog = "database")
public class Corporation extends PanacheEntityBase {

    @Column(unique = true)
    @Id
    public String name;

    public String sport;

    public Corporation() {
    }

    public Corporation(String name) {
        this.name = name;
    }

    public Corporation(String name, String sport) {
        this.name = name;
        this.sport = sport;
    }


}

