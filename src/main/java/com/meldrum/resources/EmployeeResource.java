package com.meldrum.resources;

import com.meldrum.ams.Employee;
import com.meldrum.dao.EmployeeDao;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/Employee")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeResource {

    private EmployeeDao employeeDao;

    public EmployeeResource(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }


    @GET
    @Path("/getAll")
    public List<Employee> getAllEmployees() { return this.employeeDao.getAll(); }

    @POST
    public Employee addEmployee(@Valid Employee employee) {
        int employeeID = this.employeeDao.addEmployee(employee);
        employee.setId(employeeID);
        return employee;
    }

    @DELETE
    @Path("/remove/{id}")
    public int removeEmployee(@PathParam("id") int id) {
        this.employeeDao.removeEmployeeById(id);
        return id;
    }



}
