# 🐳 Docker Commands (PostgreSQL + pgvector)

## 1. Verify Running Containers

```bash
docker ps
```

Example

```
CONTAINER ID   IMAGE                    NAME
be36c354b0ee   pgvector/pgvector:pg16   pgvector
a552f69be4dc   ollama/ollama            ollama
```

---

## 2. Open PostgreSQL Shell

```bash
docker exec -it pgvector psql -U postgres -d ragdb
```

Expected

```
psql (16.x)
Type "help" for help.

ragdb=#
```

---

## 3. Exit PostgreSQL

```sql
\q
```

---

## 4. List All Tables

```sql
\dt
```

Expected

```
             List of relations

 Schema |       Name        | Type  | Owner
--------+-------------------+-------+----------
 public | document_chunks   | table | postgres
```

---

## 5. Describe Table Structure

```sql
\d document_chunks
```

Expected

```
Column         Type
-----------------------------
id             uuid
document_id    varchar
page_number    integer
chunk_index    integer
content        text
embedding      vector(768)
created_at     timestamp
```

---

## 6. Verify Installed Extensions

```sql
\dx
```

Expected

```
vector
plpgsql
```

---

## 7. Verify Current Database

```sql
SELECT current_database();
```

Expected

```
 current_database
------------------
 ragdb
```

---

## 8. Verify PostgreSQL Version

```sql
SELECT version();
```

---

## 9. Show All Tables

```sql
SELECT table_name
FROM information_schema.tables
WHERE table_schema = 'public';
```

---

## 10. Check Total Rows

```sql
SELECT COUNT(*)
FROM document_chunks;
```

---

## 11. Remove All Data (Keep Table)

```sql
TRUNCATE TABLE document_chunks;
```

---

## 12. Drop Table (Development Only)

```sql
DROP TABLE IF EXISTS document_chunks CASCADE;
```

---

## 13. Recreate Table

```sql
CREATE TABLE document_chunks (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    document_id VARCHAR(255) NOT NULL,
    page_number INT NOT NULL,
    chunk_index INT NOT NULL,
    content TEXT NOT NULL,
    embedding VECTOR(768) NOT NULL,
    created_at TIMESTAMP NOT NULL
);
```

---

## 14. Verify Table Again

```sql
\d document_chunks
```

---

## 15. Verify Stored Chunks

```sql
SELECT COUNT(*)
FROM document_chunks;
```

---

## 16. Exit PostgreSQL

```sql
\q
```

---

# Useful Docker Commands

## View Running Containers

```bash
docker ps
```

## View All Containers

```bash
docker ps -a
```

## Start pgvector

```bash
docker start pgvector
```

## Stop pgvector

```bash
docker stop pgvector
```

## Restart pgvector

```bash
docker restart pgvector
```

## View PostgreSQL Logs

```bash
docker logs pgvector
```

## Follow PostgreSQL Logs

```bash
docker logs -f pgvector
```

## Open Bash Inside Container

```bash
docker exec -it pgvector bash
```

## Open PostgreSQL Directly

```bash
docker exec -it pgvector psql -U postgres -d ragdb
```

## Verify Ollama is Running

```bash
docker ps | grep ollama
```

## List Installed Ollama Models

```bash
docker exec -it ollama ollama list
```

Expected

```
NAME
mistral:latest
nomic-embed-text:latest
```

## Test Ollama API

```bash
curl http://localhost:11434/api/tags
```