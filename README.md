# 🏦 Online Banking Portal

A Java-based Online Banking Portal developed using Servlets, HTML, CSS, JavaScript, and Maven. This project is designed to demonstrate a complete DevOps CI/CD workflow using Git, Jenkins, Apache Tomcat, Docker, and Kubernetes on Oracle Linux.

---

## 🚀 Features

- Customer Registration
- Customer Login
- Dashboard
- Deposit Money (Upcoming)
- Withdraw Money (Upcoming)
- Transfer Money (Upcoming)
- Transaction History (Upcoming)
- Profile Management (Upcoming)

---

## 🛠️ Tech Stack

### Frontend

- HTML5
- CSS3
- JavaScript

### Backend

- Java 17
- Servlet API
- JDBC

### Build Tool

- Maven

### Database

- MySQL (Integration Coming)

### Web Server

- Apache Tomcat

### Version Control

- Git
- GitHub

### DevOps

- Jenkins
- Docker
- Kubernetes

---

## 📂 Project Structure

OnlineBankingPortal/

    src/
        main/
            java/
                com/
                    banking/
                        controller/
                        service/
                        dao/
                        model/
                        util/

            webapp/
                css/
                js/
                WEB-INF/

    pom.xml
    Dockerfile
    Jenkinsfile
    README.md

---

## ⚙️ Requirements

- Java 17
- Maven
- Apache Tomcat 10
- Git
- Oracle Linux Server
- Jenkins
- Docker (Optional)
- Kubernetes (Optional)

---

## 🔨 Build Project

```bash
mvn clean package
```

WAR file will be generated in:

```text
target/OnlineBankingPortal.war
```

---

## 🚀 Deploy to Tomcat

Copy WAR file:

```bash
cp target/OnlineBankingPortal.war /opt/tomcat/webapps/
```

Restart Tomcat:

```bash
sudo systemctl restart tomcat
```

Open browser:

```text
http://SERVER-IP:8080/OnlineBankingPortal
```

---

## 🔄 Jenkins Pipeline

1. Push code to GitHub
2. Jenkins clones repository
3. Maven builds WAR file
4. WAR deployed to Tomcat
5. Application becomes available automatically

---

## 🐳 Docker (Coming Soon)

```bash
docker build -t onlinebank .
docker run -p 8080:8080 onlinebank
```

---

## ☸️ Kubernetes (Coming Soon)

```bash
kubectl apply -f deployment.yaml
kubectl apply -f service.yaml
```

---

## 👨‍💻 Developed By

**Ratan Ahire**

Learning Java, DevOps, Jenkins, Docker, Kubernetes, and Cloud Technologies.

---

## 📌 Future Enhancements

- MySQL Database Integration
- Session Management
- Password Encryption (BCrypt)
- User Profile
- Admin Dashboard
- Email Notifications
- REST APIs
- JWT Authentication