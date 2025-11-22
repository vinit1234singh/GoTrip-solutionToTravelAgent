# GO Trip – Travel Agency CRM & Booking Platform

GO Trip is a full-stack web application that provides a complete solution for travel agencies, combining tour package booking with CRM-style customer and lead management. It is built with a modern Spring Boot backend and an Angular frontend using Material UI and Tailwind CSS, and integrates secure online payments via Stripe.

## Key Features

- Tour package catalog with search and filtering.  
- Customer management (profiles, contact details, travel history).  
- Lead and enquiry tracking for travel agents.  
- Booking flow from package selection to payment.  
- Stripe-based secure online payments.  
- Role-based access (agent vs admin, configurable).  
- Responsive UI using Angular, Material UI and Tailwind CSS.  

## Tech Stack

- **Backend:** Java, Spring Boot, Spring Data JPA, REST APIs  
- **Frontend:** Angular, TypeScript, Angular Material, Tailwind CSS  
- **Database:** (configure as per your setup – e.g. MySQL/PostgreSQL)  
- **Payments:** Stripe API  
- **Build & Tools:** Maven/Gradle, Git  

## Project Structure

- `coreBackend/` – Spring Boot backend project  
  - REST controllers for packages, customers, bookings, and payments  
  - Service and repository layers for business logic and persistence  
  - Stripe integration for payment intents and webhooks  
- `standloneInterface/` – Angular frontend  
  - Components for package listing, booking flow, login, dashboard  
  - Material UI-based layout and Tailwind styling utilities  
  - Service classes for calling backend APIs  

## Getting Started

### Prerequisites

- Java 17+  
- Node.js and npm  
- Angular CLI  
- Maven or Gradle  
- A running relational database (e.g. MySQL/PostgreSQL)  
- Stripe account and API keys  

### Backend Setup (`coreBackend`)

1. Configure database connection in `application.properties` or `application.yml`.  
2. Add your Stripe API keys in the appropriate configuration or environment variables.  
3. Build and run the Spring Boot application:  
   - Using Maven: `mvn spring-boot:run`  
   - Or run the main application class from your IDE.  
4. Backend should start on the configured port (e.g. `http://localhost:8080`).

### Frontend Setup (`standloneInterface`)

1. Navigate to the frontend folder:  
   `cd standloneInterface`  
2. Install dependencies:  
   `npm install`  
3. Run the development server:  
   `ng serve`  
4. Open the app in the browser at `http://localhost:4200`.

## How It Works (High Level)

- Travel agents log in and manage tour packages, pricing, and availability.  
- Customers or agents can browse packages, view details, and initiate bookings.  
- When a booking is confirmed, the system creates a Stripe payment session and redirects to a secure checkout.  
- Payment status is synchronized back to the backend, which updates booking and CRM records.  

## Why This Project Matters

This project demonstrates the ability to:

- Design and implement a **real-world, production-style** domain (travel/CRM).  
- Build and document **clean REST APIs** in Spring Boot with layered architecture.  
- Create a **modern Angular UI** with Material components and utility-first styling (Tailwind).  
- Integrate and handle **third‑party payment gateways** (Stripe) end-to-end.  
- Work with **modular codebases** (separate backend and frontend) and Git-based workflows.

## Possible Improvements / Roadmap

- JWT-based authentication and refresh tokens.  
- Multi-tenant support for multiple travel agencies.  
- Advanced analytics dashboards for bookings and revenue.  
- Email/SMS notifications for booking confirmations and reminders.  
- Dockerization and CI/CD pipeline for deployment.  

## Contact

This project is part of a personal portfolio to showcase full‑stack Java + Angular skills for product-based companies and MNCs.

- **Author:** Vinit Singh  
- **GitHub:** [https://github.com/vinit1234singh](https://github.com/vinit1234singh)  
- **LinkedIn:** *(add your LinkedIn URL here)*  

---

If you share your database choice (e.g. MySQL with specific DB name) and how you configured Stripe, a customized “Configuration” section can be added to make it look even more production-ready.
