package com.corpo.coliseum.domain.service;

import com.corpo.coliseum.api.dto.UserDTO;
import com.corpo.coliseum.api.mapper.exception.UserException;
import com.corpo.coliseum.domain.entity.User;
import com.corpo.coliseum.domain.exception.ModelNotFoundException;

public interface UserService {

    void signUp(String mail, String name) throws UserException;
    User findByMail(String mail) throws ModelNotFoundException;

}
