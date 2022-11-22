package it.xpug.kata.birthday_greetings;

import javax.mail.MessagingException;
import java.io.IOException;
import java.text.ParseException;

public class Main {

	public static void main(String[] args) throws IOException, ParseException, MessagingException {
		BirthdayService service = new BirthdayService(new EmailService("localhost", 25), new CsvEmployeeRepository("employee_data.txt"));
		service.sendGreetings(new XDate());
	}

}
