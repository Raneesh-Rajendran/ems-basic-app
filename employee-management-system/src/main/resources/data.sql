INSERT INTO department (dept_id, dept_name) VALUES
('1', 'IT'),
('2', 'Marketing'),
('3', 'Sales');
  
INSERT INTO employee (emp_id, first_Name, last_Name, email_address, dept_id) VALUES
('1', 'Mark','Russito', 'mark.russito@gmail.com',1),
('2', 'Jonathan','Sellers', 'jonathan.sellers@gmail.com',2),
('3', 'Julio','Rosario', 'julio.rosario@gmail.com',3),
('4', 'Karen','Oltmanns', 'karen.oltmanns@gmail.com',1),
('5', 'Dennis','McGowan', 'dennis.mcgowan@gmail.com',2),
('6', 'David','Kempton', 'david.kempton@gmail.com',3);

INSERT INTO payments (pay_id, day, month, year, salary, emp_id) VALUES
('1', '20','January', '2020',120.00,1),
('2', '21','February', '2021',215.00,2),
('3', '07','March', '2021',345.25,3),
('4', '06','April', '2020',175.36,4),
('5', '16','May', '2020',245.36,5),
('6', '04','June', '2021',345.25,6),
('7', '20','July', '2020',124.00,1),
('8', '21','August', '2021',217.00,2),
('9', '07','September', '2021',345.25,3),
('10', '06','October', '2020',185.36,4),
('11', '16','November', '2020',248.36,5),
('12', '04','December', '2021',375.25,6);