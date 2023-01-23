package it.xpug.kata.birthday_greetings;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public interface SendMessage {
    void sendMessage(String sender, String subject, String body, String recipient) throws AddressException, MessagingException;
}
