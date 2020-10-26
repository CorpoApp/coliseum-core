package com.corpoapp.corpoevent.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "event", schema = "corpo_event_db", catalog = "database")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Event extends PanacheEntity implements Serializable {

    public String name;
    public String description;
    @Column(name = "user_slots")
    public Integer userSlots;
    public Integer remainingSlots;
    public BigDecimal interval;
    @Column(name = "start_date")
    public LocalDateTime startDate;
    public BigDecimal duration;
    @OneToMany
    public List<Registered> registeredList;
}
