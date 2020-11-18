package com.corpoapp.corpoevent.domain.service;

import com.corpoapp.corpoevent.EnvironnementDataBaseSetup;
import com.corpoapp.corpoevent.api.dto.CorporationDTO;
import com.corpoapp.corpoevent.api.mapper.exception.UserException;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.wildfly.common.Assert;

import javax.inject.Inject;

@Testcontainers
@QuarkusTest
public class CorporationServiceTest extends EnvironnementDataBaseSetup {

    @Inject
    CorporationService corporationService;

    @Inject
    UserService userService;

    @Test
    public void testGetAll(){
        Assert.assertTrue(corporationService.getAll().isEmpty());
        corporationService.create("test", "boules");
        corporationService.create("test2", "boules2");
        Assert.assertTrue(corporationService.getAll().size() == 2);
    }

    @Test
    public void testCreate(){
        Assert.assertTrue(corporationService.getAll().isEmpty());
        corporationService.create("test", "boules");
        Assert.assertTrue(corporationService.getAll().size() == 1);
    }

    @Test
    public void testDelete(){
        corporationService.create("test", "boules");
        Assert.assertFalse(corporationService.getAll().isEmpty());
        corporationService.remove("test", "boules");
        Assert.assertTrue(corporationService.getAll().isEmpty());
    }

    @Test
    public void testRegister() throws UserException {
        corporationService.create("test", "boules");
        userService.signUp("test@corpo.com", "testUser");
        corporationService.register("test", "test@corpo.com");

        CorporationDTO result = corporationService.getAll().get(0);
        Assert.assertFalse(result.getUserList().isEmpty());
        Assert.assertTrue(result.getUserList().get(0).getName().equals("testUser"));
    }
}
