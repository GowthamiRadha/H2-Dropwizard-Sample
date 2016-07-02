package com.meldrum.ams.mappers;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.core.Response;
import java.util.HashMap;

import org.eclipse.jetty.http.HttpStatus;


public class AppExceptionMapper implements ExceptionMapper<WebApplicationException> {

    @Override
    public Response toResponse(final WebApplicationException e) {
        final String type = "error";
        int status = e.getResponse() == null ? 500 : e.getResponse().getStatus();

        final String msg = e.getMessage() == null ?
                HttpStatus.getMessage(status) : e.getMessage();

        return Response.status(status).
                entity(new HashMap<String, String>() {
                    {
                        put(type, msg);
                    }
                }).build();
    }
}
