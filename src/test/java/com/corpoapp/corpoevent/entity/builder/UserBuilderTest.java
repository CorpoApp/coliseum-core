package com.corpoapp.corpoevent.entity.builder;

import com.corpoapp.corpoevent.entity.User;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
class UserBuilderTest {

    @Test
    void testUserBuilder() {
        User user = UserBuilder
                .anUsers()
                .withMail("email@titi.com")
                .withName("user name")
                .build();

        Assertions.assertEquals("user name", user.name);
        Assertions.assertEquals("email@titi.com", user.mail);
    }
}