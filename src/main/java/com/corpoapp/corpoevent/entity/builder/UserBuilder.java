package com.corpoapp.corpoevent.entity.builder;

import com.corpoapp.corpoevent.entity.User;

public final class UserBuilder {
    public String mail;
    public String name;

    private UserBuilder() {
    }

    public static UserBuilder anUsers() {
        return new UserBuilder();
    }

    public UserBuilder withMail(String mail) {
        this.mail = mail;
        return this;
    }

    public UserBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public User build() {
        return new User(mail, name);
    }
}
