# JobApplication-CRUD

Java JDBC CLI Application

# Job Application Management System

This codebase contains a Java application for managing job applications using a MySQL database. It provides
functionality to create a table, insert new job applications, update application status, delete applications, and
retrieve application information.

## Requirements

- Java Development Kit (JDK)
- MySQL Server
- MySQL Connector/J library

## Setup

1. Clone the repository to your local machine.

```shell
git clone https://github.com/SHabaj-dev/JobApplication-CRUD/tree/main
```

2. Ensure that you have Java Development Kit (JDK) installed on your system. You can download it from
   the [Oracle website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) and follow the
   installation instructions for your operating system.

3. Install and set up a MySQL server on your machine. You can download MySQL Community Server from
   the [MySQL website](https://dev.mysql.com/downloads/mysql/) and follow the installation instructions for your
   operating system.

4. Download the MySQL Connector/J library from
   the [MySQL Connector/J download page](https://dev.mysql.com/downloads/connector/j/), and add it to your Java
   project's classpath.

5. Update the database connection details in the `JobApplicationDAO` class according to your MySQL server configuration:

```java
private static final String DB_URL="jdbc:mysql://localhost:3306/jobApplications";
private static final String USERNAME="root";
private static final String PASSWORD="root";
```

Make sure to replace the `DB_URL`, `USERNAME`, and `PASSWORD` values with your MySQL server details.

6. Compile the Java classes using the following command:

```shell
javac Main.java
```

7. Run the application:

```shell
java Main
```

## Usage

Once the application is running, you will be presented with a menu to interact with the job application management
system. The available options are as follows:

- **1** - Insert a new job application
- **2** - Update application status
- **3** - View all applications
- **4** - Delete an application
- **5** - Get information for a specific company
- **0** - Exit the application

Follow the prompts and provide the required information for each action.

## Links

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [MySQL Community Server](https://dev.mysql.com/downloads/mysql/)
- [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/)

## Note

This codebase uses Java's built-in `java.sql` package for database connectivity. However, it is recommended to use a
higher-level database abstraction layer or an Object-Relational Mapping (ORM) framework for production applications to
ensure better security and maintainability.

## Maintainer

This codebase is maintained by [Shabaj Ansari](https://github.com/SHabaj-dev). If you have any questions or suggestions,
please feel free to contact me.
