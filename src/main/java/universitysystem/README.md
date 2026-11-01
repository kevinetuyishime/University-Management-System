# University Student Management System

A simple Java console program that manages learners, subjects and registrations.
Data is saved in a PostgreSQL database.

## How to run

1. In pgAdmin, create a database named `University`.
2. Run `schema.sql` in its Query Tool to create the tables.
3. In `DbConnector.java`, put your PostgreSQL password.
4. Run `App.java` in IntelliJ.

## Menu

1. Add learner
2. List learners
3. Remove learner
4. Add subject
5. List subjects
6. Remove subject
7. Register learner in subject
8. Show learners with their subjects
9. Change a registration's subject
10. Exit