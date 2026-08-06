package io.aidevcopilot.plugin.util;

import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;

public final class DocumentUtil {

    private DocumentUtil() {
    }

    public static Document getDocument(
            Editor editor
    ) {

        if (editor == null) {
            return null;
        }

        return editor.getDocument();
    }

}