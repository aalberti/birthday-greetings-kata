package it.xpug.kata.birthday_greetings;

import javax.mail.MessagingException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class BirthdayService {
    EmailService emailService;
	EmployeeRepository employeeRepository;

    public BirthdayService(EmailService emailService, EmployeeRepository employeeRepository) {
        this.emailService = emailService;
		this.employeeRepository = employeeRepository;
	}

    public void sendGreetings(XDate xDate) throws IOException, ParseException, MessagingException {
		List<Employee> employees = employeeRepository.getAll();
		for (Employee employee : employees) {
            if (employee.isBirthday(xDate)) {
                String recipient = employee.getEmail();
                String body = "Happy Birthday, dear %NAME%!".replace("%NAME%", employee.getFirstName());
                String subject = "Happy Birthday!";
                emailService.sendMessage(subject, body, recipient);
            }
        }
    }
}
