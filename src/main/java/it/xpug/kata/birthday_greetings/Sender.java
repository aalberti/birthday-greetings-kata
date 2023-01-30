package it.xpug.kata.birthday_greetings;

import javax.mail.MessagingException;

public interface Sender {
    void sendMessage(String subject, String body, String recipient) throws MessagingException;
}
