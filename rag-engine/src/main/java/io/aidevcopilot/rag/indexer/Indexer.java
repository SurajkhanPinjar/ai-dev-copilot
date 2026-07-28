package io.aidevcopilot.rag.indexer;

import io.aidevcopilot.rag.model.Document;

public interface Indexer {

    void index(Document document);

}