package com.corpoapp.corpoevent.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "user", schema = "corpo_event_db", catalog = "database")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends PanacheEntity {

    @Column(unique = true)
    public String mail;
    public String name;

    @OneToMany
    public List<Registered> registeredList;
}
