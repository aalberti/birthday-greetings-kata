package it.xpug.kata.birthday_greetings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class EmployeRepository implements IEmployeRepository {
     private final String fileName;

    public EmployeRepository(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Employee> getEmploye() throws IOException, ParseException {
        List<Employee> employees = new ArrayList<>();
        BufferedReader in = new BufferedReader(new FileReader(this.fileName));
        String str = "";
        str = in.readLine(); // skip header
        while ((str = in.readLine()) != null) {
            String[] employeeData = str.split(", ");
            employees.add(new Employee(employeeData[1], employeeData[0], employeeData[2], employeeData[3]));
        }
        return employees;
    }
}
