package com.corpoapp.corpoevent.service;

import com.corpoapp.corpoevent.entity.Corporation;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.wildfly.common.Assert;

import javax.inject.Inject;
import javax.transaction.Transactional;

@QuarkusTest
@QuarkusTestResource(H2DatabaseTestResource.class)
public class CorporationServiceTest {

    @Inject
    CorporationService corporationService;

    @BeforeEach
    @Transactional
    public void setUp(){
        Corporation.deleteAll();
    }

    @Test
    public void testGetAll(){
        Assert.assertTrue(corporationService.getAll().isEmpty());
    }

    @Test
    public void testCreate(){
        corporationService.create("test", "boules");
        Assert.assertFalse(corporationService.getAll().isEmpty());
    }

    @Test
    public void testDelete(){
        corporationService.create("test", "boules");
        Assert.assertFalse(corporationService.getAll().isEmpty());
        corporationService.remove("test", "boules");
        Assert.assertTrue(corporationService.getAll().isEmpty());
    }
}
