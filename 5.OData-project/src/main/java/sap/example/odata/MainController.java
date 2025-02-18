package sap.example.odata;

import com.sap.cloud.sdk.cloudplatform.connectivity.DestinationAccessor;
import com.sap.cloud.sdk.cloudplatform.connectivity.HttpDestination;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sap.example.odata.generate.namespaces.odata.Employee;
import sap.example.odata.generate.services.DefaultOdataService;

import java.util.List;

@RestController
@RequestMapping(path = "")
public class MainController {


    @GetMapping(path = "/all/Employee")
    public List<Employee> readAll() {
        HttpDestination destination = DestinationAccessor.getLoader().tryGetDestination("Nortwind")
                .get().asHttp();

        List<Employee> employeeList = new DefaultOdataService()
                .withServicePath("")
                .getAllEmployees()
                .execute(destination);

        return employeeList;
    }

    @GetMapping(path = "/first/Employee")
    public Employee firstEmployee() {
        HttpDestination destination = DestinationAccessor.getLoader().tryGetDestination("Nortwind")
                .get().asHttp();

        Employee employee = new DefaultOdataService()
                .withServicePath("")
                .getEmployeesByKey(1)
                .execute(destination);

        return employee;
    }

    @GetMapping(path = "/get/Employees")
    public List<Employee> getEmployees() {
        HttpDestination destination = DestinationAccessor.getLoader().tryGetDestination("Nortwind")
                .get().asHttp();

        List<Employee> employeeList = new DefaultOdataService()
                .withServicePath("")
                .getAllEmployees()
                .filter(Employee.EMPLOYEE_ID.greaterThan(5))
                .select(Employee.EMPLOYEE_ID, Employee.FIRST_NAME, Employee.LAST_NAME)
                .execute(destination);

        return employeeList;
    }

}
