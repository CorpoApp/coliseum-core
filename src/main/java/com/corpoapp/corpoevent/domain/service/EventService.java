package com.corpoapp.corpoevent.domain.service;

import com.corpoapp.corpoevent.api.dto.UserDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface EventService {

    void subscribeToEvent(String mail, String eventName);
    void createEvent(String name, Integer userSlots, LocalDateTime start, BigDecimal duration);
    List<UserDTO> getRegisteredUsersForEvent(String eventName);
}
