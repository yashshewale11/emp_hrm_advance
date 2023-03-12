package com.csi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends RuntimeException {
    public RecordNotFoundException(String msg) {
        super("## THE RECORD YOU TRY TO FETCH IS EITHER DELETED OR NOT PRESENT ##" + HttpStatus.NOT_FOUND);
    }
}
