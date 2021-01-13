Follow the Steps to Run Project in your machine

1. Import as a maven project into your workspace
2. Database ERD added in resource folder and H2 in memory database used.
3. data.sql and schema.sql files added into the resource folder which are used to seed some data to demonstrate automatically.
4. Now open VaccinationApplication.java and run as a java application and after successfully running.

5. Now you can go through the following urls : 
    1. For all available branches
			GET http://localhost:8090/api/v1/vaccnow/branches
    
	2. For all available vaccines
			GET http://localhost:8090/api/v1/vaccnow/branches/vaccines
    
	3. For all available vaccines at specific branch
			GET   http://localhost:8090/api/v1/vaccnow/branches/{branchId}
    
	4. For all available timeslot for a branch  
			GET  http://localhost:8090/api/v1/vaccnow/branches/{branchId}/timeslots
    
	5. For all open schedules/appoinments
			GET  http://localhost:8090/api/v1/vaccnow/schedules
    
	6. For saving a schedule 
			POST http://localhost:8090/api/v1/vaccnow/schedules
       Request paramter  :  select a available time slot of a branch
   
   {
        "scheduleTime": "04:30 pm - 04:45 pm",
        "paymentMode": "CASH",
        "scheduleStatus": "OPEN",
        "paymentStatus": "OPEN",
        "contactInfo": "vivekkumar2502@gmail.com",
        "branch": {
            "branchId": 4,
            "branchName": "City X-Ray",
            "branchLocation": "Janakpuri"
        },
        "vaccine": {
            "vaccineId": 2,
            "vaccineCode": "Covid2",
            "vaccineName": "mRNA-1273",
            "vaccineCost": "3000",
            "vaccineCountry": "IND"
        }
    }

    After successfully saved a confirmation mail would be sent to contactInfo email.

    7. For updating the schedule 
		POST http://localhost:8090/api/v1/vaccnow/schedules
        Body paramter select a available time slot of a branch and add in the same format
    
    {
        "scheduleId" : {scheduleId}
        "paymentMode": "CASH",
        "scheduleStatus": "CLOSE",
        "paymentStatus": "OPEN",
        "contactInfo": "vivekkumar2502@gmail.com",
        "branch": {
            "branchId": 4,
            "branchName": "City X-Ray",
            "branchLocation": "Janakpuri"
        },
        "vaccine": {
            "vaccineId": 2,
            "vaccineCode": "Covid2",
            "vaccineName": "mRNA-1273",
            "vaccineCost": "3000",
            "vaccineCountry": "IND"
        }
    }
	
	
	8. For getting all vaccination applied at particular branch
		GET http://localhost:8090/api/v1/vaccnow/reports/4
		
	9. For all applied vaccnation
		GET http://localhost:8090/api/v1/vaccnow/reports/vaccines



