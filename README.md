# DeliveryMatch Platform

A platform connecting drivers and shippers for efficient delivery services.

## Project Structure

```
DeliveryMatch/
├── backend/                 # Spring Boot Backend
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   └── resources/
│   │   └── test/
│   └── pom.xml
│
└── frontend/               # Angular Frontend
    ├── src/
    │   ├── app/
    │   ├── assets/
    │   └── environments/
    └── package.json
```

## Technologies Used

### Backend
- Spring Boot
- Spring Data JPA
- Spring Security
- PostgreSQL/MySQL
- JUnit
- Docker
- Swagger/Postman

### Frontend
- Angular 16+
- Bootstrap/Tailwind
- Angular Material
- Chart.js

## Setup Instructions

### Backend Setup
1. Navigate to the backend directory
2. Run `mvn clean install`
3. Configure database in `application.properties`
4. Run the application using `mvn spring-boot:run`

### Frontend Setup
1. Navigate to the frontend directory
2. Run `npm install`
3. Run `ng serve` for development server

## Features
- User Authentication and Authorization
- Driver Route Management
- Shipper Package Management
- Admin Dashboard
- Real-time Notifications
- Rating System 