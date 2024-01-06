package com.art.apifeature.animals.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateAnimalReqBody {

    private String type;
    private int age;
    private String name;
}
