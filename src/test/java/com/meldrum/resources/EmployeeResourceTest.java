package com.meldrum.resources;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

import com.meldrum.ams.Employee;
import com.meldrum.dao.EmployeeDao;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.core.Response;
import java.util.List;

// How it could look

public class EmployeeResourceTest {

    private static final EmployeeDao dao = mock(EmployeeDao.class);
    private final EmployeeResource employeeResource = new EmployeeResource(dao);


    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new EmployeeResource(dao))
            .build();


    private final Employee employee = new Employee(1,"max","032323123", "mm");

    @Before
    public void setup() {
    }

    @After
    public void tearDown() {
        reset(dao);
    }

    @Test
    public void testCreateEmployee() throws Exception {
        // Test...
    }

}
