package com.markyourcode.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements ApplicationRunner {


	@Autowired
	private EmailService emailService;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(ApplicationArguments applicationArguments) throws Exception {
		System.out.println("Sending email with JavaMailSender... ");

		Mail mail = new Mail();
		mail.setFrom("email@mail.com");
		mail.setTo("some.email@email.com");
		mail.setSubject("Test email from Java App");
		mail.setContent("This is an email sent 100% with Java command line app!");

		emailService.sendSimpleMessage(mail);
	}
}