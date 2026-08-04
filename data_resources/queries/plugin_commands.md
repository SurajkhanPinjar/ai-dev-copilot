# 🚀 AI Dev Copilot IntelliJ Plugin Commands

This document contains the Gradle commands used during the development, testing, packaging, and deployment of the IntelliJ Plugin.

---

# Prerequisites

- Java 21
- Gradle 8.13+
- IntelliJ IDEA Community/Ultimate
- Spring Boot Backend Running
- Ollama Running (if using local LLM)

Verify Java

```bash
java -version
```

Verify Gradle

```bash
./gradlew --version
```

---

# Clean Project

Deletes previous build artifacts.

```bash
./gradlew clean
```

---

# Build Plugin

Compiles the plugin.

```bash
./gradlew build
```

---

# Run IntelliJ Sandbox

Launches a temporary IntelliJ IDEA with the plugin installed.

```bash
./gradlew runIde
```

This is the primary command used during development.

---

# Build Plugin ZIP

Creates an installable plugin ZIP.

```bash
./gradlew buildPlugin
```

Output

```
build/
└── distributions/
    └── intellij-plugin-1.0.0.zip
```

---

# Clean + Build Plugin

Recommended before creating a release.

```bash
./gradlew clean buildPlugin
```

---

# Verify Plugin Configuration

Checks plugin configuration.

```bash
./gradlew verifyPluginProjectConfiguration
```

---

# Verify Plugin Structure

Validates plugin.xml and plugin archive.

```bash
./gradlew verifyPluginStructure
```

---

# Verify Binary Compatibility

Runs IntelliJ Plugin Verifier.

```bash
./gradlew verifyPlugin
```

---

# Instrument Plugin Classes

Runs IntelliJ bytecode instrumentation.

```bash
./gradlew instrumentCode
```

---

# Generate Plugin Manifest

```bash
./gradlew generateManifest
```

---

# Prepare Sandbox

Creates IntelliJ sandbox.

```bash
./gradlew prepareSandbox
```

---

# List Available Tasks

```bash
./gradlew tasks
```

---

# Show Dependencies

```bash
./gradlew dependencies
```

---

# Display Java Toolchains

```bash
./gradlew javaToolchains
```

---

# Print IntelliJ Bundled Plugins

```bash
./gradlew printBundledPlugins
```

---

# Publish Plugin (Marketplace)

Future command for Marketplace publishing.

```bash
./gradlew publishPlugin
```

---

# Full Release Build

Recommended before GitHub release.

```bash
./gradlew clean verifyPluginProjectConfiguration verifyPluginStructure buildPlugin
```

---

# Development Workflow

## Start Backend

```bash
cd ai-backend

./gradlew bootRun
```

Backend URL

```
http://localhost:8080
```

---

## Run IntelliJ Plugin

```bash
cd intellij-plugin

./gradlew runIde
```

---

## Test Plugin

- Open Java project
- Open AI Dev Copilot Tool Window
- Select Java code
- Right Click
- Execute AI Action

---

## Build Release Plugin

```bash
./gradlew clean buildPlugin
```

Generated ZIP

```
build/distributions/
```

---

# Install Plugin

Open IntelliJ IDEA

```
Settings

↓

Plugins

↓

⚙

↓

Install Plugin from Disk...
```

Choose

```
build/distributions/intellij-plugin-1.0.0.zip
```

Restart IntelliJ.

---

# Frequently Used Commands

```bash
# Run plugin
./gradlew runIde

# Clean
./gradlew clean

# Build
./gradlew build

# Create ZIP
./gradlew buildPlugin

# Verify plugin
./gradlew verifyPlugin

# Plugin configuration
./gradlew verifyPluginProjectConfiguration

# Show tasks
./gradlew tasks
```

---

# Project Status

Current Version

```
AI Dev Copilot Plugin v1.0.0
```

Status

```
Production Ready MVP
```

```
Development → Testing → Packaging → Installation → Release
```