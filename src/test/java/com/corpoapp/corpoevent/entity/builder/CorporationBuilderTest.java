package com.corpoapp.corpoevent.entity.builder;

import com.corpoapp.corpoevent.entity.Corporation;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
class CorporationBuilderTest {

    @Test
    void testCorporationBuilder() {
        Corporation corporation = CorporationBuilder
                .aCorporation()
                .withName("testName")
                .withSport("testSport")
                .build();

        Assertions.assertEquals("testName", corporation.name);
        Assertions.assertEquals("testSport", corporation.sport);
    }
}
