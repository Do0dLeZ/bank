package com.bank.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NO_CONTENT, reason="Not enough credits.")
public class NotEnoughCreditsException extends RuntimeException {

}
