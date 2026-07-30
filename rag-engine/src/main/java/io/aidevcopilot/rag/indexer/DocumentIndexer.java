package io.aidevcopilot.rag.indexer;

import io.aidevcopilot.ports.model.Document;
import org.springframework.stereotype.Component;

@Component
public class DocumentIndexer implements Indexer {

    @Override
    public void index(Document document) {
        throw new UnsupportedOperationException("Document indexing not implemented yet.");
    }

}