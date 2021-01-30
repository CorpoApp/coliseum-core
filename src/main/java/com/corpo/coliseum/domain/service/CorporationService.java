package com.corpo.coliseum.domain.service;

import com.corpo.coliseum.api.mapper.exception.UserException;
import com.corpo.coliseum.domain.entity.Corporation;
import com.corpo.coliseum.domain.exception.ModelNotFoundException;

import java.util.List;

public interface CorporationService {

    List<Corporation> getAll();

    Corporation findByName(String name) throws ModelNotFoundException;
    Corporation create(Corporation corporation);
    void remove(Corporation corporation);
    void register(String name, String mail) throws UserException;
}
