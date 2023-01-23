package it.xpug.kata.birthday_greetings;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class BirthdayService {
     SendMessage sendMessage;
	 private final EmployeRepository employeRepository;

	 public BirthdayService(SendMessage message, EmployeRepository employeRepository){
		  this.sendMessage = message;
		  this.employeRepository = employeRepository;
	 }

	public void sendGreetings(XDate xDate) throws IOException, ParseException, AddressException, MessagingException {
		    List<Employee> listeEmployes = employeRepository.getEmploye();
			for (Employee employee : listeEmployes) {
				if (employee.isBirthday(xDate)) {
					String recipient = employee.getEmail();
					String body = "Happy Birthday, dear %NAME%!".replace("%NAME%", employee.getFirstName());
					String subject = "Happy Birthday!";
					sendMessage.sendMessage("sender@here.com", subject, body, recipient);
				}
			}
		}
}
