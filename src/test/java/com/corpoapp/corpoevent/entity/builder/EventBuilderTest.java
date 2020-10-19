package com.corpoapp.corpoevent.entity.builder;

import com.corpoapp.corpoevent.entity.Event;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.Date;

@QuarkusTest
class EventBuilderTest {

    @Test
    void testEventBuilder() {
        Date date = new Date(System.currentTimeMillis());
        Event event = EventBuilder
                .anEvent()
                .withDescription("description event")
                .withName("name event")
                .withDuration(BigDecimal.ONE)
                .withInterval(BigDecimal.TEN)
                .withStartDate(date)
                .withUserSlots(6)
                .build();

        Assertions.assertEquals(null, event.eventId);
        Assertions.assertEquals("description event", event.description);
        Assertions.assertEquals("name event", event.name);
        Assertions.assertEquals(BigDecimal.ONE, event.duration);
        Assertions.assertEquals(BigDecimal.TEN, event.interval);
        Assertions.assertEquals(date, event.startDate);
        Assertions.assertEquals(6, event.userSlots);
    }
}