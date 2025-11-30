- This project is a backend clone of the Lovable.dev platform, built using Spring Boot, Java, and Maven.
- It provides APIs for user management, project collaboration, chat sessions, AI usage logging, subscription plans, billing, previews, and more.

## 🚀 Features Implemented
### User & Authentication
- User registration, login, password hashing
- User profile management
- Soft-delete support

### Projects & Collaboration
- Create, update, delete projects
- Users can own projects or be invited as:
    - EDITOR
    -  VIEWER
- Owner delegation & membership management

### Chat & AI Sessions
- Chat session creation per project
- Chat messages with:
    - roles
    - tool calls
    - token usage
- Usage logging per user/project

### Files & Previews
- Upload files (MinIO object store)
- Track preview pods, namespaces, and statuses

### Subscriptions
- Stripe subscription ID mapping
- Supports multiple plans with limits:
    - max projects
    - max tokens/day
    - previews
    - unlimited AI
- Subscription lifecycle support

## 🗂️ Architecture Overview
### Tech Stack
- Java 17+
- Spring Boot 3.x
- Maven
- Hibernate/JPA
- PostgreSQL/MySQL
- MinIO / S3
- Stripe 
- Docker
- Kubernetes 

## 📌 ER Diagram
- You can find the complete database ER diagram in:
```
    /docs/er-diagram.png
```