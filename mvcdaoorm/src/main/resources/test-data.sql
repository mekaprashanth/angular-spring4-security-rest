INSERT INTO Employees (userid, username, password, enabled)
VALUES
    (1, 'prash', '$2a$10$dc0n7uCoSz/jS8EZiuZX6ekf9XT4g/FMSMaUQIqLnQdW98N/bXxlq', 1);
 
INSERT INTO Roles (roleid, userid, role)
VALUES
    (1, 1, 'ADMIN'),
    (2, 1, 'USER'),
    (3, 1, 'ADMIN1'),
    (4, 1, 'ADMIN2'),
    (5, 1, 'ADMIN3'),
    (6, 1, 'ADMIN4'),
    (7, 1, 'CEO');
    
    
 

INSERT INTO PORTAL_USER (USER_ID, USERNAME, PASSWORD, FORENAME, LASTNAME, EMAIL_ADDRESS, IS_ACTIVE, CREATION_DATE, ACTIVATION_DATE, ACCOUNT_STATUS)
VALUES
    (1, 'prash', '$2a$10$dc0n7uCoSz/jS8EZiuZX6ekf9XT4g/FMSMaUQIqLnQdW98N/bXxlq', 'prashanth', 'meka', 'prashanth_meka@infosys.com', 1, current_timestamp, current_timestamp, 'ACTIVE');
	

INSERT INTO PORTAL_USER_FUNCTION (USER_FUNCTION_ID, ROLE_FUNCTION_ID, USER_ID)
VALUES
    (1, 1, 1),
    (2, 2, 1),
    (3, 3, 1),
    (4, 4, 1),
    (5, 5, 1);

INSERT INTO PORTAL_ROLE_FUNCTION (ROLE_FUNCTION_ID, PORTAL_FUNCTION_ID, ROLE_ID, CAN_READ, CAN_CREATE, CAN_UPDATE)
VALUES
    (1, 1, 1, 1, 1, 1),
    (2, 2, 1, 1, 1, 1),
    (3, 3, 1, 1, 1, 1),
    (4, 2, 2, 0, 1, 0),
    (5, 3, 3, 1, 1, 1);

INSERT INTO PORTAL_FUNCTION (PORTAL_FUNCTION_ID, NAME, REST_URL)
VALUES
    (1, 'CREATE USER', '/createUser'),
    (2, 'GETSALESDETAILS', '/getSalesDetails'),
	(3, 'REFUND', '/refund');

INSERT INTO PORTAL_ROLE (ROLE_ID, NAME)
VALUES
    (1, 'ADMIN'),
    (2, 'USER'),
	(3, 'CEO');
	
	

 