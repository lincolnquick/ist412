# Buffett Inc HRMS Project

## Description
The Buffett Inc HRMS is a Human Resources Management System. This system allows employees to view and manage employee information, payroll information, make and view paid time off (PTO) requests, view and complete trainings, as well as view and send messages. The system also includes specialized functions for managers, HR staff, and accountants.

## Prerequisites
The prerequisites for running this project are Java 17, Maven, MySQL and IntelliJ IDEA (Ultimate Edition).

## Setting Up the Project
Clone or download this project to your local system. Open the project in IntelliJ IDEA. Make sure you have the correct Java version installed and the project is properly configured to use it.

## Database Setup
Make sure MySQL Workbench is installed. Login using username "root" and password "ist412group5". Create a schema named "demo30".

## Running the Application
Run the HrmsApplication.java file from IntelliJ IDEA. The server will start and the application will be accessible from the web browser.

## Accessing the Application
Once the server is running, go to http://localhost:8080 in your web browser. You will be prompted to log in. Please note that functionality of the application is not complete and the views of the application are still under development.

## Running the Unit Tests
Unit tests are located in the test directory of the project (hrms/src/test). You can run them from IntelliJ IDEA or by running `mvn test` from the project's root directory.

## Authentication
Use one of the following sample users with details to login to the application. After logging in with one of the following users, you may Register a new user. New users will be defaulted to the 'Employee' role.

| Role | First Name | Last Name | Username | Password |
|-------- | -------- | -------- | -------- | -------- |
| Employee | Group5 | IST412 | user | password |
| Employee | King | Kong | kong | empire |
| Employee | Jim | Halpert | jhalpert | password |
| Employee | Dwight | Shrute | dshrute | password |
| Manager | Michael | Scott | mscott | password |
| HRStaff | Toby | Flenderson | toby | password |
| Accountant | Angela | Martin | amartin | password |

## Implemented Patterns
In this project, we have implemented two main patterns: the Observer behavioral pattern and the Dashboard View UI pattern.

### Observer Pattern
The Observer pattern is used to ensure that a particular state change in one part of the program can be automatically propagated to other interested parts of the program. In our application, the `NotificationService` class is an observable that other parts of the system observe. When a significant event occurs (such as a new PTO request or a payroll update), the `NotificationService` notifies all observers. Classes that act as observers include `Employee`, `Manager`, `HRStaff`, and `Accountant`.

### Dashboard View UI Pattern
The Dashboard View UI pattern is implemented in our system to present the main view for users after they log in. The `UserController.java` class along with the `dashboard.html` Thymeleaf template use this pattern to prepare and render the dashboard view, which gives users a quick overview of their most important information. This includes their tasks, messages, pending requests, and notifications.

## Contact Information
For help or further questions, contact IST 412 Group 5 via Microsoft Teams.

## License
This project is not under any specific license.
