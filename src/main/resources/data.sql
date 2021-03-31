insert into patients.patient (id,fname,lname,email,phone,age,hospital_id) values(1,'fname1','lname1','abc1@xyz.com','9988776651',21,1081);	
insert into patients.patient (id,fname,lname,email,phone,age,hospital_id) values(2,'fname2','lname2','abc2@xyz.com','9988776651',32,1082);
insert into patients.address (id,patient_id,state,city,street,zipcode) 	values(11,1,'state1','city1','street1','4321');
insert into patients.address (id,patient_id,state,city,street,zipcode) values(22,2,'state1','city1','street1','4321');
	
--truncate table patients.address;	
--truncate table patients.patient;
