package com.enorkus.academy.validators;

import javax.xml.bind.ValidationException;

public abstract class Validator<T> {
    public abstract void validate(T atribute, String message ) throws ValidationException;
}
