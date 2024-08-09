# Student Accomodation

- The "Student Accomodation" project is a software application that aims to manage and monitor the process of student accommodation in university dormitories. This system provides an efficient and automated solution for recording personal data, contact information and other relevant details of students who wish to live in university dormitories.

- Through the application, students can fill out a registration form, providing information such as name, surname, gender, date of birth, email address, matriculation number, admission average and other necessary details. This information is stored in a central database, which can be accessed and updated by the staff responsible for managing the accommodation.

- Packages: model, repository, utility, frames
- The CamineEntity class is a model class that represents an entity within the database. This class is used to map the "homes" table from the "public" schema and the "xunyvuvx" catalog.
-  StudentiEntity class represents a student entity in a database and is annotated with JPA annotations for object-relational mapping

Methods:
- showAll(): This method retrieves all students from the students table using a named query named "StudentsShowAll". It creates an EntityManager, executes the query, and returns a list of StudentiEntity objects representing the students.

- showAllOrderByGender(): This method retrieves all students from the students table and orders them by gender using a named query named "StudentOrderByGender". It creates an EntityManager, executes the query, and returns a list of StudentiEntity objects representing the ordered students.

- ShowStudentsDormitory1(): This method retrieves all students from the home with index 1 (dormitory 1) using a named query named "ShowStudentsDormitory1". It creates an EntityManager, executes the query, and returns a list of StudentiEntity objects representing the students in dormitory 1.


- Validation Class contains methods for validating student information and determining their accommodation at a dormitory
- in frame package is the GUI for the application (Swing).

<img width="718" alt="poz1" src="https://github.com/CristinaaPichiu/StudentAccomodation/assets/118998541/1582032b-5246-41ea-bde3-b01a9b1c0fe2">
<img width="949" alt="poza2" src="https://github.com/CristinaaPichiu/StudentAccomodation/assets/118998541/1323c57b-5bde-47f7-ad01-5bbedbf906b2">
<img width="731" alt="poza3" src="https://github.com/CristinaaPichiu/StudentAccomodation/assets/118998541/36575685-c389-4cb8-a969-77c4e126e2f9">
