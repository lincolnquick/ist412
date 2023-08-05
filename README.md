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
Use one of the following sample users with details to login to the application. After logging in with one of the following users, you may create add new Employees. Additional users can be registered as long as there are Employees that do not yet have a corresponding User login. 

Before you may "Register" as a new user, please login as an existing user and create a new Employee.

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

### Tabbed Navigation UI Pattern
The Tabbed Navigation UI pattern is implemented on every HTML page of our system.  Within the HTML for each tab are HREF links that indicate the target page.  Every controller file has a mapping that corresponds to the link for each page listed in the tabbed navigation.

## Code Refactoring
The following code refactors were implemented for the Two Use Case Assignment

### Register Link and Error Message
Lincoln Quick - Fixed issues with incorrect operation when the register link was clicked on.  The user is also presented with an error code if no user is present.

### Navigation Toolbar Refactor
Lincoln Quick - A code fragment was created and is referenced rather than copying the same code in each HTML file.

### Additional Code Supporting Business Practices Added

### Service Classes Had Unused Methods
Abraham Wagner - Removed methods from the Service package that had no usage.

### Employee Listing Page Refactor
Lincoln Quick - Reimagined employee display and removed redundant code.

### Employee Listings Split By Type
Lincoln Quick - Separated employees by type in display and code.

### Employee Permissions Revisited

### Employees Cannot be Created at Registration

### Random Number Generator Check
Abraham Wagner - Removed random number generator as the DB is implementing incremental numbering.

### Accountant and HRStaff Save Issue
Lincoln Quick - Troublshot code to enable saving of employees with HRStaff and Accountant designation.

## Contact Information
For help or further questions, contact IST 412 Group 5 via Microsoft Teams.

## License
This project is not under any specific license.
