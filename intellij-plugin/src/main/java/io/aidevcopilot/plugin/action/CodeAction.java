package io.aidevcopilot.plugin.action;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Editor;
import io.aidevcopilot.plugin.util.SelectedCodeUtil;

public abstract class CodeAction extends AIAction {

    @Override
    protected Editor getEditor(
            AnActionEvent event
    ) {

        return event.getData(
                CommonDataKeys.EDITOR
        );

    }

    @Override
    protected String getInput(
            AnActionEvent event
    ) {

        return getSelectedCode(
                getEditor(event)
        );

    }

    /**
     * Returns the currently selected code.
     */
    protected String getSelectedCode(
            Editor editor
    ) {

        if (editor == null) {
            throw new IllegalArgumentException(
                    "Editor not found."
            );
        }

        String selectedCode =
                SelectedCodeUtil.getSelectedCode(
                        editor
                );

        if (selectedCode == null ||
                selectedCode.isBlank()) {

            throw new IllegalArgumentException(
                    "Please select some code."
            );

        }

        return selectedCode;

    }

    /**
     * Returns true if editor has a valid selection.
     */
    protected boolean hasSelection(
            Editor editor
    ) {

        return editor != null &&
                editor.getSelectionModel()
                        .hasSelection();

    }

    @Override
    public void update(
            AnActionEvent event
    ) {

        Editor editor =
                getEditor(event);

        event.getPresentation()
                .setEnabledAndVisible(
                        hasSelection(editor)
                );

    }

}