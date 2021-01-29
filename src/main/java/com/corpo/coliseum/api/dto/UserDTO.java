package com.corpo.coliseum.api.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDTO {

    private String mail;
    private String name;
    public List<CorporationDTO> corporationList;

}