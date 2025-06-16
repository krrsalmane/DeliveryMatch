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

## Diagrams
-  ![Use case Diagram](![Capture d'écran 2025-06-16 150040](https://github.com/user-attachments/assets/b3353500-ca20-4489-b728-3cd618211805)
)


-  [Classe Diagram](![Capture d'écran 2025-06-16 150107](https://github.com/user-attachments/assets/a16ca7b6-ae51-40c5-bc51-e3e4fbaaf46c)
)





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
