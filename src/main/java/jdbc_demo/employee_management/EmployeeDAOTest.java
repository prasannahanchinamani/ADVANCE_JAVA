package jdbc_demo.employee_management;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDAOTest {
    private static EmployeeDAO dao;

    @BeforeAll
    static void setup() {
        dao = new EmployeeDAO();
    }

    //test creation
    @Test
    public void testCreation() {
        boolean cretaed = dao.createEmployee("Prasanna", "as", 35000, 1);
        assertTrue(cretaed);
        assertThrows(RuntimeException.class, () -> {
            dao.createEmployee("Prajwal", "manager", 85000, -1);
        });
    }

    //get by deoartment
    @Test
    public void testgetByDepartment() {
        List<Employee> emp = dao.getEmployeesByDepartment("IT");
        assertNotNull(emp.size());
        assertTrue(emp.size() >= 1);
    }

    //test update salar
    @Test
    public void testupdateSalary() {
        boolean updated = dao.updateSalary(3, 50000); // valid ID
        assertTrue(updated);
        Exception exception = assertThrows(RuntimeException.class, () -> dao.updateSalary(9999, 10000));
        assertEquals("Not update", exception.getMessage());
    }

    //test low salary
    @Test
    public void testDelete() {
        int x = dao.deleteLowSalaryEmployees();
        assertEquals(x, 0);
    }

    //top employee list
    @Test
    public void higestPaidEmployee() {
        List<Employee> topEmp = dao.highestPaidEmployees();
        assertNotNull(topEmp.size());
        assertTrue(topEmp.size() >= 1);
    }
}