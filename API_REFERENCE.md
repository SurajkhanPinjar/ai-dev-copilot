# API Reference

This document describes all public REST APIs exposed by AI Dev Copilot.

**Base URL**

```
http://localhost:8080
```

---

# Authentication

> Current Status: Not Implemented

Future versions will support:

- JWT Authentication
- API Keys
- OAuth2

---

# Response Format

All APIs return a generic response.

```json
{
  "success": true,
  "timestamp": "2026-07-28T10:15:30",
  "data": {}
}
```

Error response

```json
{
  "success": false,
  "timestamp": "2026-07-28T10:15:30",
  "data": {
    "status": 400,
    "message": "Validation failed"
  }
}
```

---

# Chat APIs

## Generate AI Response

**Endpoint**

```
POST /api/v1/chat
```

### Description

Sends a prompt to the configured Large Language Model and returns the generated response.

---

### Request

```json
{
  "prompt": "Explain Dependency Injection."
}
```

---

### Validation

| Field | Required | Max Length |
|--------|----------|------------|
| prompt | Yes | 5000 |

---

### Success Response

```json
{
  "success": true,
  "timestamp": "...",
  "data": {
    "response": "Dependency Injection is..."
  }
}
```

---

### Status Codes

| Code | Meaning |
|------|---------|
|200|Success|
|400|Validation Error|
|500|Internal Server Error|

---

# Monitoring APIs

## Health

```
GET /actuator/health
```

Example

```json
{
    "status":"UP"
}
```

---

## Info

```
GET /actuator/info
```

Example

```json
{
    "app":{
        "name":"AI Dev Copilot",
        "version":"1.0.0"
    }
}
```

---

# OpenAPI

Swagger UI

```
/swagger-ui/index.html
```

OpenAPI Specification

```
/v3/api-docs
```

---

# Future APIs

## AI Tasks

```
POST /api/v1/tasks
```

Request

```json
{
    "task":"CODE_REVIEW",
    "input":"..."
}
```

Supported tasks

- CODE_REVIEW
- GENERATE_TESTS
- GENERATE_JAVADOC
- EXPLAIN_CODE
- OPTIMIZE_CODE
- EXPLAIN_SQL
- ANALYZE_STACKTRACE

---

## Repository Analysis

```
POST /api/v1/repository/analyze
```

---

## PDF Upload

```
POST /api/v1/rag/upload
```

---

## Ask PDF

```
POST /api/v1/rag/chat
```

---

## Repository Chat

```
POST /api/v1/repository/chat
```

---

## IntelliJ Plugin

The IntelliJ Plugin will consume these APIs to:

- Read project context
- Generate code
- Create files
- Update files
- Review repositories
- Generate documentation
- Analyze architecture

---

# Versioning

Current API Version

```
v1
```

Future versions will follow semantic versioning.

Example

```
/api/v1/...

/api/v2/...
```

---

# API Design Principles

- RESTful endpoints
- Consistent response format
- Request validation
- Structured error responses
- OpenAPI documentation
- Backward compatibility where possible

---

# Change Log

| Version | Changes |
|----------|---------|
|1.0.0|Initial Chat API|