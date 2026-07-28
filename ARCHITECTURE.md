# Architecture

This document describes the architecture of AI Dev Copilot.

---

# High-Level Architecture

```
                    +----------------------+
                    | IntelliJ Plugin      |
                    | (Future)             |
                    +----------+-----------+
                               |
                               | REST API
                               |
                               ▼
                    +----------------------+
                    | AI Backend           |
                    | Spring Boot          |
                    +----------+-----------+
                               |
          +--------------------+--------------------+
          |                    |                    |
          ▼                    ▼                    ▼
   +--------------+     +---------------+    +---------------+
   | AI Core      |     | RAG Engine    |    | Infrastructure|
   +--------------+     +---------------+    +---------------+
          |                    |                    |
          ▼                    ▼                    ▼
    Prompt Builder      Vector Search       Ollama Client
    Task Router         Embeddings          AI Providers
    AI Services         PDF Processing      Configurations
          \                    |                    /
           \___________________|___________________/
                               |
                               ▼
                    +----------------------+
                    | Large Language Model |
                    | Ollama / OpenAI      |
                    | Claude / Gemini      |
                    +----------------------+
```

---

# Project Structure

```
ai-dev-copilot
│
├── ai-backend
├── ai-core
├── infrastructure
├── rag-engine
├── shared
└── intellij-plugin
```

---

# Module Responsibilities

## ai-backend

Purpose

Expose REST APIs.

Responsibilities

- REST Controllers
- Services
- Validation
- Swagger
- Actuator
- Exception Handling

Should NOT contain

- Prompt Engineering
- AI Logic
- Ollama Calls

---

## ai-core

Purpose

Contains AI business logic.

Responsibilities

- Prompt Templates
- Prompt Builder
- AI Task Routing
- Conversation Management
- AI Services

Should NOT contain

- HTTP Controllers
- External API Clients

---

## infrastructure

Purpose

Integrate external systems.

Responsibilities

- Ollama
- OpenAI
- Claude
- Configuration
- HTTP Clients
- Health Indicators

Should NOT contain

Business logic.

---

## rag-engine

Purpose

Knowledge Retrieval.

Responsibilities

- PDF Upload
- Text Extraction
- Chunking
- Embeddings
- Vector Search
- Retrieval

---

## shared

Purpose

Reusable components.

Responsibilities

- DTOs
- Enums
- Constants
- Utility Classes

---

## intellij-plugin

Purpose

Interact with IntelliJ IDEA.

Responsibilities

- Read Project
- Read Current File
- Read Selected Code
- Create Files
- Update Files
- Rename Files
- Delete Files
- Communicate with Backend

---

# Current Request Flow

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

# Future IntelliJ Flow

```
Developer

      │

      ▼

IntelliJ Plugin

      │

      ▼

Read Repository

      │

      ▼

AI Backend

      │

      ▼

Prompt Builder

      │

      ▼

LLM

      │

      ▼

Generated Code

      │

      ▼

Plugin Creates/Updates Files
```

---

# Design Principles

AI Dev Copilot follows these principles:

- Separation of Concerns
- Clean Architecture
- Modular Design
- Dependency Injection
- SOLID Principles
- Extensibility
- Testability

---

# Dependency Direction

```
ai-backend
      │
      ▼
ai-core
      │
      ▼
infrastructure
      │
      ▼
LLM
```

Shared module may be used by every module.

---

# Why This Architecture?

This modular approach provides:

- Independent development
- Easier testing
- Clear separation of responsibilities
- Future support for multiple AI providers
- Scalability
- Easier maintenance

---

# Future Architecture

```
                IntelliJ Plugin
                        │
                        ▼
              AI Dev Copilot Backend
                        │
        ┌───────────────┼────────────────┐
        ▼               ▼                ▼
    AI Engine      Repository AI      RAG Engine
        │               │                │
        └───────────────┼────────────────┘
                        ▼
                Prompt Orchestrator
                        │
        ┌───────────────┼─────────────────────┐
        ▼               ▼                     ▼
    Ollama          OpenAI API           Claude API
```

---

# Architecture Goals

- Support multiple AI providers
- Understand entire repositories
- Generate production-ready code
- Perform intelligent code reviews
- Analyze architecture
- Integrate seamlessly with IntelliJ IDEA
- Remain modular and easy to extend