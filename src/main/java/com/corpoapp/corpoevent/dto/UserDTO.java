package com.corpoapp.corpoevent.dto;

import com.corpoapp.corpoevent.entity.Corporation;
import lombok.Data;

import java.util.List;

@Data
public class UserDTO {

    private String mail;
    private String name;
    public List<Corporation> corporationList;

}
