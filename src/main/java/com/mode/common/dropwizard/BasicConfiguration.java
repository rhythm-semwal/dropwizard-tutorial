package com.mode.common.dropwizard;

import javax.validation.constraints.NotNull;
import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;

public class BasicConfiguration extends Configuration{
    @NotNull private final int defaultSize;

    @JsonCreator
    public BasicConfiguration(@JsonProperty("defaultSize") int defaultSize){
        this.defaultSize = defaultSize;
    }

    public int getDefaultSize(){
        return this.defaultSize;
    }
}
