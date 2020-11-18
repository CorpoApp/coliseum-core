package com.corpoapp.corpoevent.domain.service;

import com.corpoapp.corpoevent.EnvironnementDataBaseSetup;
import com.corpoapp.corpoevent.api.dto.UserDTO;
import com.corpoapp.corpoevent.api.mapper.exception.UserException;
import com.corpoapp.corpoevent.domain.entity.Event;
import com.corpoapp.corpoevent.domain.entity.Registered;
import com.corpoapp.corpoevent.domain.entity.User;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.junit.jupiter.Testcontainers;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Testcontainers
@QuarkusTest
public class EventServiceTest extends EnvironnementDataBaseSetup {

    @Inject
    EventService eventService;

    @Inject
    UserService userService;

    @BeforeEach
    @Transactional
    public void setUpUser() throws UserException {
        userService.signUp("test@corpo.com", "testUser");
        userService.signUp("test1@corpo.com", "testUser1");
    }

    @Test
    public void testCreateEvent(){
        eventService.createEvent("First corpo event", 6, LocalDateTime.now(), BigDecimal.TEN);

        Assert.assertNotNull(Event.find("name = ?1", "First corpo event").firstResult());
        Assert.assertNull(Event.find("name = ?1", "First corpo").firstResult());
    }

    @Test
    public void testSubscribeToEvent(){
        eventService.createEvent("corpo event", 6, LocalDateTime.now(), BigDecimal.TEN);
        User userToSub = User.find("mail = ?1","test@corpo.com").firstResult();

        eventService.subscribeToEvent("test@corpo.com", "corpo event");

        Assert.assertNotNull(Registered.find("user = ?1", userToSub).firstResult());
    }

    @Test
    public void testGetRegisteredUsersForEvent(){
        eventService.createEvent("corpo event", 6, LocalDateTime.now(), BigDecimal.TEN);
        eventService.subscribeToEvent("test@corpo.com", "corpo event");
        eventService.subscribeToEvent("test1@corpo.com", "corpo event");

        List<UserDTO> userDTOList = eventService.getRegisteredUsersForEvent("corpo event");
        Assert.assertNotNull(userDTOList);
        Assert.assertEquals(2, userDTOList.size());

        Assert.assertEquals("testUser", userDTOList.get(0).getName());
    }
}
