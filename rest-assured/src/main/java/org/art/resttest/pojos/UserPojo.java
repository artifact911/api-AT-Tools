package org.art.resttest.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true) // позволяет не заполнять ВСЕ поля
@Getter
@Setter
public class UserPojo {
    private int id;
    private String email;
}
