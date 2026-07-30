package io.aidevcopilot.rag.chunk;

import io.aidevcopilot.ports.model.Document;
import io.aidevcopilot.rag.model.ChunkMetadata;
import io.aidevcopilot.rag.model.DocumentChunk;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
@Primary
public class FixedSizeChunkStrategy implements ChunkStrategy {

    private static final int CHUNK_SIZE = 500;
    private static final int OVERLAP = 100;

    @Override
    public List<DocumentChunk> chunk(Document document, String content) {

        List<DocumentChunk> chunks = new ArrayList<>();

        int start = 0;
        int chunkIndex = 0;

        while (start < content.length()) {

            int end = Math.min(start + CHUNK_SIZE, content.length());

            String chunkText = content.substring(start, end);

            ChunkMetadata metadata = new ChunkMetadata(
                    null,
                    chunkIndex,
                    document.name(),
                    Map.of()
            );

            DocumentChunk chunk = DocumentChunk.builder()
                    .documentId(document.id())
                    .pageNumber(1)          // Improve later if you preserve PDF page numbers
                    .chunkIndex(chunkIndex)
                    .content(chunkText)
                    .build();

            chunks.add(chunk);

            if (end == content.length()) {
                break;
            }

            start = end - OVERLAP;
            chunkIndex++;
        }

        return chunks;
    }
}