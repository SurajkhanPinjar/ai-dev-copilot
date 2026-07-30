package io.aidevcopilot.rag.indexer;


import io.aidevcopilot.ports.model.Document;

public interface Indexer {

    void index(Document document);

}