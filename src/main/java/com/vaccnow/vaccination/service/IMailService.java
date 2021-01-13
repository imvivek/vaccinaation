package com.vaccnow.vaccination.service;

import com.vaccnow.vaccination.dto.ScheduleDTO;

public interface IMailService {
	void sendEmail(ScheduleDTO schedule);
}
