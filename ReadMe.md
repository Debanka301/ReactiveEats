
---

## 📚 Epics & User Stories

### ✅ Epic 1: Setup and Configuration
- **1.1**: Initialize Spring Boot Reactive Project with required dependencies
- **1.2**: Define core models – `User`, `MenuItem`, `Order`

---

### 🧍 Epic 2: User Module (CRUD + GraphQL)
- **2.1**: Create `UserRepository` using `ReactiveMongoRepository`
- **2.2**: Implement `UserController` with REST endpoints:
  - `POST /users`
  - `GET /users`
  - `GET /users/{id}`
- **2.3**: Add GraphQL support for User:
  - Queries: `getUserById`, `allUsers`
  - Mutation: `createUser`

---

### 🍽 Epic 3: Menu Module (CRUD + Streaming + GraphQL)
- **3.1**: Create `MenuRepository`
- **3.2**: REST endpoints for Menu
- **3.3**: GraphQL queries/mutations for Menu
- **3.4**: Stream offers every 10 seconds via SSE

---

### 📦 Epic 4: Order Module (WebClient + SSE + GraphQL)
- **4.1**: Create `OrderRepository`
- **4.2**: `POST /orders` using WebClient to fetch User & Menu
- **4.3**: GraphQL: `createOrder(userId, menuItemId)`
- **4.4**: Stream Order status updates using SSE

---

### ♻️ Epic 5: Reactive Enhancements
- **5.1**: Add error handling with `.onErrorResume`, `.switchIfEmpty`
- **5.2**: Add logging throughout services
- **5.3**: Add retry & timeout logic in WebClient

---

### 🧪 Epic 6: Testing
- **6.1**: Unit test services with `StepVerifier`
- **6.2**: REST/SSE testing with `WebTestClient`
- **6.3**: GraphQL integration tests

---
