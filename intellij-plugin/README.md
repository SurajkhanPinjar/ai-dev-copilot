# 🤖 AI Dev Copilot - IntelliJ IDEA Plugin

An AI-powered IntelliJ IDEA plugin that integrates with the AI Dev Copilot Spring Boot backend to provide intelligent code assistance directly inside the IDE.

The plugin allows developers to explain code, detect bugs, review code, generate JavaDocs, optimize code, generate tests, and chat with an AI-powered RAG system without leaving IntelliJ.

---

# Features

## AI Chat (RAG)

- Ask any software engineering question
- Retrieves relevant documents using PGVector
- Generates answers using Ollama (Mistral)

Example

```
What is Agile?
```

---

## Explain Code

Select Java code and explain

- Purpose
- Step-by-step execution
- Classes & Methods
- Design Patterns
- SOLID Principles
- Time Complexity
- Space Complexity
- Best Practices
- Improvements

---

## Bug Finder

Detects

- Bugs
- Runtime Exceptions
- Null Pointer Risks
- Concurrency Issues
- Security Issues
- Performance Problems

Provides improved code suggestions.

---

## Code Review

Reviews code for

- Code Smells
- Performance
- Security
- Best Practices
- Maintainability

---

## Generate JavaDoc

Automatically generates production-ready JavaDoc.

---

## Generate Tests

Generates

- JUnit 5 Tests
- Mockito Tests
- Edge Cases
- Test Coverage Suggestions

---

## Optimize Code

Suggests

- Performance Improvements
- Cleaner Code
- Better Algorithms
- Java Best Practices

---

## Spring Boot Advisor

Reviews Spring Boot code

Suggests

- Better Dependency Injection
- REST API Improvements
- Transaction Management
- Validation
- Exception Handling
- Security Improvements

---

## SQL Explainer

Explains SQL queries

- Query Flow
- Execution
- Performance
- Index Suggestions
- Optimization

---

## Architecture Reviewer

Reviews High-Level System Design

Provides suggestions about

- Scalability
- Availability
- Fault Tolerance
- Database Design
- Microservices
- Distributed Systems
- Security

---

# Plugin Architecture

```
IntelliJ IDEA
        │
        ▼
Editor
        │
        ▼
Right Click Action
        │
        ▼
AIAction
        │
        ▼
PluginChatService
        │
        ▼
AiBackendClient
        │
        ▼
HTTP REST API
        │
        ▼
Spring Boot Backend
        │
        ▼
Prompt Builder
        │
        ▼
Ollama (Mistral)
        │
        ▼
Generated Response
        │
        ▼
Tool Window
```

---

# Tool Window

The plugin contains a dedicated AI Tool Window.

Features

- Prompt Input
- AI Response
- Current Task
- Current Model
- Backend Status
- Copy Response
- Clear Response
- Scrollable Output
- Thinking Status

---

# Plugin UI

```
----------------------------------------------------------

🤖 AI Dev Copilot

Status : 🟢 Connected

Task   : Explain Code

Model  : Mistral (Ollama)

----------------------------------------------------------

Prompt

+--------------------------------------------+

Explain this code...

+--------------------------------------------+

[ Ask AI ] [ Copy ] [ Clear ]

----------------------------------------------------------

AI Response

+--------------------------------------------+

Purpose

Step-by-step

Complexity

Improvements

...

+--------------------------------------------+

----------------------------------------------------------
```

---

# Plugin Flow

## Explain Code

```
Select Code

↓

Right Click

↓

Explain Code

↓

AIAction

↓

PluginChatService

↓

AiBackendClient

↓

Spring Boot

↓

Prompt Builder

↓

Ollama

↓

Response

↓

Tool Window
```

---

## AI Chat

```
Prompt

↓

Ask AI

↓

Spring Boot

↓

Query Embedding

↓

PGVector Search

↓

Top K Chunks

↓

Prompt Builder

↓

Ollama

↓

Response

↓

Tool Window
```

---

# Package Structure

```
plugin

├── action
│
│   ├── AIAction
│   ├── ExplainCodeAction
│   ├── BugFinderAction
│   ├── CodeReviewAction
│   ├── GenerateJavaDocAction
│   ├── GenerateTestsAction
│   ├── OptimizeCodeAction
│   ├── SpringAdvisorAction
│   ├── SqlExplainAction
│   └── ArchitectureReviewAction
│
├── client
│
│   └── AiBackendClient
│
├── dto
│
│   ├── SearchRequest
│   ├── SearchResponse
│   ├── TaskRequest
│   └── TaskResponse
│
├── model
│
│   └── AITask
│
├── service
│
│   └── PluginChatService
│
├── toolwindow
│
│   ├── AiToolWindowFactory
│   ├── AiToolWindowPanel
│   ├── ToolWindowManager
│   │
│   ├── components
│   │
│   │   ├── HeaderPanel
│   │   ├── PromptPanel
│   │   ├── ResponsePanel
│   │   └── ButtonPanel
│   │
│   └── ui
│
│       └── UIConstants
│
└── util
    └── SelectedCodeUtil
```

---

# Backend Communication

The plugin communicates with the Spring Boot backend using REST APIs.

## Chat

```
POST

/api/v1/ai/search
```

Request

```json
{
  "question": "What is Agile?",
  "topK": 5
}
```

---

## AI Tasks

```
POST

/api/v1/ai/tasks
```

Example

```json
{
  "task": "EXPLAIN_CODE",
  "input": "public int add(int a,int b){ return a+b; }"
}
```

---

# Technologies Used

## IntelliJ Plugin

- Java 21
- IntelliJ Platform SDK
- Swing
- Gradle
- OkHttp
- Jackson

## Backend

- Spring Boot
- Ollama
- Mistral
- PGVector
- PostgreSQL
- LangChain4j
- REST APIs

---

# Design Principles

The plugin follows

- Clean Architecture
- Separation of Concerns
- Reusable AIAction Base Class
- Modular UI Components
- Service Layer
- DTO Pattern
- Factory Pattern
- SOLID Principles

---

# Current Features

✅ AI Chat

✅ Explain Code

✅ Bug Finder

✅ Code Review

✅ JavaDoc Generator

✅ Generate Tests

✅ Code Optimizer

✅ Spring Boot Advisor

✅ SQL Explainer

✅ Architecture Reviewer

✅ Copy Response

✅ Clear Response

✅ Tool Window

✅ Backend Status

✅ Current Task

✅ Current Model

---

# Future Enhancements

- Markdown Rendering
- Streaming Responses
- Syntax Highlighting
- Keyboard Shortcuts
- Plugin Settings
- Model Selection
- Chat History
- Explain Stack Trace
- Project-wide Context
- AI Quick Fix
- Inline Code Suggestions
- Multi-LLM Support
- Marketplace Publishing

---

# End-to-End Workflow

```
Developer

↓

Select Code

↓

IntelliJ Plugin

↓

AI Action

↓

REST API

↓

Spring Boot Backend

↓

Prompt Engineering

↓

Ollama

↓

AI Response

↓

Tool Window

↓

Developer Productivity
```

---

# Project Status

Current Version

```
AI Dev Copilot Plugin v1.0
```

Status

```
Production Ready MVP
```

Overall Completion

```
95%
```

---

# Author

**Suraj Pinjar**

AI Dev Copilot

Built with ❤️ using Java, Spring Boot, Ollama, PGVector and IntelliJ Platform SDK.