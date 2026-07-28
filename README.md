# 🚀 AI Dev Copilot

> AI-powered Backend Engineering Assistant for IntelliJ IDEA

AI Dev Copilot is an intelligent developer assistant focused on Java and Spring Boot development. It helps developers generate code, explain code, review repositories, answer questions over project documentation, and automate backend engineering tasks using Large Language Models (LLMs).

Unlike traditional code completion tools, AI Dev Copilot is designed to understand the **entire project** and assist with **real backend development workflows**.

---

# 🎯 Vision

Build an AI-powered engineering assistant capable of:

- Chatting with your codebase
- Generating production-ready code
- Reviewing repositories
- Explaining architecture
- Creating JavaDocs and Unit Tests
- Analyzing production logs
- Answering questions from project documentation (RAG)
- Working directly inside IntelliJ IDEA

---

# 🏗️ Project Architecture

```
ai-dev-copilot
│
├── ai-backend        # Spring Boot REST APIs
├── infrastructure    # Ollama, AI clients, external integrations
├── ai-core           # AI abstractions and business logic
├── rag-engine        # Retrieval-Augmented Generation (RAG)
├── shared            # Shared models and utilities
└── intellij-plugin   # IntelliJ IDEA Plugin (Future)
```

---

# 🛠️ Technology Stack

## Backend

- Java 21
- Spring Boot 3
- Spring Web
- Spring Validation
- Spring Actuator
- Springdoc OpenAPI (Swagger)

## AI

- LangChain4j
- Ollama
- Mistral
- Nomic Embeddings

## Future

- Qdrant
- PostgreSQL
- Docker
- IntelliJ Platform SDK

---

# 📂 Current Architecture

```
Client
   │
   ▼
ChatController
   │
   ▼
ChatService
   │
   ▼
AIChatClient
   │
   ▼
OllamaClient
   │
   ▼
LangChain4j
   │
   ▼
Ollama
```

---

# ✅ Features Implemented

## AI Chat

- Chat with local LLM
- LangChain4j Integration
- Ollama Integration
- Mistral Model Support

---

## REST API

- RESTful Chat Endpoint
- Request Validation
- Generic API Response
- Global Exception Handling
- Structured Logging

---

## API Documentation

- Swagger UI
- OpenAPI Documentation
- DTO Documentation

---

## Monitoring

- Spring Boot Actuator
- Health Endpoint
- Info Endpoint

---

# 📁 Current Modules

## ai-backend

Responsibilities

- REST Controllers
- Services
- Validation
- Exception Handling
- Swagger
- Actuator

---

## infrastructure

Responsibilities

- AI Clients
- Ollama Integration
- Configuration
- External Services

---

## ai-core

Responsibilities

- AI Business Logic
- Prompt Templates
- AI Task Routing

(Currently minimal)

---

## rag-engine

Responsibilities

- PDF Processing
- Chunking
- Embeddings
- Vector Search

(Future)

---

## shared

Responsibilities

- Common DTOs
- Utilities
- Shared Models

---

# 📌 Current APIs

## Chat

```
POST /api/v1/chat
```

Example

```json
{
  "prompt": "Explain Dependency Injection."
}
```

Response

```json
{
  "success": true,
  "timestamp": "...",
  "data": {
    "response": "..."
  }
}
```

---

# 📚 Documentation

Swagger

```
/swagger-ui/index.html
```

OpenAPI

```
/v3/api-docs
```

Health

```
/actuator/health
```

---

# 🗺️ Roadmap

## Phase 1 ✅

- Multi-module Maven
- Ollama Integration
- LangChain4j
- AI Chat
- REST APIs

---

## Phase 2 ✅

- Validation
- Generic Response
- Exception Handling
- Logging
- Swagger
- Actuator

---

## Phase 3 🚧

### AI Foundation

- Prompt Templates
- AI Task Routing
- Prompt Builder
- Conversation Memory
- Multi-Model Support

---

## Phase 4 🚧

### RAG Engine

- PDF Upload
- Text Extraction
- Chunking
- Embeddings
- Qdrant Integration
- Ask Questions from PDFs

---

## Phase 5 🚧

### Repository Analysis

Analyze entire repositories.

Features

- Project Structure
- Package Analysis
- REST API Discovery
- Service Relationships
- Database Usage
- Kafka Analysis
- Redis Analysis
- Dependency Graph
- Architecture Summary

---

## Phase 6 🚧

### Code Intelligence

- Explain Code
- Generate JavaDocs
- Generate Unit Tests
- Review Code
- Optimize Code
- Explain SQL
- Explain Stack Traces

---

## Phase 7 🚧

### Production Assistant

- Log Analysis
- Root Cause Analysis
- Exception Explanation
- Performance Suggestions

---

## Phase 8 🚧

### IntelliJ Plugin

The IntelliJ Plugin will interact with the backend to provide AI-powered development directly inside the IDE.

Capabilities

- Read Current File
- Read Selected Code
- Analyze Entire Project
- Create Files
- Update Files
- Rename Files
- Delete Files
- Generate Modules
- AI Chat
- Repository Chat

---

# 🔮 Long-Term Vision

```
Developer

      │

      ▼

IntelliJ Plugin

      │

      ▼

AI Dev Copilot Backend

      │

      ├── AI Chat
      ├── Repository Analysis
      ├── RAG
      ├── Code Review
      ├── Prompt Builder
      ├── Multi Model Support

      │

      ▼

Ollama / OpenAI / Claude
```

The IntelliJ Plugin will:

- Read project context
- Send requests to AI Dev Copilot
- Receive AI-generated code
- Apply changes directly to the project

Example

```
You:
Create Authentication Module

↓

Plugin scans repository

↓

Backend analyzes architecture

↓

AI generates

• Entity
• DTO
• Repository
• Service
• Controller
• Configuration
• Tests

↓

Plugin creates all files automatically
```

---

# 🎯 Project Goal

Build a production-grade AI Backend Engineering Assistant that helps Java developers:

- Write code faster
- Understand large codebases
- Generate documentation
- Review architecture
- Automate repetitive development tasks
- Work seamlessly inside IntelliJ IDEA

---

## 👨‍💻 Author

**Suraj**

AI Dev Copilot is being built as a modular, extensible platform for intelligent backend development using Java, Spring Boot, LangChain4j, and modern LLMs.