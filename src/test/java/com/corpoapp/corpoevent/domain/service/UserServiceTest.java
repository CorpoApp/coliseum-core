package com.corpoapp.corpoevent.domain.service;

import com.corpoapp.corpoevent.EnvironnementDataBaseSetup;
import com.corpoapp.corpoevent.api.mapper.exception.UserException;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testcontainers.junit.jupiter.Testcontainers;

import javax.inject.Inject;

@Testcontainers
@QuarkusTest
public class UserServiceTest extends EnvironnementDataBaseSetup {

    @Inject
    UserService userService;

    private String USER_MAIL = "test@corpo.com";

    @Test
    public void testSignUp() throws UserException {
        Assert.assertNull(userService.findUSer(USER_MAIL));
        userService.signUp(USER_MAIL, "test");
        Assert.assertNotNull(userService.findUSer(USER_MAIL));
    }

    @Test
    public void testAlreadySignUp() throws UserException {
        userService.signUp(USER_MAIL, "test");
        Assertions.assertThrows(UserException.class, () -> {
            userService.signUp(USER_MAIL, "test2");
        });
    }
}
