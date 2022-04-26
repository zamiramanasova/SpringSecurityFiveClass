package com.example.springsecurityfivecass.exception;

public class EntityNotFoundException extends Exception{

    private Long id;

    public EntityNotFoundException(Long id){
        super(String.format(" У связанной сущности нет такого : '%", id));
    }
}
