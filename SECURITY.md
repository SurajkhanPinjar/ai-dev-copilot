# Security Policy

## Supported Versions

The following versions of AI Dev Copilot receive security updates.

| Version | Supported |
| -------- | --------- |
| 1.x.x    | ✅ Yes |
| < 1.0.0  | ❌ No |

---

## Reporting a Vulnerability

If you discover a security vulnerability, please do **not** create a public GitHub issue.

Instead:

- Report it privately via GitHub Security Advisories (when enabled), or
- Contact the maintainer directly.

Please include:

- Description of the vulnerability
- Steps to reproduce
- Potential impact
- Suggested mitigation (if known)

We will:

- Acknowledge the report as soon as possible.
- Investigate and validate the issue.
- Work on a fix.
- Coordinate responsible disclosure before publishing details.

---

## Security Best Practices

AI Dev Copilot is designed with security in mind.

Current principles include:

- Input validation
- Global exception handling
- Structured logging
- Dependency management with Maven
- Secure configuration using environment variables
- No secrets stored in source code

Future improvements include:

- Authentication & Authorization
- API Rate Limiting
- HTTPS/TLS support
- Secret Management
- Prompt Injection Protection
- RAG Content Sanitization
- Dependency Vulnerability Scanning
- Security Headers
- Audit Logging

---

## Third-Party Components

AI Dev Copilot relies on several open-source libraries.

Examples include:

- Spring Boot
- LangChain4j
- Ollama
- IntelliJ Platform SDK

Please ensure these dependencies remain updated to receive the latest security patches.

---

## Disclosure Policy

We believe in responsible disclosure.

Security vulnerabilities will be fixed before public disclosure whenever possible.

Thank you for helping make AI Dev Copilot safer for everyone.