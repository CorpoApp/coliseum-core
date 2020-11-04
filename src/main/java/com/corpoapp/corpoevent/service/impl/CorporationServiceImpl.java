package com.corpoapp.corpoevent.service.impl;

import com.corpoapp.corpoevent.dto.CorporationDTO;
import com.corpoapp.corpoevent.entity.Corporation;
import com.corpoapp.corpoevent.service.CorporationService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class CorporationServiceImpl implements CorporationService {

    @Inject
    ModelMapper modelMapper;

    @Override
    public List<CorporationDTO> getAll() {
        return modelMapper.map(Corporation.listAll(), new TypeToken<List<CorporationDTO>>() {}.getType());
    }

    @Override
    @Transactional
    public void create(String name, String sport) {
        Corporation.builder()
                .name(name)
                .sport(sport)
                .build()
                .persist();
    }

    @Override
    @Transactional
    public void remove(String name, String sport) {
        Corporation.delete("name = ?1 and sport = ?2", name, sport);
    }
}
