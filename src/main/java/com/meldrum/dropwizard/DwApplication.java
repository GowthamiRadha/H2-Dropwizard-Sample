package com.meldrum.dropwizard;


import com.meldrum.ams.mappers.AppExceptionMapper;
import com.meldrum.dao.AssetDao;
import com.meldrum.dao.EmployeeAssetConnectionDao;
import com.meldrum.dao.EmployeeDao;
import com.meldrum.resources.AssetResource;

import com.meldrum.resources.EmployeeAssetResource;
import com.meldrum.resources.EmployeeResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import io.dropwizard.jdbi.DBIFactory;
import org.skife.jdbi.v2.DBI;


public class DwApplication extends Application<DwConfig> {

    public static void main(String[] args) throws Exception {
        new DwApplication().run(args);
    }


    @Override
    public void initialize(Bootstrap<DwConfig> bootstrap) {

    }

    @Override
    public void run(DwConfig conf, Environment env) throws ClassNotFoundException {
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(env, conf.getDataSourceFactory(),"h2");

        final EmployeeDao employeeDao = jdbi.onDemand(EmployeeDao.class);
        employeeDao.createEmployeeTable();


        env.jersey().register(new EmployeeResource(employeeDao));
        env.jersey().register(new AppExceptionMapper());
    }


}
