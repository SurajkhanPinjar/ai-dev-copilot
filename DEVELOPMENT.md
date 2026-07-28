# Development Guide

This document explains the development workflow, project architecture, coding standards, and best practices for contributing to AI Dev Copilot.

---

# Project Overview

AI Dev Copilot is a modular Java application built using Spring Boot and LangChain4j.

The project follows a clean architecture with clear separation of responsibilities.

```
Client
    │
    ▼
Controller
    │
    ▼
Service
    │
    ▼
AI Core
    │
    ▼
Infrastructure
    │
    ▼
LLM Provider
```

---

# Modules

## ai-backend

Responsibilities

- REST APIs
- Controllers
- Services
- Validation
- Exception Handling
- Swagger
- Actuator

---

## infrastructure

Responsibilities

- Ollama Integration
- AI Client
- External Services
- Configuration

---

## ai-core

Responsibilities

- Prompt Builder
- AI Task Routing
- Conversation Management
- AI Business Logic

---

## rag-engine

Responsibilities

- PDF Processing
- Text Chunking
- Embeddings
- Vector Search

---

## shared

Responsibilities

- DTOs
- Constants
- Utilities
- Shared Models

---

# Development Workflow

When implementing a new feature:

1. Create DTOs
2. Add validation
3. Create service interface
4. Implement service
5. Add controller
6. Handle exceptions
7. Add logging
8. Document API using Swagger
9. Write tests
10. Update documentation

---

# Coding Standards

## Java

- Java 21
- Constructor Injection
- Avoid Field Injection
- Follow SOLID Principles
- Prefer Composition over Inheritance

---

## Spring Boot

Use

- @Service
- @Component
- @Configuration

Avoid unnecessary utility classes.

---

## Logging

Always use SLF4J.

```java
private static final Logger log =
        LoggerFactory.getLogger(MyClass.class);
```

Log

- Request received
- Processing started
- Processing completed
- Exceptions
- External API calls

Do not log sensitive information.

---

# Exception Handling

Use the global exception handler.

Avoid

```java
try {
}
catch(Exception e){
}
```

inside controllers.

---

# Validation

Use Jakarta Validation.

Example

```java
@NotBlank
@Size(max = 5000)
private String prompt;
```

Always validate incoming requests.

---

# API Design

Use RESTful endpoints.

Example

```
POST /api/v1/chat
```

Always return

```json
{
    "success": true,
    "timestamp": "...",
    "data": { }
}
```

Avoid returning raw strings.

---

# Project Structure

```
src/main/java

controller/

service/

service/impl/

dto/

config/

exception/

util/
```

---

# Branch Strategy

Suggested branches

```
main

develop

feature/<feature-name>

bugfix/<issue>

release/<version>
```

Example

```
feature/rag-engine

feature/intellij-plugin

feature/repository-analysis
```

---

# Commit Message Convention

Examples

```
feat: add chat endpoint

feat: integrate Ollama client

fix: handle validation errors

refactor: simplify AI client

docs: update roadmap

test: add chat service tests
```

---

# Testing

Preferred

- JUnit 5
- Mockito

Test

- Controllers
- Services
- AI Components
- Exception Handling

---

# Documentation

Whenever a feature is completed:

Update

- README.md
- ROADMAP.md
- CHANGELOG.md

If setup changes:

Update

- INSTALLATION.md

---

# Future Development Phases

## Phase 3

- Prompt Templates
- AI Task Routing
- Prompt Builder
- Conversation Memory

---

## Phase 4

- RAG
- PDF Upload
- Embeddings
- Vector Search

---

## Phase 5

- Repository Analysis

---

## Phase 6

- IntelliJ Plugin

---

## Phase 7

- Multi-Model Support

---

## Phase 8

- Production Assistant

---

# Definition of Done

A feature is considered complete when:

- Code compiles
- Tests pass
- Logging added
- Validation added
- Exceptions handled
- Swagger updated
- Documentation updated
- Code reviewed

---

# Useful Commands

Build

```bash
mvn clean install
```

Run Backend

```bash
cd ai-backend
mvn spring-boot:run
```

Run Tests

```bash
mvn test
```

Clean

```bash
mvn clean
```

---

# Project Philosophy

AI Dev Copilot aims to be more than an AI chat application.

It is being designed as an intelligent backend engineering assistant capable of understanding projects, generating production-ready code, analyzing repositories, assisting with architecture decisions, and integrating directly into IntelliJ IDEA to improve developer productivity.