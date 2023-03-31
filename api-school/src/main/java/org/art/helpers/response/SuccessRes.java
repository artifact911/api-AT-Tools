package org.art.helpers.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.art.common.Status;

@Getter
@AllArgsConstructor
public class SuccessRes {

    private int statusCode;
    private Status status;
}
