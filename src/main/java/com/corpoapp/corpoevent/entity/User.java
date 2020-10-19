package com.corpoapp.corpoevent.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user", schema = "corpo_event_db", catalog = "database")
public class User extends PanacheEntityBase {
    @Id
    public String mail;
    public String name;

    public User() {
    }

    public User(String mail, String name) {
        this.mail = mail;
        this.name = name;
    }
}
