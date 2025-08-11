# Monetary Transactions API (Study Project)

A RESTful API designed to simulate monetary transactions between accounts, built following Clean Architecture principles and design patterns. This project simulates a real-world software engineering scenario and serves as a study initiative to explore, deepen, and implement best practices in software engineering. Each concept used here was applied to enhance my understanding of those concepts.

# Concepts
- **Microservices Principles:** The database and API are deployed in separate Docker containers, emulating a microservices architecture. These components communicate over a Docker bridge network, facilitating isolated and scalable interactions.
- **Clean Architecture:** This project adheres to Clean Architecture principles to separate concerns, enhance testability, and maintainability. It ensures an API with minimal dependencies on frameworks and preserves a stable and isolated business logic layer.
- **SOLID Principles:** Applies SOLID object-oriented design principles to create a flexible and scalable system.
- **Design Patterns:** Implements repository pattern, factory pattern, dependency injection, strategy pattern, domain model pattern, and application service pattern.
- **CI Pipeline:** GitHub Actions automates the build, test, and integration processes, ensuring that code changes are reliably merged into the main branch. Automated testing verifies the stability of each integration, facilitating consistent and efficient development workflows.
- **Docker/Virtualization:** Docker and Docker Compose are utilized to simulate distinct server environments, running the database and API in isolated containers, which facilitates consistent development and testing environments.
- **Testing:** Includes unit tests covering core application logic to ensure reliability.
- **REST API:** Follows REST principles to provide clear and consistent HTTP endpoints.

# How to Clone and Run the Project

```bash
git clone https://github.com/R34ll/monetary-transactions-api
cd monetary-transactions-api
docker-compose up --build
cd api-backend
mvn test
