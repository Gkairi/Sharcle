package com.ca.innovation.places.exception;

import com.ca.innovation.places.Statuses;

public class OverQueryLimitException extends GooglePlacesException {
    public OverQueryLimitException(String errorMessage) {
        super(Statuses.STATUS_OVER_QUERY_LIMIT, errorMessage);
    }

    public OverQueryLimitException() {
        this(null);
    }
}
