package com.lab01.psoft.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class EmptySubject extends Subject{

    public EmptySubject(){
        super(null,null,null);
    }

}
