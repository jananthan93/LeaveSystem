
INSERT INTO trainee.department(department_name) VALUES('QA');
INSERT INTO trainee.department(department_name) VALUES('Development');

INSERT INTO trainee.exam_type(exam_type_name) VALUES('O/L');
INSERT INTO trainee.exam_type(exam_type_name) VALUES('A/L');

INSERT INTO trainee.attend_status VALUES (1, 'good', NULL);
INSERT INTO trainee.attend_status VALUES (2, 'bad', NULL);

INSERT INTO trainee.attend_type VALUES (1, 'week', NULL);
INSERT INTO trainee.attend_type VALUES (2, 'weekend', NULL);


INSERT INTO trainee.trainee VALUES (1, '2019-01-01 05:30:00', 'tpakikaran14@gmail.com', 'UnEmployee', 'pakikaran', 'Male', '2019-01-01 05:30:00', 'single', '771030615', NULL, 
'Srilankan', '921961464v', NULL, 'kanchipurammathagal', NULL, 'Degree','Hindu', 'kanchipurammathagal', NULL, '0212224565', '2019-01-12 10:44:33.453', 1);
INSERT INTO trainee.trainee VALUES (2, '2019-01-01 05:30:00', 'tpakikaran14@gmail.com', 'Employee', 'Suwarnan', 'Male', '2019-01-01 05:30:00', 'single', '771030615', NULL, 
'Srilankan', '901961464v', NULL, 'jaffna', NULL, 'Diploma','Hindu', 'kanchipurammathagal', NULL, '0212224565', '2019-01-12 10:44:33.453', 1);
INSERT INTO trainee.trainee VALUES (3, '2019-01-01 05:30:00', 'tpakikaran14@gmail.com', 'Employee', 'Jananthan', 'Male', '2019-01-01 05:30:00', 'single', '771030615', NULL, 
'Srilankan', '891961464v', NULL, 'jaffna', NULL, 'Degree','Hindu', 'kanchipurammathagal', NULL, '0212224565', '2019-01-12 10:44:33.453', 1);

INSERT INTO trainee.academic_qualification VALUES (1, '2019-01-12 10:45:09.258', 2003, 2003, 2008, 'Passed', 'J/MSJMV', '2019-01-12 10:45:09.258', 1, 1);
INSERT INTO trainee.academic_qualification VALUES (2, '2019-01-12 10:45:09.258', 2003, 2003, 2008, 'Passed', 'J/MSJMV', '2019-01-12 10:45:09.258', 1, 2);

INSERT INTO trainee.professional_membership VALUES (1, 1, 'partcipate', 'Annual Meet 2014', 'YarlIT', 2013, 2017, 1);
INSERT INTO trainee.professional_membership VALUES (2, 1, 'partcipate', 'Annual Meet 2014', 'YarlIT', 2013, 2017, 2);

INSERT INTO trainee.professional_qualification VALUES (1, 'Physical Science', 'Computer Science', 2018, 2.5, 'University Of Jaffna', 2013, 2017, 'passed', 1);
INSERT INTO trainee.professional_qualification VALUES (2, 'Physical Science', 'Computer Science', 2018, 2.5, 'University Of Jaffna', 2013, 2017, 'passed', 2);

INSERT INTO trainee.referee VALUES (1, 'kanchipuram, mathagal', '0771030615', 'tpakikaran14@gmail.com', 'Ramanan', 'HOD', 1);
INSERT INTO trainee.referee VALUES (2, 'kanchipuram, mathagal', '0771030615', 'tpakikaran14@gmail.com', 'Ramanan', 'HOD', 2);

INSERT INTO trainee.work_experience VALUES (1, 'Demo', 40000, 2018, 2019, 'End period', 'Demonstator', 'Jaffan University', 'Instructor', 1);
INSERT INTO trainee.work_experience VALUES (2, 'Demo', 40000, 2018, 2019, 'End period', 'Demonstator', 'Jaffan University', 'Instructor', 2);

