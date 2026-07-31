CREATE DATABASE IF NOT EXISTS hospital_auth_db;
CREATE DATABASE IF NOT EXISTS patient_db;
CREATE DATABASE IF NOT EXISTS doctor_db;
CREATE DATABASE IF NOT EXISTS medical_record_db;
CREATE DATABASE IF NOT EXISTS appointment_db;
CREATE DATABASE IF NOT EXISTS billing_db;

CREATE USER IF NOT EXISTS 'hospital'@'%' IDENTIFIED BY 'Hospital@123';

GRANT ALL PRIVILEGES ON hospital_auth_db.* TO 'hospital'@'%';
GRANT ALL PRIVILEGES ON patient_db.* TO 'hospital'@'%';
GRANT ALL PRIVILEGES ON doctor_db.* TO 'hospital'@'%';
GRANT ALL PRIVILEGES ON medical_record_db.* TO 'hospital'@'%';
GRANT ALL PRIVILEGES ON appointment_db.* TO 'hospital'@'%';
GRANT ALL PRIVILEGES ON billing_db.* TO 'hospital'@'%';

FLUSH PRIVILEGES;