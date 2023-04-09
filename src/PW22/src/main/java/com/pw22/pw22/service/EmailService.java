package com.pw22.pw22.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.scheduling.annotation.Async;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Service
public class EmailService {
    private final JavaMailSender emailSender;

    @Autowired
    public EmailService(JavaMailSenderImpl emailSender) {
        this.emailSender = emailSender;
    }

    @Async
    public void sendEmail(String className, String messageText) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("mirea.spring@yandex.ru");
        message.setTo("qwerty4243444546@gmail.com");
        message.setSubject(className + " saved at " + DateTimeFormatter.
                ofLocalizedDateTime(FormatStyle.SHORT).format(LocalDateTime.now()));
        message.setText(messageText);
        emailSender.send(message);
    }
}
