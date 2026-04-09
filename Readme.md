# 🏥 Smart HealthCare Appointment & Management System

## 📌 Project Overview

The **Smart HealthCare Appointment & Management System** is a full-stack backend application designed to streamline healthcare operations. It enables patients to book appointments, doctors to manage patient records, and administrators to oversee the entire system efficiently.A robust backend healthcare management system built using Spring Boot that simplifies patient care, appointment scheduling, and medical record management. The system supports role-based access for Admins, Doctors, and Patients, ensuring secure and efficient healthcare operations

This system follows a **clean layered architecture** using **Spring Boot**, ensuring scalability, maintainability, and modular development.

---

## 🚀 Tech Stack

* **Java (Core Java)** – Business logic, OOP concepts, collections, exception handling
* **Spring Boot** – REST API development & dependency injection
* **Spring Data JPA** – ORM for database operations
* **MySQL / PostgreSQL** – Relational database
* **Postman** – API testing and validation
### simply 
* Backend: Java, Spring Boot
* Database: MySQL / PostgreSQL
* ORM: Spring Data JPA
* API Testing: Postman
* Authentication: Basic Role-Based Access (can be extended to JWT)
---

## 🧩 Features & Modules

##### Features
* Patient Management: Maintain patient details including personal information and history
* Doctor Management: Manage doctor profiles and specializations
* Appointment Scheduling: Book, update, and cancel appointments
* Medical Records: Store and manage diagnosis, prescriptions, and treatment details
* Admin Dashboard: Monitor system activity and manage users
* Search Functionality: Find doctors by specialization
* Notifications: Appointment reminders (mocked Email/SMS)
* User Authentication: Role-based access control (Admin, Doctor, Patient)

### 1. 👤 User Management

* Patient and Doctor registration & login
* Role-based access control:

  * Admin
  * Doctor
  * Patient

---

### 2. 📅 Appointment Booking

* Search doctors by specialization
* Book, update, or cancel appointments
* Doctors can approve or reject appointments

---

### 3. 📋 Medical Records

* Doctors can add/update diagnosis & prescriptions
* Patients can view medical history

---

### 4. 📊 Admin Dashboard

* Manage doctors, patients, and appointments
* View analytics (e.g., most-booked doctors)

---

### 5. 🔔 Notifications

* Email/SMS reminders for appointments *(can be mocked)*

---



## 🏗️ Project Structure

```
com.healthcare
├── controller      # REST Controllers
├── service         # Business Logic Layer
├── repository      # JPA Repositories
├── model           # Entity Classes
├── dto             # Data Transfer Objects
├── config          # Configuration Files
└── exception       # Custom Exception Handling
```

---
## Installation
### Prerequisites

Java (JDK 8 or above)

Maven

MySQL or PostgreSQL

Postman (for API testing)


### Setup Instructions
Clone the repository
Navigate to the project directory
Configure database in application.properties

Run the following command:

mvn spring-boot:run

Application will start on:

http://localhost:8080

### Usage
Start the application
Use Postman to test APIs
Perform operations like:
   * Add Doctors & Patients
   * Book Appointments
   * Manage Medical Records
   * View Admin Dashboard

----

## 🔌 REST API Endpoints

### 👨‍⚕️ Doctor APIs

* manage doctor profiles and specializations

#### Create Doctor

```
POST /api/doctors
```

```json
{
  "name": "Dr. Ravi Kumar",
  "email": "ravi.kumar@example.com",
  "specialization": "Cardiologist"
}
```

#### Get All Doctors

```
GET /api/doctors
```

#### Get Doctor By ID

```
GET /api/doctors/{id}
```

#### Update Doctor

```
PUT /api/doctors/{id}
```

#### Delete Doctor

```
DELETE /api/doctors/{id}
```

---

### 👩‍⚕️ Patient APIs

 * Create, update, delete, and fetch patient details

#### Create Patient

```
POST /api/patients
```

```json
{
  "name": "John Doe",
  "email": "john.doe@example.com",
  "phone": "9876543210"
}
```

#### Get All Patients

```
GET /api/patients
```

#### Get Patient By ID

```
GET /api/patients/{id}
```

#### Update Patient

```
PUT /api/patients/{id}
```

#### Delete Patient

```
DELETE /api/patients/{id}
```

---

### 📅 Appointment APIs

* Book, update, cancel, and view appointments

#### Book Appointment

```
POST /api/appointments
```

```json
{
  "doctorId": 1,
  "patientId": 2,
  "appointmentTime": "2025-06-20T15:00:00"
}
```

#### Get All Appointments

```
GET /api/appointments
```

#### Get Appointment By ID

```
GET /api/appointments/{id}
```

#### Update Appointment

```
PUT /api/appointments/{id}
```

#### Delete Appointment

```
DELETE /api/appointments/{id}
```

---

### 📋 Medical Records APIs

* Add and retrieve diagnosis and treatment details

#### Add Medical Record

```
POST /api/medical-records
```

```json
{
  "patientId": 2,
  "doctorId": 1,
  "diagnosis": "Flu",
  "treatment": "Medication and rest"
}
```

#### Get All Records

```
GET /api/medical-records
```

#### Get Record By ID

```
GET /api/medical-records/{id}
```

#### Get Records By Patient

```
GET /api/medical-records/patient/{patientId}
```

#### Delete Record

```
DELETE /api/medical-records/{id}
```

---

### 🛠️ Admin APIs

* View system stats and manage users

#### View Dashboard Stats

```
GET /api/admin/dashboard
```

#### Get All Users

```
GET /api/admin/users
```

---

## 🧪 API Testing

* All APIs are tested using **Postman**
* Supports JSON request/response format
* Ensures proper validation and error handling

---

## 💡 Key Highlights

* RESTful API Design
* Layered Architecture (Controller → Service → Repository)
* Clean Code Practices
* Role-Based Access Control
* Database Integration using JPA
* Scalable and maintainable backend system

---

## ⚙️ How to Run the Project

1. Clone the repository

```
git clone <repo-url>
```

2. Configure database in `application.properties`

```
spring.datasource.url=jdbc:mysql://localhost:3306/healthcare
spring.datasource.username=root
spring.datasource.password=yourpassword
```

3. Run the Spring Boot application

```
mvn spring-boot:run
```

4. Access APIs at:

```
http://localhost:8080/api/
```

---

##  Future Enhancements

* JWT Authentication & Security
* Frontend Integration (React/Angular)
* Real-time notifications (Email/SMS integration)
* Doctor availability scheduling
* Payment integration

---

