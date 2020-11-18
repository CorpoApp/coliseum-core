package com.corpoapp.corpoevent.domain.service.impl;

import com.corpoapp.corpoevent.api.dto.UserDTO;
import com.corpoapp.corpoevent.domain.entity.Event;
import com.corpoapp.corpoevent.domain.entity.Registered;
import com.corpoapp.corpoevent.domain.entity.User;
import com.corpoapp.corpoevent.domain.service.EventService;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class EventServiceImpl implements EventService {

    @Inject
    ModelMapper modelMapper;

    @Override
    @Transactional
    public void subscribeToEvent(String mail, String eventName) {
        Event event = Event.find("name = ?1", eventName).firstResult();
        User user = User.find("mail = ?1", mail).firstResult();

        Registered.builder()
                .event(event)
                .user(user)
                .date(LocalDateTime.now())
                .build().persist();
    }

    @Override
    @Transactional
    public void createEvent(String name, Integer userSlots, LocalDateTime start, BigDecimal duration) {
        Event.builder()
                .name(name)
                .userSlots(userSlots)
                .startDate(start)
                .duration(duration)
                .build().persist();
    }

    @Override
    @Transactional
    public List<UserDTO> getRegisteredUsersForEvent(String eventName) {
        //find all registeration
        Event event = Event.find("name = ?1", eventName).firstResult();
        if(event != null){
            List<Registered> registeredList = Registered.find("event = ?1", event).list();

            if(registeredList != null && registeredList.size() > 0){
                return registeredList.stream()
                        .map(registered -> modelMapper.map(registered.user, UserDTO.class))
                        .collect(Collectors.toList());
            }
        }

        return null;
    }
}
