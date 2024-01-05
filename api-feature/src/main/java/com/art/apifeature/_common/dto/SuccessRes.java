package com.art.apifeature._common.dto;

import com.art.apifeature._common.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SuccessRes {

    private int statusCode;
    private Status status;
    private String info;
}
