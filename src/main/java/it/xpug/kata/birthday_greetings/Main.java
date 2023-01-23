package it.xpug.kata.birthday_greetings;

import java.io.*;
import java.text.ParseException;

import javax.mail.*;
import javax.mail.internet.*;

public class Main {

	public static void main(String[] args) throws AddressException, IOException, ParseException, MessagingException {
		BirthdayService service = new BirthdayService(new EmailSender("localhost", 25), new EmployeRepository("employee_data.txt"));
		service.sendGreetings(new XDate());
	}

}
