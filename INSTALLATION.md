# Installation Guide

This guide explains how to set up AI Dev Copilot for local development.

---

# Prerequisites

Install the following tools before running the project.

## Java

- Java 21 or later

Verify:

```bash
java -version
```

---

## Maven

Verify:

```bash
mvn -version
```

---

## Git

Verify:

```bash
git --version
```

---

## Docker Desktop

Install Docker Desktop.

Verify:

```bash
docker --version
docker compose version
```

---

## Ollama

Install Ollama from:

https://ollama.com

Verify:

```bash
ollama --version
```

---

# Clone Repository

```bash
git clone <repository-url>
cd ai-dev-copilot
```

---

# Download Required Models

Chat Model

```bash
ollama pull mistral:latest
```

Embedding Model

```bash
ollama pull nomic-embed-text:latest
```

Verify:

```bash
ollama list
```

Expected:

```
mistral:latest
nomic-embed-text:latest
```

---

# Build Project

```bash
mvn clean install
```

---

# Run Backend

```bash
cd ai-backend

mvn spring-boot:run
```

or

Run `AiBackendApplication` from IntelliJ IDEA.

---

# Verify Application

Health

```
GET http://localhost:8080/actuator/health
```

Swagger

```
http://localhost:8080/swagger-ui/index.html
```

OpenAPI

```
http://localhost:8080/v3/api-docs
```

---

# Test Chat API

```
POST /api/v1/chat
```

Request

```json
{
  "prompt": "Explain Dependency Injection."
}
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

# Configuration

Example `application.yml`

```yaml
ollama:
  base-url: http://localhost:11434
  chat-model: mistral:latest
  embedding-model: nomic-embed-text:latest
```

---

# Troubleshooting

## Model Not Found

Download the required models.

```bash
ollama pull mistral:latest
```

---

## Ollama Not Running

Start Ollama.

```bash
ollama serve
```

---

## Port Already in Use

Find the process using port 8080.

macOS/Linux

```bash
lsof -i :8080
```

Kill the process if necessary.

---

## Maven Build Failure

Clean and rebuild.

```bash
mvn clean install
```

---

# Next Steps

- Explore the Swagger UI.
- Review the project architecture in `README.md`.
- Check upcoming milestones in `ROADMAP.md`.