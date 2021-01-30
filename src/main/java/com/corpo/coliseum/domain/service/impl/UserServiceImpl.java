package com.corpo.coliseum.domain.service.impl;

import com.corpo.coliseum.domain.exception.ModelNotFoundException;
import com.corpo.coliseum.domain.service.UserService;
import com.corpo.coliseum.api.dto.UserDTO;
import com.corpo.coliseum.api.mapper.exception.UserException;
import com.corpo.coliseum.domain.entity.User;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class UserServiceImpl implements UserService {

    @Override
    @Transactional
    public void signUp(String mail, String name) throws UserException {
            User.builder()
                    .mail(mail)
                    .name(name)
                    .build()
                    .persist();
    }

    @Override
    @Transactional
    public User findByMail(String mail) throws ModelNotFoundException {
        final User user = User.findByMail(mail)
                .orElseThrow(() -> new ModelNotFoundException("User not found !"));
        return user;
    }

}
