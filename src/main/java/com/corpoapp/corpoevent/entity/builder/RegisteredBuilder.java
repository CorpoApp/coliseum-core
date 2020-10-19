package com.corpoapp.corpoevent.entity.builder;

import com.corpoapp.corpoevent.entity.Registered;

import java.sql.Date;
import java.util.UUID;

public final class RegisteredBuilder {
    public UUID eventId;
    public String mail;
    public Date date;

    private RegisteredBuilder() {
    }

    public static RegisteredBuilder aRegistered() {
        return new RegisteredBuilder();
    }

    public RegisteredBuilder withEventId(UUID eventId) {
        this.eventId = eventId;
        return this;
    }

    public RegisteredBuilder withMail(String mail) {
        this.mail = mail;
        return this;
    }

    public RegisteredBuilder withDate(Date date) {
        this.date = date;
        return this;
    }

    public Registered build() {
        return new Registered(eventId, mail, date);
    }
}
