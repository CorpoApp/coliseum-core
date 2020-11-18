package com.corpoapp.corpoevent;

import com.corpoapp.corpoevent.domain.entity.Corporation;
import com.corpoapp.corpoevent.domain.entity.Event;
import com.corpoapp.corpoevent.domain.entity.Registered;
import com.corpoapp.corpoevent.domain.entity.User;
import org.junit.jupiter.api.BeforeEach;

import javax.transaction.Transactional;

public class EnvironnementDataBaseSetup {

    @BeforeEach
    @Transactional
    public void setUp() {
        Registered.deleteAll();
        Event.deleteAll();
        Corporation.deleteAll();
        User.deleteAll();
    }

}
