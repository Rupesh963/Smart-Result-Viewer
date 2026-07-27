# Smart Result Viewer 🎓

A **Spring Boot 4 + Thymeleaf** web application to manage and view student academic results — built for schools/colleges to digitize result publishing. Admins can add student records with subject-wise marks, and students can securely view their results using their **Roll Number + Date of Birth**.

---

## ✨ Features

- **Admin Panel** – Add a new student along with subject-wise marks (subject name, marks obtained, max marks, grade, feedback) in a single form.
- **Dynamic Subject Rows** – Add multiple subjects/marks per student on the same form.
- **Student Result Lookup** – Students view their result by entering **Roll Number** and **Date of Birth** (acts as a simple authentication check).
- **Auto Result Calculation** – Total marks, total max marks, percentage, and Pass/Fail status (33% passing criteria) are calculated automatically.
- **Form Validation** – Server-side validation using Jakarta Bean Validation (`@NotBlank`, `@Email`, etc.) with error messages shown back on the form.
- **Help Page** – Static help/instructions page for users.
- **DTO ↔ Entity Mapping** – Clean separation using `ModelMapper` between form DTOs and JPA entities.

---

## 🛠️ Tech Stack

| Layer            | Technology                                  |
|------------------|----------------------------------------------|
| Language         | Java 21                                       |
| Framework        | Spring Boot 4.1.0                             |
| Web              | Spring MVC, Thymeleaf                         |
| Persistence      | Spring Data JPA (Hibernate)                   |
| Database         | MySQL                                         |
| Validation       | Spring Boot Starter Validation (Jakarta)      |
| Object Mapping   | ModelMapper 3.2.4                              |
| Boilerplate      | Lombok                                        |
| Build Tool       | Maven                                         |

---

## 📁 Project Structure

```
Smart-Result-Viewer/
├── src/main/java/com/smart/result/viewer/
│   ├── controller/
│   │   ├── PageController.java      # Home, view-result (GET/POST)
│   │   ├── AdminController.java     # Add-result (GET/POST)
│   │   └── HelpController.java      # Help page
│   ├── entity/
│   │   ├── Student.java             # Student entity (1 -> many Marks)
│   │   └── Mark.java                # Subject-wise marks entity
│   ├── dto/
│   │   ├── StudentForm.java         # Form-backing object for student
│   │   ├── MarkForm.java            # Form-backing object for marks
│   │   └── RequestResultForm.java   # Roll No. + DOB request form
│   ├── repository/
│   │   ├── StudentRepo.java
│   │   └── MarkRepo.java
│   └── config/
│       └── projrctConfig.java       # ModelMapper bean
├── src/main/resources/
│   ├── templates/
│   │   ├── Index.html
│   │   ├── view result.html
│   │   ├── result.html
│   │   ├── help.html
│   │   └── admin/add result.html
│   └── application.properties
└── pom.xml
```

---

## ⚙️ Getting Started

### Prerequisites
- Java 21+
- Maven (or use the included `mvnw` wrapper)
- MySQL Server running locally

### 1. Clone the repository
```bash
git clone https://github.com/Rupesh963/Smart-Result-Viewer.git
cd Smart-Result-Viewer
```

### 2. Configure the database
Create a MySQL database and update `src/main/resources/application.properties` with your own credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/<your_db_name>
spring.datasource.username=<your_mysql_username>
spring.datasource.password=<your_mysql_password>
```
> ⚠️ Hibernate is set to `ddl-auto=update`, so tables (`result_viewer_student`, `result_viewer_marks`) will be created automatically on first run.

### 3. Run the application
```bash
./mvnw spring-boot:run
```

The app will start on **http://localhost:8081**

---

## 🚀 Usage

| Route                    | Method | Description                              |
|---------------------------|--------|-------------------------------------------|
| `/`                        | GET    | Home page                                 |
| `/view-result`             | GET    | Show result lookup form                   |
| `/view-result`              | POST   | Fetch and display result by Roll No. + DOB|
| `/admin/add-result`        | GET    | Show admin form to add a new student      |
| `/admin/add-result-action` | POST   | Save student + marks to the database      |
| `/help`                    | GET    | Help/instructions page                    |

---

## 🗺️ Roadmap / Possible Improvements
- [ ] Add Spring Security-based admin login (currently `/admin/**` is open)
- [ ] Move DB credentials to environment variables instead of `application.properties`
- [ ] Add ability to edit/delete existing student records
- [ ] Generate downloadable PDF result card
- [ ] Add pagination/search in admin panel for large student lists

---

## 👤 Author

**Rupesh Kumar**
[GitHub](https://github.com/Rupesh963) • [LinkedIn](https://linkedin.com/in/rupesh-kumar-2a15b6299)

---

## 📄 License
This project is open-source and available for learning/personal use.

--

## 📸 Screenshots

<img width="1280" height="711" alt="Screenshot 2026-07-28 at 12 07 37 AM" src="https://github.com/user-attachments/assets/3fddae82-107c-4407-8e39-59d07da337db" />

<img width="1277" height="709" alt="Screenshot 2026-07-28 at 12 07 50 AM" src="https://github.com/user-attachments/assets/e7d600b5-b12c-4a4b-9d9a-3ef00c2dbfd9" />

<img width="1280" height="708" alt="Screenshot 2026-07-28 at 12 08 26 AM" src="https://github.com/user-attachments/assets/f5fd46af-272d-4416-83a4-37cfad325904" />

<img width="1280" height="669" alt="Screenshot 2026-07-28 at 12 08 44 AM" src="https://github.com/user-attachments/assets/a46cd76e-ef75-4bb9-927f-1fc38289a93e" />

<img width="1280" height="709" alt="Screenshot 2026-07-28 at 12 09 03 AM" src="https://github.com/user-attachments/assets/b8773c1a-1d1c-4e22-91f6-bf7f058fbd2c" />

<img width="1280" height="709" alt="Screenshot 2026-07-28 at 12 09 14 AM" src="https://github.com/user-attachments/assets/3cb49ac0-2bf7-411c-9d97-777d57ddc085" />

<img width="540" height="766" alt="Screenshot 2026-07-28 at 12 20 17 AM" src="https://github.com/user-attachments/assets/a3c820b0-06c6-4144-8d3c-c898e1f3d95e" />







