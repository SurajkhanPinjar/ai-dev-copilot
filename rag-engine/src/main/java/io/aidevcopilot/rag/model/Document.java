package io.aidevcopilot.rag.model;

import lombok.Data;

import java.time.Instant;

public record Document(

        String id,

        String name,

        DocumentType type,

        String location,

        long size,

        Instant uploadedAt

) {
}