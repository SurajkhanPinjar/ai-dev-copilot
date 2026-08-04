# AI Dev Copilot - API Test Data

This document contains sample API requests for testing all AI capabilities exposed by the backend.

Base URL

```
http://localhost:8080
```

---

# 1. Explain Code

**Endpoint**

```http
POST /api/v1/ai/tasks
```

**Request**

```json
{
  "task": "EXPLAIN_CODE",
  "input": "public class Addition { public int add(int a,int b){ return a+b; } }"
}
```

---

# 2. Bug Finder

**Endpoint**

```http
POST /api/v1/ai/tasks
```

**Request**

```json
{
  "task": "BUG_FINDER",
  "input": "public int divide(int a,int b){ return a/b; }"
}
```

---

# 3. Generate JavaDoc

**Endpoint**

```http
POST /api/v1/ai/tasks
```

**Request**

```json
{
  "task": "GENERATE_JAVADOC",
  "input": "public class Calculator { public int add(int a,int b){ return a+b; } }"
}
```

---

# 4. Code Optimizer

**Endpoint**

```http
POST /api/v1/ai/tasks
```

**Request**

```json
{
  "task": "OPTIMIZE_CODE",
  "input": "public int sum(int[] nums){ int s=0; for(int i=0;i<nums.length;i++){ s+=nums[i]; } return s; }"
}
```

---

# 5. Spring Boot Advisor

**Endpoint**

```http
POST /api/v1/ai/tasks
```

**Request**

```json
{
  "task": "SPRING_BOOT_ADVISOR",
  "input": "@RestController public class UserController { @Autowired private UserService userService; @GetMapping(\"/users\") public List<User> getUsers(){ return userService.findAll(); } }"
}
```

---

# 6. SQL Explainer

**Endpoint**

```http
POST /api/v1/ai/tasks
```

**Request**

```json
{
  "task": "SQL_EXPLAIN",
  "input": "SELECT u.name, COUNT(o.id) FROM users u JOIN orders o ON u.id=o.user_id WHERE o.status='COMPLETED' GROUP BY u.name ORDER BY COUNT(o.id) DESC;"
}
```

---

# 7. Architecture Reviewer

**Endpoint**

```http
POST /api/v1/ai/tasks
```

**Request**

```json
{
  "task": "ARCHITECTURE_REVIEWER",
  "input": "Design a Food Delivery System using Microservices. Services: User Service, Restaurant Service, Order Service, Payment Service, Delivery Service, Notification Service. Communication through Kafka. PostgreSQL per service. Redis for caching. API Gateway and Eureka Service Discovery."
}
```

---

# 8. Generate Unit Tests

**Endpoint**

```http
POST /api/v1/ai/tasks
```

**Request**

```json
{
  "task": "GENERATE_TESTS",
  "input": "public class Calculator { public int multiply(int a,int b){ return a*b; } }"
}
```

---

# 9. Code Review

**Endpoint**

```http
POST /api/v1/ai/tasks
```

**Request**

```json
{
  "task": "CODE_REVIEW",
  "input": "public class UserService { @Autowired UserRepository repository; public User get(Long id){ return repository.findById(id).get(); } }"
}
```

---

# 10. Chat with Uploaded Documents (RAG)

**Endpoint**

```http
POST /api/v1/ai/search
```

---

## What is Agile?

```json
{
  "question": "What is Agile?",
  "topK": 5
}
```

---

## Explain Scrum Roles

```json
{
  "question": "Explain Scrum roles.",
  "topK": 5
}
```

---

## Agile Principles

```json
{
  "question": "What are Agile principles?",
  "topK": 5
}
```

---

## Scrum vs Kanban

```json
{
  "question": "Difference between Scrum and Kanban?",
  "topK": 5
}
```

---

## CI/CD in Agile

```json
{
  "question": "What is CI/CD in Agile?",
  "topK": 5
}
```

---

# Feature Test Checklist

| Feature | Endpoint | Status |
|----------|----------|--------|
| Explain Code | `/api/v1/ai/tasks` | ✅ |
| Bug Finder | `/api/v1/ai/tasks` | ✅ |
| Generate JavaDoc | `/api/v1/ai/tasks` | ✅ |
| Code Optimizer | `/api/v1/ai/tasks` | ✅ |
| Spring Boot Advisor | `/api/v1/ai/tasks` | ✅ |
| SQL Explainer | `/api/v1/ai/tasks` | ✅ |
| Architecture Reviewer | `/api/v1/ai/tasks` | ✅ |
| Generate Unit Tests | `/api/v1/ai/tasks` | ✅ |
| Code Review | `/api/v1/ai/tasks` | ✅ |
| RAG Chat/Search | `/api/v1/ai/search` | ✅ |

---

# Expected Workflow

```
Client
   │
   ▼
REST API
   │
   ▼
Controller
   │
   ▼
ChatService
   │
   ▼
TaskRouter
   │
   ▼
PromptService
   │
   ▼
PromptBuilder
   │
   ▼
Ollama (Mistral)
   │
   ▼
AI Response
```

---

# RAG Workflow

```
Question
    │
    ▼
Embedding Generation
    │
    ▼
pgvector Similarity Search
    │
    ▼
Top-K Relevant Chunks
    │
    ▼
Prompt Builder
    │
    ▼
Mistral LLM
    │
    ▼
Final Answer
```

---

# Current Backend Capabilities

- ✅ Explain Code
- ✅ Bug Finder
- ✅ Generate JavaDoc
- ✅ Code Optimizer
- ✅ Spring Boot Advisor
- ✅ SQL Explainer
- ✅ Architecture Reviewer
- ✅ Generate Unit Tests
- ✅ Code Review
- ✅ Retrieval-Augmented Generation (RAG)
- ✅ Prompt Builder
- ✅ pgvector Similarity Search
- ✅ Ollama Integration
- ✅ REST APIs