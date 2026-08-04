package io.aidevcopilot.plugin.toolwindow;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

public class AiToolWindowFactory implements ToolWindowFactory {

    @Override
    public void createToolWindowContent(
            @NotNull Project project,
            @NotNull ToolWindow toolWindow
    ) {

        AiToolWindowPanel panel = new AiToolWindowPanel();

        Content content = ContentFactory
                .getInstance()
                .createContent(panel, "", false);

        toolWindow
                .getContentManager()
                .addContent(content);
    }
}