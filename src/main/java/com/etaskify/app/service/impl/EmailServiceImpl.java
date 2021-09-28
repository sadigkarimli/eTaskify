package com.etaskify.app.service.impl;

import com.etaskify.app.model.Email;
import com.etaskify.app.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String mailFrom;

    @Override
    public void sendEmail(Email email) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(mailFrom);
        message.setTo(email.getSendTo().toArray(new String[0]));
        message.setSubject(email.getSubject());
        message.setText(email.getBody());

        mailSender.send(message);
    }
}
