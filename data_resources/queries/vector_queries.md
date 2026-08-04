````markdown
# 📚 RAG Document Ingestion Verification Guide

This document contains SQL queries to verify that the complete **RAG Document Ingestion Pipeline** is working correctly.

---

# 1. Verify Total Stored Chunks

Checks how many chunks are stored in the vector database.

```sql
SELECT COUNT(*) AS total_chunks
FROM document_chunks;
```

### Expected Output

```
 total_chunks
--------------
13
```

---

# 2. View All Stored Chunks

Displays every chunk stored for all uploaded documents.

```sql
SELECT
    chunk_index,
    page_number,
    content
FROM document_chunks
ORDER BY chunk_index;
```

---

# 3. Preview Chunk Content

Shows only the first 100 characters of each chunk.

```sql
SELECT
    chunk_index,
    LEFT(content, 100) AS preview
FROM document_chunks
ORDER BY chunk_index;
```

Example

```
0   Agile Manifesto...
1   Individuals and interactions...
2   Working software...
```

---

# 4. Verify Embedding Dimensions

Ensures Ollama generated embeddings with the expected dimensions.

```sql
SELECT
    chunk_index,
    vector_dims(embedding) AS dimensions
FROM document_chunks;
```

### Expected

```
768
768
768
...
```

---

# 5. Verify Embedding Norm

Checks that embeddings are valid vectors.

```sql
SELECT
    chunk_index,
    vector_norm(embedding)
FROM document_chunks
LIMIT 5;
```

### Expected

```
19.23
18.91
19.44
...
```

Should **NOT** be

```
0
```

or

```
NULL
```

---

# 6. List Stored Documents

Displays every document currently indexed.

```sql
SELECT DISTINCT
    document_id
FROM document_chunks;
```

---

# 7. Count Chunks Per Document

Useful when multiple PDFs have been uploaded.

```sql
SELECT
    document_id,
    COUNT(*) AS chunks
FROM document_chunks
GROUP BY document_id;
```

Example

```
document_id                           chunks
-----------------------------------   ------
70b4e3cb-c894...                      13
```

---

# 8. Verify Page Distribution

Checks how chunks are distributed across pages.

```sql
SELECT
    page_number,
    COUNT(*) AS chunks
FROM document_chunks
GROUP BY page_number
ORDER BY page_number;
```

---

# 9. Verify Chunk Sizes

Useful for validating the chunking strategy.

```sql
SELECT
    chunk_index,
    LENGTH(content) AS characters
FROM document_chunks
ORDER BY chunk_index;
```

Example

```
Chunk 0 -> 850 chars
Chunk 1 -> 910 chars
Chunk 2 -> 875 chars
```

---

# 10. View Raw Embedding

Displays the stored embedding vector.

```sql
SELECT
    embedding
FROM document_chunks
LIMIT 1;
```

Example

```
[-0.0123,0.4456,-0.0923,...]
```

---

# 11. Verify Similarity Search

Tests pgvector similarity search using the first stored embedding.

```sql
SELECT
    chunk_index,
    LEFT(content,100)
FROM document_chunks
ORDER BY embedding <=> (
    SELECT embedding
    FROM document_chunks
    LIMIT 1
)
LIMIT 5;
```

### Expected

```
Chunk 0
Chunk 1
Chunk 3
...
```

The first result should typically have **distance = 0**, because it is being compared with itself.

---

# 12. Verify Vector Distances

Displays cosine distance from the first stored chunk.

```sql
SELECT
    chunk_index,
    embedding <=> (
        SELECT embedding
        FROM document_chunks
        LIMIT 1
    ) AS distance
FROM document_chunks
ORDER BY distance
LIMIT 10;
```

Example

```
0.000
0.142
0.201
0.317
...
```

---

# 13. Delete an Indexed Document

Deletes all chunks belonging to a specific document.

```sql
DELETE FROM document_chunks
WHERE document_id =
'70b4e3cb-c894-4899-a0d3-1efc739453d9';
```

---

# 14. Verify Deletion

```sql
SELECT COUNT(*)
FROM document_chunks;
```

---

# ⭐ End-to-End Retrieval Verification

This query simulates what the application will eventually execute from `PgVectorStore.searchSimilar()`.

```sql
SELECT
    document_id,
    chunk_index,
    LEFT(content,120) AS preview,
    embedding <=> (
        SELECT embedding
        FROM document_chunks
        LIMIT 1
    ) AS distance
FROM document_chunks
ORDER BY distance
LIMIT 5;
```

### Success Criteria

- ✅ pgvector extension is working
- ✅ Embeddings are stored correctly
- ✅ Cosine similarity search works
- ✅ Retrieval returns the nearest chunks
- ✅ Vector database is production-ready

---

# 🚀 Current Project Progress

## ✅ Phase 1 — Document Upload

- Upload API
- Swagger Integration
- Multipart File Upload

---

## ✅ Phase 2 — File Storage

- Local File Storage
- Document Metadata
- Storage Service

---

## ✅ Phase 3 — Document Parsing

- PDF Parser
- Parser Factory
- Parser Strategy Pattern

---

## ✅ Phase 4 — Chunking

- Fixed Size Chunk Strategy
- Document Chunk Model

---

## ✅ Phase 5 — Embedding Generation

- Ollama Integration
- nomic-embed-text Model
- 768-Dimensional Embeddings

---

## ✅ Phase 6 — Vector Storage

- PostgreSQL
- pgvector Extension
- JDBC-based Vector Store
- Similarity Search SQL

---

# 📊 Current Architecture

```
                Upload API
                     │
                     ▼
            Document Controller
                     │
                     ▼
             Document Service
                     │
                     ▼
             Rag Orchestrator
                     │
      ┌──────────────┴──────────────┐
      ▼                             ▼
 File Storage                 Ingestion Pipeline
                                     │
                                     ▼
                             Document Parser
                                     │
                                     ▼
                               Chunk Service
                                     │
                                     ▼
                           Ollama Embedding Model
                                     │
                                     ▼
                           PostgreSQL + pgvector
```

---

# 🎯 Next Phase — Retrieval Pipeline

```
User Question
       │
       ▼
Generate Query Embedding
       │
       ▼
pgvector Similarity Search
       │
       ▼
Retrieve Top-K Chunks
       │
       ▼
Prompt Builder
       │
       ▼
Mistral LLM
       │
       ▼
Final AI Answer
```

This is the final major step to transform the current ingestion pipeline into a complete end-to-end RAG system.
````