package it.xpug.kata.birthday_greetings;

import javax.mail.MessagingException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class BirthdayService {
	private final MailSender mailSender;

	public BirthdayService(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void sendGreetings(String fileName, XDate xDate) throws IOException, ParseException, MessagingException {
		BufferedReader in = new BufferedReader(new FileReader(fileName));
		String str = "";
		str = in.readLine(); // skip header
		while ((str = in.readLine()) != null) {
			String[] employeeData = str.split(", ");
			Employee employee = new Employee(employeeData[1], employeeData[0], employeeData[2], employeeData[3]);
			if (employee.isBirthday(xDate)) {
				String recipient = employee.getEmail();
				String body = "Happy Birthday, dear %NAME%!".replace("%NAME%", employee.getFirstName());
				String subject = "Happy Birthday!";
				mailSender.sendMessage(subject, body, recipient);
			}
		}
	}
}
