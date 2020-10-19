package com.corpoapp.corpoevent.entity.builder;

import com.corpoapp.corpoevent.entity.Registered;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.UUID;

@QuarkusTest
class RegisteredBuilderTest {

    @Test
    void testRegisteredBuilder() {
        Date date = new Date(System.currentTimeMillis());
        UUID uuid = UUID.randomUUID();
        Registered registered = RegisteredBuilder
                .aRegistered()
                .withEventId(uuid)
                .withDate(date)
                .withMail("email@titi.com")
                .build();

        Assertions.assertEquals(uuid, registered.eventId);
        Assertions.assertEquals("email@titi.com", registered.mail);
        Assertions.assertEquals(date, registered.date);
    }
}