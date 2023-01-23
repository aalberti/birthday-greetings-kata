package it.xpug.kata.birthday_greetings;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface IEmployeRepository {
    List<Employee> getEmploye() throws IOException, ParseException;
}
