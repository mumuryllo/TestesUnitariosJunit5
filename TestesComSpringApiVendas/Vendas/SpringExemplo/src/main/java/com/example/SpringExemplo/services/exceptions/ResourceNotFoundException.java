package com.example.SpringExemplo.services.exceptions;

public class ResourceNotFoundException extends  RuntimeException{
    private static final long serialverionUID=1L;

    public ResourceNotFoundException(Object id){
        super("Caminho não encontrado! Id " + id);
    }

}
