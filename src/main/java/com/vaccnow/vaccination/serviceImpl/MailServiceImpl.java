package com.vaccnow.vaccination.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.vaccnow.vaccination.dto.ScheduleDTO;
import com.vaccnow.vaccination.service.IMailService;

@Service
public class MailServiceImpl implements IMailService {
	
	@Autowired
    private JavaMailSender javaMailSender;
	
    @Override
	public void sendEmail(ScheduleDTO schedule) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(schedule.getContactInfo());

        msg.setSubject("Vaccination Schedule Booked !");
        msg.setText(schedule.toString());
        javaMailSender.send(msg);

    }

}
