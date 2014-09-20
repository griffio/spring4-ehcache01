SET DATABASE SQL SYNTAX ORA TRUE;

CREATE TABLE EMPLOYEE (
  employee_id NUMBER NOT NULL,
  firstname VARCHAR(80) NOT NULL,
  lastname VARCHAR(80) NOT NULL,
  dob DATE NOT NULL,
  employer_id NUMBER NOT NULL
);

CREATE TABLE EMPLOYER (
  employer_id NUMBER NOT NULL
);

INSERT INTO EMPLOYER (employer_id) VALUES (1);
INSERT INTO EMPLOYER (employer_id) VALUES (2);
