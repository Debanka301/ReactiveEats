
---

## 📚 Epics & User Stories

### ✅ Epic 1: Setup and Configuration
- **1.1**: Initialize Spring Boot Reactive Project with required dependencies
- **1.2**: Define core models – `User`, `MenuItem`, `Order`

---

### 🧍 Epic 2: User Module (CRUD + GraphQL)
- **2.1**: Create `UserRepository` using `ReactiveMongoRepository`
- **2.2**: Implement `UserRouter` and `UserHandler`
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
- **4.2**: Save Orders
- **4.3**: Stream Order status updates using SSE

---

### If MongoDB Doesn't start then open cmd as Admin and Type net start MongoDB

---
