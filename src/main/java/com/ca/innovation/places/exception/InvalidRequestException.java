package com.ca.innovation.places.exception;

import com.ca.innovation.places.Statuses;

public class InvalidRequestException extends GooglePlacesException {
    public InvalidRequestException(String errorMessage) {
        super(Statuses.STATUS_INVALID_REQUEST, errorMessage);
    }

    public InvalidRequestException() {
        this(null);
    }
}
