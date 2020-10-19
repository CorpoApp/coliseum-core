package com.corpoapp.corpoevent.entity.builder;

import com.corpoapp.corpoevent.entity.Corporation;

public final class CorporationBuilder {
    public String name;
    public String sport;

    private CorporationBuilder() {
    }

    public static CorporationBuilder aCorporation() {
        return new CorporationBuilder();
    }

    public CorporationBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public CorporationBuilder withSport(String sport) {
        this.sport = sport;
        return this;
    }

    public Corporation build() {
        return new Corporation(name, sport);
    }
}
