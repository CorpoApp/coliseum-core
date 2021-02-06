package com.corpo.coliseum.domain.service;

import com.corpo.coliseum.domain.entity.Corporation;
import com.corpo.coliseum.domain.exception.ModelNotFoundException;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.testcontainers.junit.jupiter.Testcontainers;
import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.inject.Inject;

@Testcontainers
@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CorporationServiceTestIT {

   @Inject
    CorporationService corporationService;

    private static final Corporation FIRST_CORPORATION = Corporation
            .builder()
            .name("Corporation 1")
            .sport("Sport 1")
            .build();
    private static final Corporation SECOND_CORPORATION = Corporation
            .builder()
            .name("Corporation 2")
            .sport("Sport 2")
            .build();
    private static final Corporation THIRD_CORPORATION = Corporation
            .builder()
            .name("Corporation 3")
            .sport("Sport 3")
            .build();

    @Test
    @Order(1)
    public void testGetAll(){
        assertEquals(0, corporationService.getAll().size());
        corporationService.create(FIRST_CORPORATION);
        corporationService.create(SECOND_CORPORATION);
        assertEquals(2, corporationService.getAll().size());
    }

    @Test
    @Order(2)
    public void testCreate(){
        corporationService.create(THIRD_CORPORATION);
        assertEquals(3, corporationService.getAll().size());
    }

    @Test
    @Order(3)
    public void testDelete() throws ModelNotFoundException {
        corporationService.remove("Corporation 3");
        assertEquals(2, corporationService.getAll().size());
    }

}
