package org.art.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DaoException extends RuntimeException {

    public DaoException(String message) {
        super(message);
    }
}
