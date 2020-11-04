package com.corpoapp.corpoevent.service;

import com.corpoapp.corpoevent.dto.CorporationDTO;

import java.util.List;

public interface CorporationService {

    List<CorporationDTO> getAll();
    void create(String name, String sport);
    void remove(String name, String sport);
}
