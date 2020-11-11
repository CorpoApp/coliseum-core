package com.corpoapp.corpoevent.dto;

import com.corpoapp.corpoevent.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class CorporationDTO {

    private String name;
    private String sport;
    public List<User> userList;
}

