package com.harik.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class vehicleNotFoundException extends RuntimeException
{
    public vehicleNotFoundException(String message)
    {
        super(message);
    }
}
