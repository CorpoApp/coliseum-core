package com.corpo.coliseum.domain.service.impl;

import com.corpo.coliseum.api.mapper.exception.UserException;
import com.corpo.coliseum.domain.entity.Corporation;
import com.corpo.coliseum.domain.entity.User;
import com.corpo.coliseum.domain.exception.ModelNotFoundException;
import com.corpo.coliseum.domain.service.CorporationService;
import com.corpo.coliseum.domain.service.UserService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@ApplicationScoped
public class CorporationServiceImpl implements CorporationService {

    @Inject
    UserService userService;

    @Override
    public List<Corporation> getAll() {
        final List<Corporation> allCorporations = Corporation.listAll();
        return allCorporations;
    }

    @Override
    public Corporation findByName(String name) throws ModelNotFoundException {
        final Corporation corporation = Corporation.findByName(name)
                .orElseThrow(() -> new ModelNotFoundException("Corporation not found !"));
        return corporation;
    }

    @Override
    @Transactional
    public Corporation create(@Valid Corporation corporation) {
        corporation.persist();
        return corporation;
    }

    @Override
    @Transactional
    public void remove(@Valid Corporation corporation) {
        corporation.delete();
    }

    @Override
    public void register(String name, String mail) throws UserException {
        if(userService.userAlreadySignIn(mail)){
            Corporation corporation = Corporation.find("name = ?1", name).firstResult();
            User user = User.find("mail = ?1", mail).firstResult();
            if(corporation != null && user != null){
                corporation.userList.add(user);
                corporation.persist();
            }
        } else {
            throw new UserException("User not registered");
        }
    }
}
