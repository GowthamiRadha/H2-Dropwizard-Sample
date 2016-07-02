package com.meldrum.dropwizard;

import com.fasterxml.jackson.annotation.JsonProperty;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;


public class DwConfig extends Configuration {


    @Valid
    @NotNull
    @JsonProperty("database")
    private DataSourceFactory database = new DataSourceFactory();


    public DataSourceFactory getDataSourceFactory() {
        return database;
    }

}
