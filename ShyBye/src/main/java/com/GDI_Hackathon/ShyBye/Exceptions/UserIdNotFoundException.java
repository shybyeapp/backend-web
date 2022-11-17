package com.GDI_Hackathon.ShyBye.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "UserId not found")
public class UserIdNotFoundException extends RuntimeException{
}
