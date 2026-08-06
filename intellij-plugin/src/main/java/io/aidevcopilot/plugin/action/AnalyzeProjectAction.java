package io.aidevcopilot.plugin.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import io.aidevcopilot.plugin.project.model.ProjectAnalysisResult;
import io.aidevcopilot.plugin.project.service.ProjectAnalysisService;
import io.aidevcopilot.plugin.toolwindow.ToolWindowManager;

import javax.swing.*;

public class AnalyzeProjectAction extends AnAction {

    private final ProjectAnalysisService service =
            new ProjectAnalysisService();

    @Override
    public void actionPerformed(
            AnActionEvent event
    ) {

        Project project =
                event.getProject();

        if (project == null) {

            JOptionPane.showMessageDialog(
                    null,
                    "No project found.",
                    "AI Dev Copilot",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }

        ToolWindowManager.setTask(
                "Project Analysis"
        );

        ToolWindowManager.setStatus(
                "🟡 Scanning Project..."
        );

        ToolWindowManager.clearResponse();

        SwingWorker<ProjectAnalysisResult, Void> worker =
                new SwingWorker<>() {

                    @Override
                    protected ProjectAnalysisResult doInBackground() {

                        return service.analyze(
                                project
                        );

                    }

                    @Override
                    protected void done() {

                        try {

                            ProjectAnalysisResult result =
                                    get();

                            ToolWindowManager.showResponse(
                                    result.toString()
                            );

                            ToolWindowManager.setStatus(
                                    "🟢 Scan Complete"
                            );

                        } catch (Exception ex) {

                            ToolWindowManager.setStatus(
                                    "🔴 Error"
                            );

                            JOptionPane.showMessageDialog(
                                    null,
                                    ex.getMessage(),
                                    "AI Dev Copilot",
                                    JOptionPane.ERROR_MESSAGE
                            );

                        }

                    }

                };

        worker.execute();

    }

}