package com.mode.common.dropwizard;

public class Brand {
    private final Long id;
    private final String name;

    public Brand(Long id, String name) {
        this.name = name;
        this.id = id;
    }

    public Long getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }
}
